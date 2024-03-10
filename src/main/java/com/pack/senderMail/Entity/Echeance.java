package com.pack.senderMail.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Echeance{

    public Echeance(){}
        @Id
        @SequenceGenerator(
            name = "echeance_sequence",
            sequenceName = "echeance_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "echeance_sequence"
        )

          Long idecheance;
          String nomecheance;
    
    public void setIdecheance( Long idecheance){
        this.idecheance=idecheance;
    }
    public Long getIdecheance(){
        return this.idecheance;
    }
    public void setNomecheance( String nomecheance){
        this.nomecheance=nomecheance;
    }
    public String getNomecheance(){
        return this.nomecheance;
    }
}
