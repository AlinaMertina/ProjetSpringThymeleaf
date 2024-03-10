package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface LieuRepository  extends JpaRepository<Lieu,Long>{
    
    
    @Query(value = "select * from lieu where idlieu=:idlieu", nativeQuery = true)
    public java.util.Optional<Lieu> findOne(@Param("idlieu") Long idlieu);
    
    @Query(value = "delete from lieu where idlieu=:idlieu", nativeQuery = true)
    public void delete(@Param("idlieu") Long idlieu);


    @Query(value = "select * from lieu  limit 5 OFFSET :debut", nativeQuery = true)
    public java.util.List<Lieu> pagination(@Param("debut") Long debut);
}
