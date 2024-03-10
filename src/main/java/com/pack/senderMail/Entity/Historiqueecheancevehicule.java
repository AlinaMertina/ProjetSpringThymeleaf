package com.pack.senderMail.Entity;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.Immutable;
import java.util.*;
import java.util.Date;
import java.sql.*;
import com.pack.senderMail.Work.*;

@Entity
public class Historiqueecheancevehicule{

    public Historiqueecheancevehicule(){}
        @Id
        @SequenceGenerator(
            name = "historiqueecheancevehicule_sequence",
            sequenceName = "historiqueecheancevehicule_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "historiqueecheancevehicule_sequence"
        )
        Long idhistoriqueecheancevehicule;
          Long idecheancevehicule;
          Long idvehicule;
          Long idecheance;
          java.util.Date dateecheancevehicule;
          java.util.Date datemodif;
    
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
    public void setDatemodif( java.util.Date datemodif){
        this.datemodif=datemodif;
    }
    public java.util.Date getDatemodif(){
        return this.datemodif;
    }

    public List<Historiqueecheancevehicule> findAll(){
            java.util.List<Historiqueecheancevehicule> resulta = new java.util.ArrayList<Historiqueecheancevehicule>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from historiqueecheancevehicule";
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        Historiqueecheancevehicule historiqueecheancevehicule= new Historiqueecheancevehicule();
                            historiqueecheancevehicule.setIdecheancevehicule(resultSet.getLong("idecheancevehicule"));
                            historiqueecheancevehicule.setIdvehicule(resultSet.getLong("idvehicule"));
                            historiqueecheancevehicule.setIdecheance(resultSet.getLong("idecheance"));
                            historiqueecheancevehicule.setDateecheancevehicule(resultSet.getDate("dateecheancevehicule"));
                            historiqueecheancevehicule.setDatemodif(resultSet.getDate("datemodif"));
                        resulta.add(historiqueecheancevehicule);
                    }
                    resultSet.close();
                    statement.close();
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resulta;
    }

     public List<Historiqueecheancevehicule> pagination(Long number){
            java.util.List<Historiqueecheancevehicule> resulta = new java.util.ArrayList<Historiqueecheancevehicule>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from historiqueecheancevehicule limit 5 OFFSET "+number;
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        Historiqueecheancevehicule historiqueecheancevehicule= new Historiqueecheancevehicule();
                            historiqueecheancevehicule.setIdecheancevehicule(resultSet.getLong("idecheancevehicule"));
                            historiqueecheancevehicule.setIdvehicule(resultSet.getLong("idvehicule"));
                            historiqueecheancevehicule.setIdecheance(resultSet.getLong("idecheance"));
                            historiqueecheancevehicule.setDateecheancevehicule(resultSet.getDate("dateecheancevehicule"));
                            historiqueecheancevehicule.setDatemodif(resultSet.getDate("datemodif"));
                        resulta.add(historiqueecheancevehicule);
                    }
                    resultSet.close();
                    statement.close();
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resulta;
    }
    public Historiqueecheancevehicule(Long idecheancevehicule, Long idvehicule, Long idecheance,
            Date dateecheancevehicule, Date datemodif) {
        this.idecheancevehicule = idecheancevehicule;
        this.idvehicule = idvehicule;
        this.idecheance = idecheance;
        this.dateecheancevehicule = dateecheancevehicule;
        this.datemodif = datemodif;
    }
    public Long getIdhistoriqueecheancevehicule() {
        return idhistoriqueecheancevehicule;
    }
    public void setIdhistoriqueecheancevehicule(Long idhistoriqueecheancevehicule) {
        this.idhistoriqueecheancevehicule = idhistoriqueecheancevehicule;
    }
    public Historiqueecheancevehicule(Long idhistoriqueecheancevehicule, Long idecheancevehicule, Long idvehicule,
            Long idecheance, Date dateecheancevehicule, Date datemodif) {
        this.idhistoriqueecheancevehicule = idhistoriqueecheancevehicule;
        this.idecheancevehicule = idecheancevehicule;
        this.idvehicule = idvehicule;
        this.idecheance = idecheance;
        this.dateecheancevehicule = dateecheancevehicule;
        this.datemodif = datemodif;
    }
    
    
}
