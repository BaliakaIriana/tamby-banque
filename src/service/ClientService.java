package service;

import dao.GeneriqueDAO;
import model.Client;
import model.Detailcompte;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;

public class ClientService {
    private final GeneriqueDAO generiqueDAO = new GeneriqueDAO();
    public List<Detailcompte> getComptesClients(Long idclient) throws Exception {
        Detailcompte detailcompte = new Detailcompte();
        detailcompte.setIdclient(idclient);
        return (List<Detailcompte>) (List<?>) generiqueDAO.findWhere(detailcompte);
    }

    public Detailcompte getCompteClient(Long idclient, Long idbanque) throws Exception {
        Detailcompte detailcompte = new Detailcompte();
        detailcompte.setIdclient(idclient);
        detailcompte.setIdbanque(idbanque);
        List<Detailcompte> where = (List<Detailcompte>) (List<?>) generiqueDAO.findWhere(detailcompte);
        if(where.size() != 1){
            throw new Exception("Les données des comptes ne coïncident pas/comportent des erreurs! Veuillez contacter l'administrateur/le responsable.");
        }
        return where.get(0);
    }
    public Detailcompte getCompteClient(Long idclient, Long idbanque, Connection connection) throws Exception {
        Detailcompte detailcompte = new Detailcompte();
        detailcompte.setIdclient(idclient);
        detailcompte.setIdbanque(idbanque);
        List<Detailcompte> where = (List<Detailcompte>) (List<?>) generiqueDAO.findWhere(detailcompte,connection);
        if(where.size() != 1){
            throw new Exception("Les données des comptes ne coïncident pas/comportent des erreurs! Veuillez contacter l'administrateur/le responsable.");
        }
        return where.get(0);
    }

    public List<Client> getAll() throws IllegalAccessException, InstantiationException, SQLException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        return (List<Client>) (List<?>) generiqueDAO.findAll(new Client());
    }
}
