package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.V_vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface V_vehiculeRepository  extends JpaRepository<V_vehicule,Long>{
    
}
