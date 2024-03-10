package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Echeancevehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface EcheancevehiculeRepository  extends JpaRepository<Echeancevehicule,Long>{
    
    
    @Query(value = "select * from echeancevehicule where idecheancevehicule=:idecheancevehicule", nativeQuery = true)
    public java.util.Optional<Echeancevehicule> findOne(@Param("idecheancevehicule") Long idecheancevehicule);
    
    @Query(value = "delete from echeancevehicule where idecheancevehicule=:idecheancevehicule", nativeQuery = true)
    public void delete(@Param("idecheancevehicule") Long idecheancevehicule);


    @Query(value = "select * from echeancevehicule  limit 5 OFFSET :debut", nativeQuery = true)
    public java.util.List<Echeancevehicule> pagination(@Param("debut") Long debut);

    @Query(value = "select * from echeancevehicule where idvehicule=:idv and idecheance=:ide", nativeQuery = true)
    public java.util.Optional<Echeancevehicule> findByidvehicule(@Param("idv") Long idv ,@Param("ide") Long ide );
}
