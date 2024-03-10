package com.pack.senderMail.Entity;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.hibernate.annotations.Immutable;
import java.util.*;
import java.sql.*;
import com.pack.senderMail.Work.*;

@Entity
@Immutable
public class V_garage{

    public V_garage(){}
        @Id
        @SequenceGenerator(
            name = "v_garage_sequence",
            sequenceName = "v_garage_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_garage_sequence"
        )

          Long idgarage;
          Long idvehicule;
          java.util.Date date;
          Long idutilisateur;
          Integer entersortie;
          String nomutilisateur;
          String prenom;
          String numero;
    
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
    public void setNumero( String numero){
        this.numero=numero;
    }
    public String getNumero(){
        return this.numero;
    }

    public List<V_garage> findAll(){
            java.util.List<V_garage> resulta = new java.util.ArrayList<V_garage>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from v_garage";
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        V_garage v_garage= new V_garage();
                            v_garage.setIdgarage(resultSet.getLong("idgarage"));
                            v_garage.setIdvehicule(resultSet.getLong("idvehicule"));
                            v_garage.setDate(resultSet.getDate("date"));
                            v_garage.setIdutilisateur(resultSet.getLong("idutilisateur"));
                            v_garage.setEntersortie(resultSet.getInt("entersortie"));
                            v_garage.setNomutilisateur(resultSet.getString("nomutilisateur"));
                            v_garage.setPrenom(resultSet.getString("prenom"));
                            v_garage.setNumero(resultSet.getString("numero"));
                        resulta.add(v_garage);
                    }
                    resultSet.close();
                    statement.close();
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resulta;
    }

     public List<V_garage> pagination(Long number){
            java.util.List<V_garage> resulta = new java.util.ArrayList<V_garage>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from v_garage limit 5 OFFSET "+number;
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        V_garage v_garage= new V_garage();
                            v_garage.setIdgarage(resultSet.getLong("idgarage"));
                            v_garage.setIdvehicule(resultSet.getLong("idvehicule"));
                            v_garage.setDate(resultSet.getDate("date"));
                            v_garage.setIdutilisateur(resultSet.getLong("idutilisateur"));
                            v_garage.setEntersortie(resultSet.getInt("entersortie"));
                            v_garage.setNomutilisateur(resultSet.getString("nomutilisateur"));
                            v_garage.setPrenom(resultSet.getString("prenom"));
                            v_garage.setNumero(resultSet.getString("numero"));
                        resulta.add(v_garage);
                    }
                    resultSet.close();
                    statement.close();
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resulta;
    }
}
