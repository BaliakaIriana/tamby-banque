package model;

import dao.annotations.Column;
import dao.annotations.Id;
import dao.annotations.Table;

import java.util.Objects;

@Table(name = "ADMIN")
public class Admin extends ObjetMere{

    @Id
    @Column(name = "IDADMIN")
    public Long getId() {
        return id;
    }

    public void setId(Long idadmin) {
        this.id = idadmin;
    }

    private Long idbanque;

    @Column(name = "IDBANQUE")
    public Long getIdbanque() {
        return idbanque;
    }

    public void setIdbanque(Long idbanque) {
        this.idbanque = idbanque;
    }

    private String login;

    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String mdp;

    @Column(name = "MDP")
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(id, admin.id) &&
                Objects.equals(idbanque, admin.idbanque) &&
                Objects.equals(login, admin.login) &&
                Objects.equals(mdp, admin.mdp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idbanque, login, mdp);
    }
}
