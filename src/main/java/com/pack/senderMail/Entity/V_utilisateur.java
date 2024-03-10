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
public class V_utilisateur{

    public V_utilisateur(){}
        @Id
        @SequenceGenerator(
            name = "v_utilisateur_sequence",
            sequenceName = "v_utilisateur_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_utilisateur_sequence"
        )

          Long idutilisateur;
          String nomrole;
          Long idrole;
          String nomutilisateur;
          String prenom;
          java.util.Date datenaissance;
    
    public void setIdutilisateur( Long idutilisateur){
        this.idutilisateur=idutilisateur;
    }
    public Long getIdutilisateur(){
        return this.idutilisateur;
    }
    public void setNomrole( String nomrole){
        this.nomrole=nomrole;
    }
    public String getNomrole(){
        return this.nomrole;
    }
    public void setIdrole( Long idrole){
        this.idrole=idrole;
    }
    public Long getIdrole(){
        return this.idrole;
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
    public void setDatenaissance( java.util.Date datenaissance){
        this.datenaissance=datenaissance;
    }
    public java.util.Date getDatenaissance(){
        return this.datenaissance;
    }

    public List<V_utilisateur> findAll(){
            java.util.List<V_utilisateur> resulta = new java.util.ArrayList<V_utilisateur>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from v_utilisateur";
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        V_utilisateur v_utilisateur= new V_utilisateur();
                            v_utilisateur.setIdutilisateur(resultSet.getLong("idutilisateur"));
                            v_utilisateur.setNomrole(resultSet.getString("nomrole"));
                            v_utilisateur.setIdrole(resultSet.getLong("idrole"));
                            v_utilisateur.setNomutilisateur(resultSet.getString("nomutilisateur"));
                            v_utilisateur.setPrenom(resultSet.getString("prenom"));
                            v_utilisateur.setDatenaissance(resultSet.getDate("datenaissance"));
                        resulta.add(v_utilisateur);
                    }
                    resultSet.close();
                    statement.close();
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resulta;
    }

     public List<V_utilisateur> pagination(Long number){
            java.util.List<V_utilisateur> resulta = new java.util.ArrayList<V_utilisateur>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from v_utilisateur limit 5 OFFSET "+number;
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("nomutilisateur"));
                        V_utilisateur v_utilisateur= new V_utilisateur();
                            v_utilisateur.setIdutilisateur(resultSet.getLong("idutilisateur"));
                            v_utilisateur.setNomrole(resultSet.getString("nomrole"));
                            v_utilisateur.setIdrole(resultSet.getLong("idrole"));
                            v_utilisateur.setNomutilisateur(resultSet.getString("nomutilisateur"));
                            v_utilisateur.setPrenom(resultSet.getString("prenom"));
                            v_utilisateur.setDatenaissance(resultSet.getDate("datenaissance"));
                        resulta.add(v_utilisateur);
                    }
                    resultSet.close();
                    statement.close();
                    connection.close();
            } catch (SQLException e) {
                System.out.println(e);
                e.printStackTrace();
            }
            return resulta;
    }
}
