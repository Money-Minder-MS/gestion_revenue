package com.example.revenue;

import java.time.LocalDate;

public class UserDTO {

    private Long id;

    private String nom;

    private String prenom;

    private LocalDate dateNaissance;

    private String telephone;

    private String email;

    private String motDePasse;

    private Long roleId;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public UserDTO(Long id, String nom, String prenom, LocalDate dateNaissance, String telephone, String email, String motDePasse, Long roleId) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
        this.email = email;
        this.motDePasse = motDePasse;
        this.roleId = roleId;
    }
}
