package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface UsersRepository  extends JpaRepository<Users,Long>{
    
    
    @Query(value = "select * from users where id=:id", nativeQuery = true)
    public java.util.Optional<Users> findOne(@Param("id") Integer id);
    
    @Query(value = "delete from users where id=:id", nativeQuery = true)
    public void delete(@Param("id") Integer id);


    @Query(value = "select * from users  limit 5 OFFSET :debut", nativeQuery = true)
    public java.util.List<Users> pagination(@Param("debut") Long debut);
}
