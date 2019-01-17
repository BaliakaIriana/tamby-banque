package model;

import dao.annotations.Column;
import dao.annotations.Id;
import dao.annotations.Table;

@Table(name = "BANQUE")
public class Banque extends ObjetMere {

    private String nom;

    @Id
    @Column(name = "IDBANQUE")
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

}
