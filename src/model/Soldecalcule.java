package model;

import dao.annotations.Column;
import dao.annotations.Id;
import dao.annotations.Table;

import java.util.Objects;

@Table(name = "SOLDECALCULE")
public class Soldecalcule extends ObjetMere{
    private Long id;
    private Double solde;

    public Soldecalcule() {
    }

    public Soldecalcule(Long id, Double solde) {
        this.id = id;
        this.solde = solde;
    }

    @Id
    @Column(name = "IDCLIENT")
    public Long getId() {
        return id;
    }

    public void setId(Long idclient) {
        this.id = idclient;
    }

    @Column(name = "SOLDE")
    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soldecalcule that = (Soldecalcule) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(solde, that.solde);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, solde);
    }
}
