package com.pack.senderMail.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Utilisateur{

    public Utilisateur(){}
        @Id
        @SequenceGenerator(
            name = "utilisateur_sequence",
            sequenceName = "utilisateur_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "utilisateur_sequence"
        )

        Long idutilisateur;
        Long idrole;
        String nomutilisateur;
        String prenom;
        java.util.Date datenaissance;
        String email;
        String password;
        Integer activer;
    
    public void setIdutilisateur( Long idutilisateur){
        this.idutilisateur=idutilisateur;
    }
    public Long getIdutilisateur(){
        return this.idutilisateur;
    }
    public void setIdrole( Long idrole){
        this.idrole=idrole;
    }
    public Long getIdrole(){
        return this.idrole;
    }
    public void setNomutilisateur( String nomutilisateur){
        this.nomutilisateur=nomutilisateur;
    }
    public String getNomutilisateur(){
        return this.nomutilisateur;
    }
    public void setPrenom( String prenom){
        this.prenom=prenom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setDatenaissance( java.util.Date datenaissance){
        this.datenaissance=datenaissance;
    }
    public java.util.Date getDatenaissance(){
        return this.datenaissance;
    }
    public void setEmail( String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPassword( String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
    public void setActiver( Integer activer){
        this.activer=activer;
    }
    public Integer getActiver(){
        return this.activer;
    }
}
