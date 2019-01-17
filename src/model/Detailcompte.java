package model;

import dao.annotations.Column;
import dao.annotations.Table;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Table(name = "DETAILCOMPTE")
public class Detailcompte extends ObjetMere {
    private Long iddevise;
    private Long idclient;
    private Long idbanque;
    private Timestamp ouverture;
    private Timestamp cloture;
    private String nombanque;
    private String nomdevise;
    private String codedevise;
    private String nom;
    private String prenom;
    private String login;

    @Column(name = "IDCOMPTE")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "IDDEVISE")
    public Long getIddevise() {
        return iddevise;
    }

    public void setIddevise(Long iddevise) {
        this.iddevise = iddevise;
    }

    @Column(name = "IDCLIENT")
    public Long getIdclient() {
        return idclient;
    }

    public void setIdclient(Long idclient) {
        this.idclient = idclient;
    }

    @Column(name = "IDBANQUE")
    public Long getIdbanque() {
        return idbanque;
    }

    public void setIdbanque(Long idbanque) {
        this.idbanque = idbanque;
    }

    @Column(name = "OUVERTURE")
    public Timestamp getOuverture() {
        return ouverture;
    }

    public void setOuverture(Timestamp ouverture) {
        this.ouverture = ouverture;
    }

    @Column(name = "CLOTURE")
    public Timestamp getCloture() {
        return cloture;
    }

    public void setCloture(Timestamp cloture) {
        this.cloture = cloture;
    }

    @Column(name = "NOMBANQUE")
    public String getNombanque() {
        return nombanque;
    }

    public void setNombanque(String nombanque) {
        this.nombanque = nombanque;
    }

    @Column(name = "NOMDEVISE")
    public String getNomdevise() {
        return nomdevise;
    }

    public void setNomdevise(String nomdevise) {
        this.nomdevise = nomdevise;
    }

    @Column(name = "CODEDEVISE")
    public String getCodedevise() {
        return codedevise;
    }

    public void setCodedevise(String codedevise) {
        this.codedevise = codedevise;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detailcompte that = (Detailcompte) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(iddevise, that.iddevise) &&
                Objects.equals(idclient, that.idclient) &&
                Objects.equals(idbanque, that.idbanque) &&
                Objects.equals(ouverture, that.ouverture) &&
                Objects.equals(cloture, that.cloture) &&
                Objects.equals(nombanque, that.nombanque) &&
                Objects.equals(nomdevise, that.nomdevise) &&
                Objects.equals(codedevise, that.codedevise) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(login, that.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iddevise, idclient, idbanque, ouverture, cloture, nombanque, nomdevise, codedevise, nom, prenom, login);
    }
}
