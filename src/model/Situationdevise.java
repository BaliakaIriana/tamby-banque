package model;

import dao.annotations.Column;
import dao.annotations.Id;
import dao.annotations.Table;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

@Table(name = "SITUATIONDEVISE")
public class Situationdevise extends ObjetMere {
    private Long iddevise;
    private Long devIddevise;
    private Timestamp daty;
    private Double montant;

    @Id
    @Column(name = "IDSITUATION")
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

    @Column(name = "DEV_IDDEVISE")
    public Long getDevIddevise() {
        return devIddevise;
    }

    public void setDevIddevise(Long devIddevise) {
        this.devIddevise = devIddevise;
    }

    @Column(name = "DATY")
    public Timestamp getDaty() {
        return daty;
    }

    public void setDaty(Timestamp daty) {
        this.daty = daty;
    }

    @Column(name = "MONTANT")
    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Situationdevise that = (Situationdevise) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(iddevise, that.iddevise) &&
                Objects.equals(devIddevise, that.devIddevise) &&
                Objects.equals(daty, that.daty) &&
                Objects.equals(montant, that.montant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iddevise, devIddevise, daty, montant);
    }
}
