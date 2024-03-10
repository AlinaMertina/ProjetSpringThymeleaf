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
public class V_vehicule{

    public V_vehicule(){}
        @Id
        @SequenceGenerator(
            name = "v_vehicule_sequence",
            sequenceName = "v_vehicule_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "v_vehicule_sequence"
        )

          Long idvehicule;
          String numero;
          String marque;
          String model;
          Long idtypevehicule;
          String nomtypevehicule;
    
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
    public void setMarque( String marque){
        this.marque=marque;
    }
    public String getMarque(){
        return this.marque;
    }
    public void setModel( String model){
        this.model=model;
    }
    public String getModel(){
        return this.model;
    }
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

    public List<V_vehicule> findAll(){
            java.util.List<V_vehicule> resulta = new java.util.ArrayList<V_vehicule>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from v_vehicule";
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        V_vehicule v_vehicule= new V_vehicule();
                            v_vehicule.setIdvehicule(resultSet.getLong("idvehicule"));
                            v_vehicule.setNumero(resultSet.getString("numero"));
                            v_vehicule.setMarque(resultSet.getString("marque"));
                            v_vehicule.setModel(resultSet.getString("model"));
                            v_vehicule.setIdtypevehicule(resultSet.getLong("idtypevehicule"));
                            v_vehicule.setNomtypevehicule(resultSet.getString("nomtypevehicule"));
                        resulta.add(v_vehicule);
                    }
                    resultSet.close();
                    statement.close();
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resulta;
    }

     public List<V_vehicule> pagination(Long number){
            java.util.List<V_vehicule> resulta = new java.util.ArrayList<V_vehicule>();
            try {
                ConnectionPostgres con = new ConnectionPostgres();
                Connection connection = con.getconnexion();
                    Statement statement = connection.createStatement();
                    String query = "select * from v_vehicule limit 5 OFFSET "+number;
                    ResultSet resultSet = statement.executeQuery(query);
                    while (resultSet.next()) {
                        V_vehicule v_vehicule= new V_vehicule();
                            v_vehicule.setIdvehicule(resultSet.getLong("idvehicule"));
                            v_vehicule.setNumero(resultSet.getString("numero"));
                            v_vehicule.setMarque(resultSet.getString("marque"));
                            v_vehicule.setModel(resultSet.getString("model"));
                            v_vehicule.setIdtypevehicule(resultSet.getLong("idtypevehicule"));
                            v_vehicule.setNomtypevehicule(resultSet.getString("nomtypevehicule"));
                        resulta.add(v_vehicule);
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
