package service;

import dao.GeneriqueDAO;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class Fonction {
    private final GeneriqueDAO generiqueDAO = new GeneriqueDAO();
    private final ClientService clientService = new ClientService();

    public void transfert(Double montant, Long bSender, Long bReceveur, Long sender, Long receveur) throws Exception {
        Connection connection = null;
        try {
            connection = GeneriqueDAO.getConnection();
            connection.setAutoCommit(false);
            Detailcompte detailcompteSender = clientService.getCompteClient(sender, bSender, connection);
            Detailcompte detailcompteReceveur = clientService.getCompteClient(receveur, bReceveur, connection);
            if (montant <= 0) {
                throw new Exception("Montant invalide!");
            }
            Double soldeSender = getSolde(detailcompteSender, connection);
            Double montantToBanque = getMontantBanque(montant, detailcompteSender, detailcompteReceveur, connection);
            Double montantRetirer = montant + montantToBanque;
            if (montantRetirer > soldeSender) {
                throw new Exception("Votre solde bancaire ne permet pas d'effectuer la transaction.");
            }
            Situationdevise situationdevise = new Situationdevise();
            situationdevise.setDaty(Timestamp.from(Instant.now()));
            situationdevise.setIddevise(detailcompteSender.getIddevise());
            situationdevise.setDevIddevise(detailcompteReceveur.getIddevise());
            situationdevise.setMontant(getCurrency(detailcompteSender.getCodedevise(), detailcompteReceveur.getCodedevise()));
            situationdevise.setId(generiqueDAO.getSequenceValue(new Situationdevise(), connection));
            generiqueDAO.insert(situationdevise, connection);
            Mouvement mSend = new Mouvement();
            mSend.setId(generiqueDAO.getSequenceValue(new Mouvement(), connection));
            mSend.setDaty(Timestamp.from(Instant.now()));
            mSend.setIdsituation(situationdevise.getId());
            mSend.setRecepteur(detailcompteReceveur.getId());
            mSend.setSender(detailcompteSender.getId());
            mSend.setMontant(montant);
            generiqueDAO.insert(mSend, connection);
            Mouvement retirer = new Mouvement();
            retirer.setId(generiqueDAO.getSequenceValue(new Mouvement(), connection));

            retirer.setIdsituation(situationdevise.getId());
            retirer.setDaty(Timestamp.from(Instant.now()));
            retirer.setSender(detailcompteSender.getId());
            retirer.setMontant(montantToBanque);
            generiqueDAO.insert(retirer, connection);
            /**
             * TODO: mila le mi-insert anaty mouvement banque
             */
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private Double getMontantBanque(Double montant, Detailcompte detailcompteSender, Detailcompte detailcompteReceveur, Connection connection) throws Exception {
        Detailbq detailbq = new Detailbq();
        detailbq.setIdbanque(detailcompteSender.getIdbanque());
        List<Detailbq> where = (List<Detailbq>) (List<?>) generiqueDAO.findWhere(detailbq, connection);
        if (where.size() != 1) {
            throw new Exception("Une erreur de detailbq");
        }
        detailbq = where.get(0);
        if (detailcompteSender.getIdbanque().compareTo(detailcompteReceveur.getIdbanque()) == 0) {
            if (detailcompteSender.getIddevise().compareTo(detailcompteReceveur.getIddevise()) == 0) {
                return ((montant * detailbq.getTaux()) / 100);
            } else {
                return (((montant * detailbq.getTaux()) / 100) + detailbq.getCoutfixe() + ((montant * detailbq.getInteretchange())) / 100);
            }
        } else {
            /**
             * Rehefa tsy mitovy
             */
            if (detailcompteSender.getIddevise().compareTo(detailcompteReceveur.getIddevise()) == 0) {
                return ((montant * detailbq.getTaux()) / 100);
            } else {
                return (((montant * detailbq.getTaux()) / 100) + detailbq.getCoutfixe() + ((montant * detailbq.getInteretchange())) / 100);
            }
        }
    }

    private Double getSolde(Detailcompte detailcompteSender, Connection connection) throws Exception {
        Soldecalcule soldecalcule = new Soldecalcule();
        soldecalcule.setId(detailcompteSender.getId());
        soldecalcule = (Soldecalcule) generiqueDAO.findById(soldecalcule, connection);
        if (soldecalcule == null) {
            throw new Exception("Les données des comptes ne coïncident pas/comportent des erreurs! Veuillez contacter l'administrateur/le responsable.");
        }
        return soldecalcule.getSolde();
    }

    public void depot(Long banque, String montant, Long idclient) throws SQLException {
        Connection connection = null;
        try {
            connection = GeneriqueDAO.getConnection();
            connection.setAutoCommit(false);
            Detailcompte detailcompte = new Detailcompte();
            detailcompte.setIdclient(idclient);
            detailcompte.setIdbanque(Long.valueOf(banque));
            detailcompte = clientService.getCompteClient(idclient, banque, connection);

            Situationdevise situationdevise = new Situationdevise();
            situationdevise.setDaty(Timestamp.from(Instant.now()));
            situationdevise.setIddevise(detailcompte.getIddevise());
            situationdevise.setDevIddevise(detailcompte.getIddevise());
            situationdevise.setMontant(getCurrency(detailcompte.getCodedevise(), detailcompte.getCodedevise()));
            situationdevise.setId(generiqueDAO.getSequenceValue(new Situationdevise(), connection));
            generiqueDAO.insert(situationdevise, connection);

            Mouvement mouvement = new Mouvement();
            mouvement.setId(generiqueDAO.getSequenceValue(new Mouvement(), connection));
            mouvement.setIdsituation(situationdevise.getId());
            mouvement.setRecepteur(detailcompte.getId());
            mouvement.setDaty(Timestamp.from(Instant.now()));
            mouvement.setMontant(Double.valueOf(montant));
            generiqueDAO.insert(mouvement, connection);
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * @return
     */
    public double getCurrency(String CODE1, String CODE2) throws IOException {
        String source = "http://currencies.apps.grandtrunk.net/getlatest/" + CODE1 + "/" + CODE2 + "";
        URL url = new URL(source);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output = br.readLine();
        conn.disconnect();

        return Double.valueOf(output);
    }

    public Soldecalcule getSoldeBetweenTwoDates(String debut, String fin, Long idclient) throws Exception {
        List<Soldecalcule> soldecalcules = (List<Soldecalcule>) (List<?>) generiqueDAO.findQuery(new Soldecalcule(), "select\n" +
                "       RECEPTEUR AS IDCLIENT, SUM(MONTANT) as SOLDE\n" +
                "from (\n" +
                "       (select RECEPTEUR,SUM(M.MONTANT*S.MONTANT) as MONTANT from MOUVEMENT M join SITUATIONDEVISE S on M.IDSITUATION = S.IDSITUATION WHERE M.DATY BETWEEN to_timestamp('" + debut + "','dd-MM-YYYY') AND TO_TIMESTAMP('" + fin + "','dd-MM-YYYY') GROUP BY RECEPTEUR)\n" +
                "        union\n" +
                "       (select SENDER,-SUM(MONTANT) as MONTANT FROM MOUVEMENT M where SENDER IS NOT NULL AND M.DATY BETWEEN to_timestamp('" + debut + "','dd-MM-YYYY') AND TO_TIMESTAMP('" + fin + "','dd-MM-YYYY') GROUP BY SENDER)\n" +
                "     )\n" +
                "WHERE RECEPTEUR IS NOT NULL\n AND RECEPTEUR = " + idclient + "\n" +
                "GROUP BY RECEPTEUR");
        if (soldecalcules.size() != 1) {
            return new Soldecalcule(idclient,0D);
        }
        Soldecalcule soldecalcule = soldecalcules.get(0);
        Soldecalcule soldecalculeBefore = getSoldeBefore(debut,idclient);
        soldecalcule.setSolde(soldecalculeBefore.getSolde() + soldecalcule.getSolde());
        return soldecalcule;
    }
    public Soldecalcule getSoldeBefore(String debut, Long idclient) throws Exception {
        List<Soldecalcule> soldecalcule = (List<Soldecalcule>) (List<?>) generiqueDAO.findQuery(new Soldecalcule(), "select\n" +
                "       RECEPTEUR AS IDCLIENT, SUM(MONTANT) as SOLDE\n" +
                "from (\n" +
                "       (select RECEPTEUR,SUM(M.MONTANT*S.MONTANT) as MONTANT from MOUVEMENT M join SITUATIONDEVISE S on M.IDSITUATION = S.IDSITUATION WHERE M.DATY < to_timestamp('" + debut + "','dd-MM-YYYY') GROUP BY RECEPTEUR)\n" +
                "        union\n" +
                "       (select SENDER,-SUM(MONTANT) as MONTANT FROM MOUVEMENT M where SENDER IS NOT NULL AND M.DATY < to_timestamp('" + debut + "','dd-MM-YYYY') GROUP BY SENDER)\n" +
                "     )\n" +
                "WHERE RECEPTEUR IS NOT NULL\n AND RECEPTEUR = " + idclient + "\n" +
                "GROUP BY RECEPTEUR");
        if (soldecalcule.size() != 1) {
            return new Soldecalcule(idclient,0D);
        }
        return soldecalcule.get(0);
    }
}