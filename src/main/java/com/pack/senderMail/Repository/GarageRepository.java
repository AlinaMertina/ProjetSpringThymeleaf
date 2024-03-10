package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface GarageRepository  extends JpaRepository<Garage,Long>{
    
    
    @Query(value = "select * from garage where idgarage=:idgarage", nativeQuery = true)
    public java.util.Optional<Garage> findOne(@Param("idgarage") Long idgarage);
    
    @Query(value = "delete from garage where idgarage=:idgarage", nativeQuery = true)
    public void delete(@Param("idgarage") Long idgarage);


    @Query(value = "select * from garage  limit 5 OFFSET :debut", nativeQuery = true)
    public java.util.List<Garage> pagination(@Param("debut") Long debut);

    @Query(value = "select * from garage where idvehicule=:idvehicule", nativeQuery = true)
    public java.util.Optional<Garage> findByidvehicule(@Param("idvehicule") Long idvehicule);
}
