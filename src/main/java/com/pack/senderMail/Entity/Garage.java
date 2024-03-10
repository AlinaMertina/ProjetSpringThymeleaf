package com.pack.senderMail.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Garage{

    public Garage(){}
        @Id
        @SequenceGenerator(
            name = "garage_sequence",
            sequenceName = "garage_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "garage_sequence"
        )

          Long idgarage;
          Long idvehicule;
          java.util.Date date;
          Long idutilisateur;
          Integer entersortie;
    
    public void setIdgarage( Long idgarage){
        this.idgarage=idgarage;
    }
    public Long getIdgarage(){
        return this.idgarage;
    }
    public void setIdvehicule( Long idvehicule){
        this.idvehicule=idvehicule;
    }
    public Long getIdvehicule(){
        return this.idvehicule;
    }
    public void setDate( java.util.Date date){
        this.date=date;
    }
    public java.util.Date getDate(){
        return this.date;
    }
    public void setIdutilisateur( Long idutilisateur){
        this.idutilisateur=idutilisateur;
    }
    public Long getIdutilisateur(){
        return this.idutilisateur;
    }
    public void setEntersortie( Integer entersortie){
        this.entersortie=entersortie;
    }
    public Integer getEntersortie(){
        return this.entersortie;
    }
    public Garage(Long idgarage, Long idvehicule, Date date, Long idutilisateur, Integer entersortie) {
        this.idgarage = idgarage;
        this.idvehicule = idvehicule;
        this.date = date;
        this.idutilisateur = idutilisateur;
        this.entersortie = entersortie;
    }
    
}
