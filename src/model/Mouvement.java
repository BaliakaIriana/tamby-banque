package model;

import dao.annotations.Column;
import dao.annotations.Id;
import dao.annotations.Table;

import java.sql.Timestamp;
import java.util.Objects;

@Table(name = "MOUVEMENT")
public class Mouvement extends ObjetMere {
    private Long idsituation;
    private Long sender;
    private Long recepteur;
    private Double montant;
    private Timestamp daty;

    @Column(name = "DATY")
    public Timestamp getDaty() {
        return daty;
    }

    public void setDaty(Timestamp daty) {
        this.daty = daty;
    }

    @Id
    @Column(name = "IDMVT")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "IDSITUATION")
    public Long getIdsituation() {
        return idsituation;
    }

    public void setIdsituation(Long idsituation) {
        this.idsituation = idsituation;
    }

    @Column(name = "SENDER")
    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    @Column(name = "RECEPTEUR")
    public Long getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Long recepteur) {
        this.recepteur = recepteur;
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
        Mouvement mouvement = (Mouvement) o;
        return Objects.equals(id, mouvement.id) &&
                Objects.equals(idsituation, mouvement.idsituation) &&
                Objects.equals(sender, mouvement.sender) &&
                Objects.equals(recepteur, mouvement.recepteur) &&
                Objects.equals(montant, mouvement.montant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idsituation, sender, recepteur, montant);
    }
}
