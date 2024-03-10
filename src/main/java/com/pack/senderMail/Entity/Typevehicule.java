package com.pack.senderMail.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Typevehicule{

    public Typevehicule(){}
        @Id
        @SequenceGenerator(
            name = "typevehicule_sequence",
            sequenceName = "typevehicule_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "typevehicule_sequence"
        )

          Long idtypevehicule;
          String nomtypevehicule;
    
    public void setIdtypevehicule( Long idtypevehicule){
        this.idtypevehicule=idtypevehicule;
    }
    public Long getIdtypevehicule(){
        return this.idtypevehicule;
    }
    public void setNomtypevehicule( String nomtypevehicule){
        this.nomtypevehicule=nomtypevehicule;
    }
    public String getNomtypevehicule(){
        return this.nomtypevehicule;
    }
}

