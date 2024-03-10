package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Personnevalue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface PersonnevalueRepository  extends JpaRepository<Personnevalue,Long>{
    
    
    @Query(value = "select * from personnevalue where idpersonnevalue=:idpersonnevalue", nativeQuery = true)
    public java.util.Optional<Personnevalue> findOne(@Param("idpersonnevalue") String idpersonnevalue);
    
    @Query(value = "delete from personnevalue where idpersonnevalue=:idpersonnevalue", nativeQuery = true)
    public void delete(@Param("idpersonnevalue") String idpersonnevalue);


    @Query(value = "select * from personnevalue  limit 5 OFFSET :debut", nativeQuery = true)
    public java.util.List<Personnevalue> pagination(@Param("debut") Long debut);
}
