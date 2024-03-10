package com.pack.senderMail.Entity;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Echeancevehicule{

    public Echeancevehicule(){}
        @Id
        @SequenceGenerator(
            name = "echeancevehicule_sequence",
            sequenceName = "echeancevehicule_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "echeancevehicule_sequence"
        )

          Long idecheancevehicule;
          Long idvehicule;
          Long idecheance;
          java.util.Date dateecheancevehicule;
    
    public void setIdecheancevehicule( Long idecheancevehicule){
        this.idecheancevehicule=idecheancevehicule;
    }
    public Long getIdecheancevehicule(){
        return this.idecheancevehicule;
    }
    public void setIdvehicule( Long idvehicule){
        this.idvehicule=idvehicule;
    }
    public Long getIdvehicule(){
        return this.idvehicule;
    }
    public void setIdecheance( Long idecheance){
        this.idecheance=idecheance;
    }
    public Long getIdecheance(){
        return this.idecheance;
    }
    public void setDateecheancevehicule( java.util.Date dateecheancevehicule){
        this.dateecheancevehicule=dateecheancevehicule;
    }
    public java.util.Date getDateecheancevehicule(){
        return this.dateecheancevehicule;
    }
}
