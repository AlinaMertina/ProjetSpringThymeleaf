package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface VehiculeRepository  extends JpaRepository<Vehicule,Long>{
    
    
    @Query(value = "select * from vehicule where idvehicule=:idvehicule", nativeQuery = true)
    public java.util.Optional<Vehicule> findOne(@Param("idvehicule") Long idvehicule);
    
    @Query(value = "delete from vehicule where idvehicule=:idvehicule", nativeQuery = true)
    public void delete(@Param("idvehicule") Long idvehicule);


    @Query(value = "select * from vehicule  limit 5 OFFSET :debut", nativeQuery = true)
    public java.util.List<Vehicule> pagination(@Param("debut") Long debut);
}
