package com.pack.senderMail.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Lieu{

    public Lieu(){}
        @Id
        @SequenceGenerator(
            name = "lieu_sequence",
            sequenceName = "lieu_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lieu_sequence"
        )

          Long idlieu;
          String nomlieu;
    
    public void setIdlieu( Long idlieu){
        this.idlieu=idlieu;
    }
    public Long getIdlieu(){
        return this.idlieu;
    }
    public void setNomlieu( String nomlieu){
        this.nomlieu=nomlieu;
    }
    public String getNomlieu(){
        return this.nomlieu;
    }
}
