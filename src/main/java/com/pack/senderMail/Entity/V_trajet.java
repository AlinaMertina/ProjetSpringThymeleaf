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
public class V_trajet{

    public V_trajet(){}
        @Id
        @SequenceGenerator(
            name = "v_trajet_sequence",
            sequenceName = "v_trajet_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_trajet_sequence"
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
          String numero;
          String nomlieurarrive;
          String nomlieurdepart;
    
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
    public void setNumero( String numero){
        this.numero=numero;
    }
    public String getNumero(){
        return this.numero;
    }
    public void setNomlieurarrive( String nomlieurarrive){
        this.nomlieurarrive=nomlieurarrive;
    }
    public String getNomlieurarrive(){
        return this.nomlieurarrive;
    }
    public void setNomlieurdepart( String nomlieurdepart){
        this.nomlieurdepart=nomlieurdepart;
    }
    public String getNomlieurdepart(){
        return this.nomlieurdepart;
    }

    public List<V_trajet> findAll(){
            java.util.List<V_trajet> resulta = new java.util.ArrayList<V_trajet>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from v_trajet";
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        V_trajet v_trajet= new V_trajet();
                            v_trajet.setIdtrajet(resultSet.getLong("idtrajet"));
                            v_trajet.setDateheurdepart(resultSet.getDate("dateheurdepart"));
                            v_trajet.setIdlieurdepart(resultSet.getLong("idlieurdepart"));
                            v_trajet.setKilometragedepart(resultSet.getDouble("kilometragedepart"));
                            v_trajet.setDateheurarrive(resultSet.getDate("dateheurarrive"));
                            v_trajet.setIdlieurarrive(resultSet.getLong("idlieurarrive"));
                            v_trajet.setKilometragearrive(resultSet.getDouble("kilometragearrive"));
                            v_trajet.setQuantitecarburant(resultSet.getDouble("quantitecarburant"));
                            v_trajet.setPrixcarburant(resultSet.getDouble("prixcarburant"));
                            v_trajet.setMotif(resultSet.getString("motif"));
                            v_trajet.setIdutilisateur(resultSet.getLong("idutilisateur"));
                            v_trajet.setIdvehicule(resultSet.getLong("idvehicule"));
                            v_trajet.setNumero(resultSet.getString("numero"));
                            v_trajet.setNomlieurarrive(resultSet.getString("nomlieurarrive"));
                            v_trajet.setNomlieurdepart(resultSet.getString("nomlieurdepart"));
                        resulta.add(v_trajet);
                    }
                    resultSet.close();
                    statement.close();
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resulta;
    }

     public List<V_trajet> pagination(Long idutilisateur ,Long number){
            java.util.List<V_trajet> resulta = new java.util.ArrayList<V_trajet>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from   v_trajet  where idutilisateur="+idutilisateur+" limit 5 OFFSET "+number;
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        V_trajet v_trajet= new V_trajet();
                            v_trajet.setIdtrajet(resultSet.getLong("idtrajet"));
                            v_trajet.setDateheurdepart(resultSet.getDate("dateheurdepart"));
                            v_trajet.setIdlieurdepart(resultSet.getLong("idlieurdepart"));
                            v_trajet.setKilometragedepart(resultSet.getDouble("kilometragedepart"));
                            v_trajet.setDateheurarrive(resultSet.getDate("dateheurarrive"));
                            v_trajet.setIdlieurarrive(resultSet.getLong("idlieurarrive"));
                            v_trajet.setKilometragearrive(resultSet.getDouble("kilometragearrive"));
                            v_trajet.setQuantitecarburant(resultSet.getDouble("quantitecarburant"));
                            v_trajet.setPrixcarburant(resultSet.getDouble("prixcarburant"));
                            v_trajet.setMotif(resultSet.getString("motif"));
                            v_trajet.setIdutilisateur(resultSet.getLong("idutilisateur"));
                            v_trajet.setIdvehicule(resultSet.getLong("idvehicule"));
                            v_trajet.setNumero(resultSet.getString("numero"));
                            v_trajet.setNomlieurarrive(resultSet.getString("nomlieurarrive"));
                            v_trajet.setNomlieurdepart(resultSet.getString("nomlieurdepart"));
                        resulta.add(v_trajet);
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
