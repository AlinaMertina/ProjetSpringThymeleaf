package com.pack.senderMail.Work.User;

public class User {
   Long iduser;
   String email;
   String nom;
   String prenom ;
   Long idrole;
    public User(Long iduser, String email, String nom, String prenom, Long idrole) {
    this.iduser = iduser;
    this.email = email;
    this.nom = nom;
    this.prenom = prenom;
    this.idrole = idrole;
 }
    public Long getIdrole() {
        return idrole;
    }
    public void setIdrole(Long idrole) {
        this.idrole = idrole;
    }
    public Long getIduser() {
        return iduser;
    }
    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public User() {
    }
    public User(Long iduser, String email, String nom, String prenom) {
        this.iduser = iduser;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
    }
   

    
}
