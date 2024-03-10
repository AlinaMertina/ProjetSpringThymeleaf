package com.pack.senderMail.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Trajet{

    public Trajet(){}
        @Id
        @SequenceGenerator(
            name = "trajet_sequence",
            sequenceName = "trajet_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trajet_sequence"
        )

          Long idtrajet;
          java.util.Date dateheurdepart;
          Long idlieurdepart;
          Double kilometragedepart;
          java.util.Date dateheurarrive;
          Long idlieurarrive;
          Double kilometragearrive;
          Double quantitecarburant;
          Double prixcarburant;
          String motif;
          Long idutilisateur;
          Long idvehicule;
    
    public void setIdtrajet( Long idtrajet){
        this.idtrajet=idtrajet;
    }
    public Long getIdtrajet(){
        return this.idtrajet;
    }
    public void setDateheurdepart( java.util.Date dateheurdepart){
        this.dateheurdepart=dateheurdepart;
    }
    public java.util.Date getDateheurdepart(){
        return this.dateheurdepart;
    }
    public void setIdlieurdepart( Long idlieurdepart){
        this.idlieurdepart=idlieurdepart;
    }
    public Long getIdlieurdepart(){
        return this.idlieurdepart;
    }
    public void setKilometragedepart( Double kilometragedepart){
        this.kilometragedepart=kilometragedepart;
    }
    public Double getKilometragedepart(){
        return this.kilometragedepart;
    }
    public void setDateheurarrive( java.util.Date dateheurarrive){
        this.dateheurarrive=dateheurarrive;
    }
    public java.util.Date getDateheurarrive(){
        return this.dateheurarrive;
    }
    public void setIdlieurarrive( Long idlieurarrive){
        this.idlieurarrive=idlieurarrive;
    }
    public Long getIdlieurarrive(){
        return this.idlieurarrive;
    }
    public void setKilometragearrive( Double kilometragearrive){
        this.kilometragearrive=kilometragearrive;
    }
    public Double getKilometragearrive(){
        return this.kilometragearrive;
    }
    public void setQuantitecarburant( Double quantitecarburant){
        this.quantitecarburant=quantitecarburant;
    }
    public Double getQuantitecarburant(){
        return this.quantitecarburant;
    }
    public void setPrixcarburant( Double prixcarburant){
        this.prixcarburant=prixcarburant;
    }
    public Double getPrixcarburant(){
        return this.prixcarburant;
    }
    public void setMotif( String motif){
        this.motif=motif;
    }
    public String getMotif(){
        return this.motif;
    }
    public void setIdutilisateur( Long idutilisateur){
        this.idutilisateur=idutilisateur;
    }
    public Long getIdutilisateur(){
        return this.idutilisateur;
    }
    public void setIdvehicule( Long idvehicule){
        this.idvehicule=idvehicule;
    }
    public Long getIdvehicule(){
        return this.idvehicule;
    }
}

