package model;

import dao.annotations.Column;
import dao.annotations.Id;
import dao.annotations.Table;

import java.util.Objects;

@Table(name = "CLIENT")
public class Client extends ObjetMere{
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private Long janvier1;
    private Long fevrier1;
    private Long mars1;
    private Long avril1;
    private Long mai1;
    private Long juin1;
    private Long juillet1;
    private Long aout1;
    private Long septembre1;
    private Long octobre1;
    private Long novembre1;
    private Long decembre1;
    private Long janvier2;
    private Long fevrier2;
    private Long mars2;
    private Long avril2;
    private Long mai2;
    private Long juin2;
    private Long juillet2;
    private Long aout2;
    private Long septembre2;
    private Long octobre2;
    private Long novembre2;
    private Long decembre2;
    private Long janvier3;
    private Long fevrier3;
    private Long mars3;
    private Long avril3;
    private Long mai3;
    private Long juin3;
    private Long juillet3;
    private Long aout3;
    private Long septembre3;
    private Long octobre3;
    private Long novembre3;
    private Long decembre3;
    private Long janvier4;
    private Long fevrier4;
    private Long mars4;
    private Long avril4;
    private Long mai4;
    private Long juin4;
    private Long juillet4;
    private Long aout4;
    private Long septembre4;
    private Long octobre4;
    private Long novembre4;
    private Long decembre4;

    @Id
    @Column(name = "IDCLIENT")
    public Long getId() {
        return id;
    }

    public void setId(Long idclient) {
        this.id = idclient;
    }


    @Column(name = "NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Column(name = "PRENOM")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    @Column(name = "MDP")
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    @Column(name = "JANVIER1")
    public Long getJanvier1() {
        return janvier1;
    }

    public void setJanvier1(Long janvier1) {
        this.janvier1 = janvier1;
    }


    @Column(name = "FEVRIER1")
    public Long getFevrier1() {
        return fevrier1;
    }

    public void setFevrier1(Long fevrier1) {
        this.fevrier1 = fevrier1;
    }


    @Column(name = "MARS1")
    public Long getMars1() {
        return mars1;
    }

    public void setMars1(Long mars1) {
        this.mars1 = mars1;
    }


    @Column(name = "AVRIL1")
    public Long getAvril1() {
        return avril1;
    }

    public void setAvril1(Long avril1) {
        this.avril1 = avril1;
    }


    @Column(name = "MAI1")
    public Long getMai1() {
        return mai1;
    }

    public void setMai1(Long mai1) {
        this.mai1 = mai1;
    }


    @Column(name = "JUIN1")
    public Long getJuin1() {
        return juin1;
    }

    public void setJuin1(Long juin1) {
        this.juin1 = juin1;
    }


    @Column(name = "JUILLET1")
    public Long getJuillet1() {
        return juillet1;
    }

    public void setJuillet1(Long juillet1) {
        this.juillet1 = juillet1;
    }


    @Column(name = "AOUT1")
    public Long getAout1() {
        return aout1;
    }

    public void setAout1(Long aout1) {
        this.aout1 = aout1;
    }


    @Column(name = "SEPTEMBRE1")
    public Long getSeptembre1() {
        return septembre1;
    }

    public void setSeptembre1(Long septembre1) {
        this.septembre1 = septembre1;
    }


    @Column(name = "OCTOBRE1")
    public Long getOctobre1() {
        return octobre1;
    }

    public void setOctobre1(Long octobre1) {
        this.octobre1 = octobre1;
    }


    @Column(name = "NOVEMBRE1")
    public Long getNovembre1() {
        return novembre1;
    }

    public void setNovembre1(Long novembre1) {
        this.novembre1 = novembre1;
    }


    @Column(name = "DECEMBRE1")
    public Long getDecembre1() {
        return decembre1;
    }

    public void setDecembre1(Long decembre1) {
        this.decembre1 = decembre1;
    }


    @Column(name = "JANVIER2")
    public Long getJanvier2() {
        return janvier2;
    }

    public void setJanvier2(Long janvier2) {
        this.janvier2 = janvier2;
    }


    @Column(name = "FEVRIER2")
    public Long getFevrier2() {
        return fevrier2;
    }

    public void setFevrier2(Long fevrier2) {
        this.fevrier2 = fevrier2;
    }


    @Column(name = "MARS2")
    public Long getMars2() {
        return mars2;
    }

    public void setMars2(Long mars2) {
        this.mars2 = mars2;
    }


    @Column(name = "AVRIL2")
    public Long getAvril2() {
        return avril2;
    }

    public void setAvril2(Long avril2) {
        this.avril2 = avril2;
    }


    @Column(name = "MAI2")
    public Long getMai2() {
        return mai2;
    }

    public void setMai2(Long mai2) {
        this.mai2 = mai2;
    }


    @Column(name = "JUIN2")
    public Long getJuin2() {
        return juin2;
    }

    public void setJuin2(Long juin2) {
        this.juin2 = juin2;
    }


    @Column(name = "JUILLET2")
    public Long getJuillet2() {
        return juillet2;
    }

    public void setJuillet2(Long juillet2) {
        this.juillet2 = juillet2;
    }


    @Column(name = "AOUT2")
    public Long getAout2() {
        return aout2;
    }

    public void setAout2(Long aout2) {
        this.aout2 = aout2;
    }


    @Column(name = "SEPTEMBRE2")
    public Long getSeptembre2() {
        return septembre2;
    }

    public void setSeptembre2(Long septembre2) {
        this.septembre2 = septembre2;
    }


    @Column(name = "OCTOBRE2")
    public Long getOctobre2() {
        return octobre2;
    }

    public void setOctobre2(Long octobre2) {
        this.octobre2 = octobre2;
    }


    @Column(name = "NOVEMBRE2")
    public Long getNovembre2() {
        return novembre2;
    }

    public void setNovembre2(Long novembre2) {
        this.novembre2 = novembre2;
    }


    @Column(name = "DECEMBRE2")
    public Long getDecembre2() {
        return decembre2;
    }

    public void setDecembre2(Long decembre2) {
        this.decembre2 = decembre2;
    }


    @Column(name = "JANVIER3")
    public Long getJanvier3() {
        return janvier3;
    }

    public void setJanvier3(Long janvier3) {
        this.janvier3 = janvier3;
    }


    @Column(name = "FEVRIER3")
    public Long getFevrier3() {
        return fevrier3;
    }

    public void setFevrier3(Long fevrier3) {
        this.fevrier3 = fevrier3;
    }


    @Column(name = "MARS3")
    public Long getMars3() {
        return mars3;
    }

    public void setMars3(Long mars3) {
        this.mars3 = mars3;
    }


    @Column(name = "AVRIL3")
    public Long getAvril3() {
        return avril3;
    }

    public void setAvril3(Long avril3) {
        this.avril3 = avril3;
    }


    @Column(name = "MAI3")
    public Long getMai3() {
        return mai3;
    }

    public void setMai3(Long mai3) {
        this.mai3 = mai3;
    }


    @Column(name = "JUIN3")
    public Long getJuin3() {
        return juin3;
    }

    public void setJuin3(Long juin3) {
        this.juin3 = juin3;
    }


    @Column(name = "JUILLET3")
    public Long getJuillet3() {
        return juillet3;
    }

    public void setJuillet3(Long juillet3) {
        this.juillet3 = juillet3;
    }


    @Column(name = "AOUT3")
    public Long getAout3() {
        return aout3;
    }

    public void setAout3(Long aout3) {
        this.aout3 = aout3;
    }


    @Column(name = "SEPTEMBRE3")
    public Long getSeptembre3() {
        return septembre3;
    }

    public void setSeptembre3(Long septembre3) {
        this.septembre3 = septembre3;
    }


    @Column(name = "OCTOBRE3")
    public Long getOctobre3() {
        return octobre3;
    }

    public void setOctobre3(Long octobre3) {
        this.octobre3 = octobre3;
    }


    @Column(name = "NOVEMBRE3")
    public Long getNovembre3() {
        return novembre3;
    }

    public void setNovembre3(Long novembre3) {
        this.novembre3 = novembre3;
    }


    @Column(name = "DECEMBRE3")
    public Long getDecembre3() {
        return decembre3;
    }

    public void setDecembre3(Long decembre3) {
        this.decembre3 = decembre3;
    }


    @Column(name = "JANVIER4")
    public Long getJanvier4() {
        return janvier4;
    }

    public void setJanvier4(Long janvier4) {
        this.janvier4 = janvier4;
    }


    @Column(name = "FEVRIER4")
    public Long getFevrier4() {
        return fevrier4;
    }

    public void setFevrier4(Long fevrier4) {
        this.fevrier4 = fevrier4;
    }


    @Column(name = "MARS4")
    public Long getMars4() {
        return mars4;
    }

    public void setMars4(Long mars4) {
        this.mars4 = mars4;
    }


    @Column(name = "AVRIL4")
    public Long getAvril4() {
        return avril4;
    }

    public void setAvril4(Long avril4) {
        this.avril4 = avril4;
    }


    @Column(name = "MAI4")
    public Long getMai4() {
        return mai4;
    }

    public void setMai4(Long mai4) {
        this.mai4 = mai4;
    }


    @Column(name = "JUIN4")
    public Long getJuin4() {
        return juin4;
    }

    public void setJuin4(Long juin4) {
        this.juin4 = juin4;
    }


    @Column(name = "JUILLET4")
    public Long getJuillet4() {
        return juillet4;
    }

    public void setJuillet4(Long juillet4) {
        this.juillet4 = juillet4;
    }


    @Column(name = "AOUT4")
    public Long getAout4() {
        return aout4;
    }

    public void setAout4(Long aout4) {
        this.aout4 = aout4;
    }


    @Column(name = "SEPTEMBRE4")
    public Long getSeptembre4() {
        return septembre4;
    }

    public void setSeptembre4(Long septembre4) {
        this.septembre4 = septembre4;
    }


    @Column(name = "OCTOBRE4")
    public Long getOctobre4() {
        return octobre4;
    }

    public void setOctobre4(Long octobre4) {
        this.octobre4 = octobre4;
    }


    @Column(name = "NOVEMBRE4")
    public Long getNovembre4() {
        return novembre4;
    }

    public void setNovembre4(Long novembre4) {
        this.novembre4 = novembre4;
    }


    @Column(name = "DECEMBRE4")
    public Long getDecembre4() {
        return decembre4;
    }

    public void setDecembre4(Long decembre4) {
        this.decembre4 = decembre4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(nom, client.nom) &&
                Objects.equals(prenom, client.prenom) &&
                Objects.equals(login, client.login) &&
                Objects.equals(mdp, client.mdp) &&
                Objects.equals(janvier1, client.janvier1) &&
                Objects.equals(fevrier1, client.fevrier1) &&
                Objects.equals(mars1, client.mars1) &&
                Objects.equals(avril1, client.avril1) &&
                Objects.equals(mai1, client.mai1) &&
                Objects.equals(juin1, client.juin1) &&
                Objects.equals(juillet1, client.juillet1) &&
                Objects.equals(aout1, client.aout1) &&
                Objects.equals(septembre1, client.septembre1) &&
                Objects.equals(octobre1, client.octobre1) &&
                Objects.equals(novembre1, client.novembre1) &&
                Objects.equals(decembre1, client.decembre1) &&
                Objects.equals(janvier2, client.janvier2) &&
                Objects.equals(fevrier2, client.fevrier2) &&
                Objects.equals(mars2, client.mars2) &&
                Objects.equals(avril2, client.avril2) &&
                Objects.equals(mai2, client.mai2) &&
                Objects.equals(juin2, client.juin2) &&
                Objects.equals(juillet2, client.juillet2) &&
                Objects.equals(aout2, client.aout2) &&
                Objects.equals(septembre2, client.septembre2) &&
                Objects.equals(octobre2, client.octobre2) &&
                Objects.equals(novembre2, client.novembre2) &&
                Objects.equals(decembre2, client.decembre2) &&
                Objects.equals(janvier3, client.janvier3) &&
                Objects.equals(fevrier3, client.fevrier3) &&
                Objects.equals(mars3, client.mars3) &&
                Objects.equals(avril3, client.avril3) &&
                Objects.equals(mai3, client.mai3) &&
                Objects.equals(juin3, client.juin3) &&
                Objects.equals(juillet3, client.juillet3) &&
                Objects.equals(aout3, client.aout3) &&
                Objects.equals(septembre3, client.septembre3) &&
                Objects.equals(octobre3, client.octobre3) &&
                Objects.equals(novembre3, client.novembre3) &&
                Objects.equals(decembre3, client.decembre3) &&
                Objects.equals(janvier4, client.janvier4) &&
                Objects.equals(fevrier4, client.fevrier4) &&
                Objects.equals(mars4, client.mars4) &&
                Objects.equals(avril4, client.avril4) &&
                Objects.equals(mai4, client.mai4) &&
                Objects.equals(juin4, client.juin4) &&
                Objects.equals(juillet4, client.juillet4) &&
                Objects.equals(aout4, client.aout4) &&
                Objects.equals(septembre4, client.septembre4) &&
                Objects.equals(octobre4, client.octobre4) &&
                Objects.equals(novembre4, client.novembre4) &&
                Objects.equals(decembre4, client.decembre4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, login, mdp, janvier1, fevrier1, mars1, avril1, mai1, juin1, juillet1, aout1, septembre1, octobre1, novembre1, decembre1, janvier2, fevrier2, mars2, avril2, mai2, juin2, juillet2, aout2, septembre2, octobre2, novembre2, decembre2, janvier3, fevrier3, mars3, avril3, mai3, juin3, juillet3, aout3, septembre3, octobre3, novembre3, decembre3, janvier4, fevrier4, mars4, avril4, mai4, juin4, juillet4, aout4, septembre4, octobre4, novembre4, decembre4);
    }
}
