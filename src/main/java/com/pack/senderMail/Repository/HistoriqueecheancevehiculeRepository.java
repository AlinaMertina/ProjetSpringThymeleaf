package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Historiqueecheancevehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface HistoriqueecheancevehiculeRepository  extends JpaRepository<Historiqueecheancevehicule,Long>{
    
}
