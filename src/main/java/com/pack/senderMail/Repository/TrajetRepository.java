package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface TrajetRepository  extends JpaRepository<Trajet,Long>{
    
    
    @Query(value = "select * from trajet where idtrajet=:idtrajet", nativeQuery = true)
    public java.util.Optional<Trajet> findOne(@Param("idtrajet") Long idtrajet);

    @Query(value = "select * from trajet where idvehicule=:idvehicule order by idtrajet desc  limit 1", nativeQuery = true)
    public java.util.Optional<Trajet> findidvehicule(@Param("idvehicule") Long idvehicule);
    
    @Query(value = "delete from trajet where idtrajet=:idtrajet", nativeQuery = true)
    public void delete(@Param("idtrajet") Long idtrajet);


    @Query(value = "select * from trajet  limit 5 OFFSET :debut", nativeQuery = true)
    public java.util.List<Trajet> pagination(@Param("debut") Long debut);


    @Query(value = "select * from trajet  where idutilisateur=:id limit 5 OFFSET :debut ", nativeQuery = true)
    public java.util.List<Trajet> findByutilisateur(@Param("id") Long idutilisateur,@Param("debut") Long debut);
}
