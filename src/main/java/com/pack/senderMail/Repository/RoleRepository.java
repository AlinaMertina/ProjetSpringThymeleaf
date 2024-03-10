package com.pack.senderMail.Repository;
import com.pack.senderMail.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface RoleRepository  extends JpaRepository<Role,Long>{
    
    @Query(value = "select * from role where idrole=:idrole", nativeQuery = true)
    public java.util.Optional<Role> findOne(@Param("idrole") Long idrole);
}
