
package com.pack.senderMail.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Personnevalue{

    public Personnevalue(){}
   
    @Id
    String idpersonnevalue;
    String nompersonnevalue;

    
    public void setIdpersonnevalue( String idpersonnevalue){
        this.idpersonnevalue=idpersonnevalue;
    }
    public String getIdpersonnevalue(){
        return this.idpersonnevalue;
    }
    public void setNompersonnevalue( String nompersonnevalue){
        this.nompersonnevalue=nompersonnevalue;
    }
    public String getNompersonnevalue(){
        return this.nompersonnevalue;
    }

    public Personnevalue (String idpersonnevalue,String nompersonnevalue){
        this.idpersonnevalue=idpersonnevalue;
        this.nompersonnevalue=nompersonnevalue;
    }
}
