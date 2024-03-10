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
public class V_echeancevehicule{

    public V_echeancevehicule(){}
        @Id
        @SequenceGenerator(
            name = "v_echeancevehicule_sequence",
            sequenceName = "v_echeancevehicule_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_echeancevehicule_sequence"
        )

          Long idecheancevehicule;
          Long idvehicule;
          Long idecheance;
          java.util.Date dateecheancevehicule;
          Integer nbrjour;
          String nomecheance;
          String numero;
    
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
    public void setNbrjour( Integer nbrjour){
        this.nbrjour=nbrjour;
    }
    public Integer getNbrjour(){
        return this.nbrjour;
    }
    public void setNomecheance( String nomecheance){
        this.nomecheance=nomecheance;
    }
    public String getNomecheance(){
        return this.nomecheance;
    }
    public void setNumero( String numero){
        this.numero=numero;
    }
    public String getNumero(){
        return this.numero;
    }

    public List<V_echeancevehicule> findAll(){
            java.util.List<V_echeancevehicule> resulta = new java.util.ArrayList<V_echeancevehicule>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from v_echeancevehicule";
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        V_echeancevehicule v_echeancevehicule= new V_echeancevehicule();
                            v_echeancevehicule.setIdecheancevehicule(resultSet.getLong("idecheancevehicule"));
                            v_echeancevehicule.setIdvehicule(resultSet.getLong("idvehicule"));
                            v_echeancevehicule.setIdecheance(resultSet.getLong("idecheance"));
                            v_echeancevehicule.setDateecheancevehicule(resultSet.getDate("dateecheancevehicule"));
                            v_echeancevehicule.setNbrjour(resultSet.getInt("nbrjour"));
                            v_echeancevehicule.setNomecheance(resultSet.getString("nomecheance"));
                            v_echeancevehicule.setNumero(resultSet.getString("numero"));
                        resulta.add(v_echeancevehicule);
                    }
                    resultSet.close();
                    statement.close();
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resulta;
    }

     public List<V_echeancevehicule> pagination(Long number){
            java.util.List<V_echeancevehicule> resulta = new java.util.ArrayList<V_echeancevehicule>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from v_echeancevehicule limit 5 OFFSET "+number;
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        V_echeancevehicule v_echeancevehicule= new V_echeancevehicule();
                            v_echeancevehicule.setIdecheancevehicule(resultSet.getLong("idecheancevehicule"));
                            v_echeancevehicule.setIdvehicule(resultSet.getLong("idvehicule"));
                            v_echeancevehicule.setIdecheance(resultSet.getLong("idecheance"));
                            v_echeancevehicule.setDateecheancevehicule(resultSet.getDate("dateecheancevehicule"));
                            v_echeancevehicule.setNbrjour(resultSet.getInt("nbrjour"));
                            v_echeancevehicule.setNomecheance(resultSet.getString("nomecheance"));
                            v_echeancevehicule.setNumero(resultSet.getString("numero"));
                        resulta.add(v_echeancevehicule);
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
