
package com.pack.senderMail.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Users{

    public Users(){}
        @Id
        @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
        )

          Integer id;
          String username;
          String email;

    
    public void setId( Integer id){
        this.id=id;
    }
    public Integer getId(){
        return this.id;
    }
    public void setUsername( String username){
        this.username=username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setEmail( String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }

    public Users (Integer id,String username,String email){
        this.id=id;
        this.username=username;
        this.email=email;
    }
}
