

package com.pack.senderMail.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Role{

    public Role(){}
        @Id
        @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
        )
        @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
        )
          Long idrole;
          String nomrole;
              public void setIdrole( Long idrole){
                  this.idrole=idrole;
              }
          
              public Long getIdrole(){
                  return this.idrole;
              }
              public void setNomrole( String nomrole){
                  this.nomrole=nomrole;
              }
          
              public String getNomrole(){
                  return this.nomrole;
              }
}
