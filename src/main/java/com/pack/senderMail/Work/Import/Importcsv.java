package com.pack.senderMail.Work.Import;
import com.pack.senderMail.Work.*;

import java.util.*;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Importcsv {
    HashMap<String, String> dictionnaire = new HashMap<>();
    HashMap<String, String> modeinsert = new HashMap<>();


    String nomtable;
  
    public void SetModeinsert( HashMap<String, String> mode){
            modeinsert=mode;
    }
    public HashMap<String, String> getModeinsert( ){
         return modeinsert;
    }

    public Importcsv(String nomtable){
        this.nomtable=nomtable;
      
        dictionnaire.put("BIGINT".toUpperCase(), "vide");
        dictionnaire.put("CHARACTER VARYING".toUpperCase(), "parenthese");
        dictionnaire.put("Integer".toUpperCase(), "vide");
        dictionnaire.put("Long".toUpperCase(), "vide");
        dictionnaire.put("Short".toUpperCase(), "vide");
        dictionnaire.put("java.math.BigDecimal".toUpperCase(), "vide");
        dictionnaire.put("Float".toUpperCase(), "vide");
        dictionnaire.put("Double".toUpperCase(), "vide");
        dictionnaire.put("String".toUpperCase(), "parenthese");
        dictionnaire.put("Boolean".toUpperCase(), "vide");
        dictionnaire.put("java.util.Date".toUpperCase(), "parenthese");
        dictionnaire.put("java.util.Time".toUpperCase(), "");
        dictionnaire.put("java.sql.Timestamp".toUpperCase(), "parenthese");
        dictionnaire.put("java.util.UUID".toUpperCase(), "parenthese");
        dictionnaire.put("TIMESTAMP(6) WITHOUT TIME ZONE".toUpperCase(), "parenthese");
        dictionnaire.put("TIMESTAMP WITHOUT TIME ZONE".toUpperCase(), "parenthese");
    }
    public String getTypejava(String nomvariable){
        if(dictionnaire.get(nomvariable.toUpperCase())==null){
            return "String";
        }
        return dictionnaire.get(nomvariable.toUpperCase());
    }
      
    //fuction qui vas prendre la maniere d insertion de la  colonne
    public  void getInscription(){
        HashMap<String, String>  resuList= new HashMap<String, String>();
        try {
            Connection connection = new ConnectionPostgres().getconnexion();
            connection.setSchema("public");
            Statement stmt = connection.createStatement();
            String query = "SELECT column_name, data_type, character_maximum_length FROM information_schema.columns WHERE table_schema = 'public' AND table_name = '"+this.nomtable+"'";
            java.sql.ResultSet columns = stmt.executeQuery(query);
            int p=0;
            while (columns.next()) {
                System.out.println(getTypejava(columns.getString("data_type").toUpperCase()));
                resuList.put(columns.getString("column_name").toUpperCase(),  getTypejava(columns.getString("data_type").toUpperCase()) );
            }
            SetModeinsert(resuList);
            connection.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public String formatString(String value) {
        value = value.replace("'", "''");
        value = value.replace(",", ".");
        value = value.replace("(", "");
        value = value.replace(")", "");
        value = value.replace("/", "-");
        value = value.replace("\"", ""); 
        return value;
    }
    
    public String getformatInsert(String colonne, String ligne){
       ligne=ligne.replace(";;", ";\"\";");
        String[] valuecolonne = ligne.split(";");
        String[] colonneattribue = colonne.split(";");
        String colonneinsert = colonne.replace(";", ",");
        String value = "";
        for(int i=0;i<colonneattribue.length;i++){
            if(valuecolonne.length>0){
                if(valuecolonne[i].compareTo("\"\"")==0){
                    System.out.println("ligne induce"+i);
                    value=value+"null";
                    continue;
                }
                valuecolonne[i]=formatString(valuecolonne[i]);
               
                if(getModeinsert().get(colonneattribue[i].toUpperCase()).compareTo("vide")==0){
                    value=value+valuecolonne[i];
                }else if(getModeinsert().get(colonneattribue[i].toUpperCase()).compareTo("parenthese")==0){
                    value=value+"'"+valuecolonne[i]+"'";
                }else{
                    value=value+"null";
                }
                if(i<colonneattribue.length-1){
                    value=value+",";
                }
            }
           
        }
        value="("+value+");";
        return " insert into "+this.nomtable+" ("+colonneinsert+") values "+value;
    }

     public String uploadCSV(MultipartFile file) {
        getInscription();
        if (file.isEmpty()) {
            return "Veuillez sélectionner un fichier CSV.";
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            String query="";
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            if(lines.size()>1){
                String nomcolonne =  lines.get(0);
                for(int i=1;i<lines.size();i++){
                    query=query+getformatInsert(nomcolonne, lines.get(i));
                }
                try {
                    System.out.println(query);
                    Connection connection = new ConnectionPostgres().getconnexion();
                    Statement stmt = connection.createStatement();
                    stmt.executeUpdate(query);
                    connection.close();
                    stmt.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            return "Fichier CSV importé avec succès.";
        } catch (Exception e) {
            return "Erreur lors de l'import du fichier CSV : " + e.getMessage();
        }
    }

  
}
