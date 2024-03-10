package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Role;
import com.pack.senderMail.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RoleService {
    RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    public java.util.List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role findOne(Long idRole ){
        return roleRepository.findOne(idRole).get();
    }

    public void delete(Long idRole){
        roleRepository.deleteById(idRole);
    }

    public void update(Role table){
        roleRepository.save(table);
    }
}
