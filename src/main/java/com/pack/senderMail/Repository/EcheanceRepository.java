package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Echeance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface EcheanceRepository  extends JpaRepository<Echeance,Long>{
    
    
    @Query(value = "select * from echeance where idecheance=:idecheance", nativeQuery = true)
    public java.util.Optional<Echeance> findOne(@Param("idecheance") Long idecheance);
    
    @Query(value = "delete from echeance where idecheance=:idecheance", nativeQuery = true)
    public void delete(@Param("idecheance") Long idecheance);


    @Query(value = "select * from echeance  limit 5 OFFSET :debut", nativeQuery = true)
    public java.util.List<Echeance> pagination(@Param("debut") Long debut);
}
