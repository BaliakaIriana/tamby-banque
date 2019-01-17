package model;

import dao.annotations.Column;
import dao.annotations.Id;
import dao.annotations.Table;
import java.sql.Time;
import java.util.Objects;

@Table(name = "COMPTE")
public class Compte {
    private Long idcompte;
    private Long iddevise;
    private Long idclient;
    private Long idbanque;
    private Time ouverture;
    private Time cloture;

    @Id
    @Column(name = "IDCOMPTE")
    public Long getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(Long idcompte) {
        this.idcompte = idcompte;
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
    public Time getOuverture() {
        return ouverture;
    }

    public void setOuverture(Time ouverture) {
        this.ouverture = ouverture;
    }

    @Column(name = "CLOTURE")
    public Time getCloture() {
        return cloture;
    }

    public void setCloture(Time cloture) {
        this.cloture = cloture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return Objects.equals(idcompte, compte.idcompte) &&
                Objects.equals(iddevise, compte.iddevise) &&
                Objects.equals(idclient, compte.idclient) &&
                Objects.equals(idbanque, compte.idbanque) &&
                Objects.equals(ouverture, compte.ouverture) &&
                Objects.equals(cloture, compte.cloture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcompte, iddevise, idclient, idbanque, ouverture, cloture);
    }
}
