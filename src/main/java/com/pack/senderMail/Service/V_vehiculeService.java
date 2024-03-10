package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.V_vehicule;
import com.pack.senderMail.Repository.V_vehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_vehiculeService {
    V_vehiculeRepository v_vehiculeRepository;

    @Autowired
    public V_vehiculeService(V_vehiculeRepository v_vehiculeRepository){
        this.v_vehiculeRepository=v_vehiculeRepository;
    }

    public java.util.List<V_vehicule> findAll(){
        return new V_vehicule().findAll();
    }

    public java.util.List<V_vehicule> pagination(Long debut){
        return  new V_vehicule().pagination(debut);
    }

}
