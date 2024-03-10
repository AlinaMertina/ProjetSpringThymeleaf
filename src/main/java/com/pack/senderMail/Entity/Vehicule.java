package com.pack.senderMail.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Vehicule{

    public Vehicule(){}
        @Id
        @SequenceGenerator(
            name = "vehicule_sequence",
            sequenceName = "vehicule_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicule_sequence"
        )

          Long idvehicule;
          String numero;
          String marque;
          String model;
          Long idtypevehicule;
    
    public void setIdvehicule( Long idvehicule){
        this.idvehicule=idvehicule;
    }
    public Long getIdvehicule(){
        return this.idvehicule;
    }
    public void setNumero( String numero){
        this.numero=numero;
    }
    public String getNumero(){
        return this.numero;
    }
    public void setMarque( String marque){
        this.marque=marque;
    }
    public String getMarque(){
        return this.marque;
    }
    public void setModel( String model){
        this.model=model;
    }
    public String getModel(){
        return this.model;
    }
    public void setIdtypevehicule( Long idtypevehicule){
        this.idtypevehicule=idtypevehicule;
    }
    public Long getIdtypevehicule(){
        return this.idtypevehicule;
    }
}
