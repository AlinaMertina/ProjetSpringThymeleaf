package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface UtilisateurRepository  extends JpaRepository<Utilisateur,Long>{
    
    
    @Query(value = "select * from utilisateur where idutilisateur=:idutilisateur", nativeQuery = true)
    public java.util.Optional<Utilisateur> findOne(@Param("idutilisateur") Long idutilisateur);
    
    @Query(value = "delete from utilisateur where idutilisateur=:idutilisateur", nativeQuery = true)
    public void delete(@Param("idutilisateur") Long idutilisateur);


    @Query(value = "select * from utilisateur  limit 5 OFFSET :debut", nativeQuery = true)
    public java.util.List<Utilisateur> pagination(@Param("debut") Long debut);


    @Query(value = "select * from utilisateur where email=:email and password=:password", nativeQuery = true)
    public java.util.Optional<Utilisateur> findUser(@Param("email") String  email ,@Param("password") String  password );
    

}
