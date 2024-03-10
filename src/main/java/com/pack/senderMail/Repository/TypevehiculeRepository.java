package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Typevehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface TypevehiculeRepository  extends JpaRepository<Typevehicule,Long>{
    
    
    @Query(value = "select * from typevehicule where idtypevehicule=:idtypevehicule", nativeQuery = true)
    public java.util.Optional<Typevehicule> findOne(@Param("idtypevehicule") Long idtypevehicule);
    
    @Query(value = "delete from typevehicule where idtypevehicule=:idtypevehicule", nativeQuery = true)
    public void delete(@Param("idtypevehicule") Long idtypevehicule);


    @Query(value = "select * from typevehicule  limit 5 OFFSET :debut", nativeQuery = true)
    public java.util.List<Typevehicule> pagination(@Param("debut") Long debut);
}
