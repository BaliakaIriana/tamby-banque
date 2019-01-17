package model;

import dao.annotations.Column;
import dao.annotations.Id;
import dao.annotations.Table;

import java.util.Objects;

@Table(name = "DETAILBQ")
public class Detailbq extends ObjetMere{
    private Long iddetail;
    private Double taux;
    private Double coutfixe;
    private Double interetchange;
    private Long idbanque;

    @Id
    @Column(name = "IDDETAIL")
    public Long getIddetail() {
        return iddetail;
    }

    public void setIddetail(Long iddetail) {
        this.iddetail = iddetail;
    }

    @Column(name = "TAUX")
    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }

    @Column(name = "COUTFIXE")
    public Double getCoutfixe() {
        return coutfixe;
    }

    public void setCoutfixe(Double coutfixe) {
        this.coutfixe = coutfixe;
    }

    @Column(name = "INTERETCHANGE")
    public Double getInteretchange() {
        return interetchange;
    }

    public void setInteretchange(Double interetchange) {
        this.interetchange = interetchange;
    }

    @Column(name = "IDBANQUE")
    public Long getIdbanque() {
        return idbanque;
    }

    public void setIdbanque(Long idbanque) {
        this.idbanque = idbanque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detailbq detailbq = (Detailbq) o;
        return Objects.equals(iddetail, detailbq.iddetail) &&
                Objects.equals(taux, detailbq.taux) &&
                Objects.equals(coutfixe, detailbq.coutfixe) &&
                Objects.equals(interetchange, detailbq.interetchange) &&
                Objects.equals(idbanque, detailbq.idbanque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddetail, taux, coutfixe, interetchange, idbanque);
    }
}
