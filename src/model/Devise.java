package model;

import dao.annotations.Column;
import dao.annotations.Id;
import dao.annotations.Table;

@Table(name = "DEVISE")
public class Devise extends ObjetMere {
    private String nom;
    private String code;

    @Id
    @Column(name = "IDDEVISE")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NOM")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
