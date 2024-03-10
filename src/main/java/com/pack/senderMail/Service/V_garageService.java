package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.V_garage;
import com.pack.senderMail.Repository.V_garageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_garageService {
    V_garageRepository v_garageRepository;

    @Autowired
    public V_garageService(V_garageRepository v_garageRepository){
        this.v_garageRepository=v_garageRepository;
    }

    public java.util.List<V_garage> findAll(){
        return new V_garage().findAll();
    }

    public java.util.List<V_garage> pagination(Long debut){
        return  new V_garage().pagination(debut);
    }

}
