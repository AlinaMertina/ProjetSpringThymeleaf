package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.V_echeancevehicule;
import com.pack.senderMail.Repository.V_echeancevehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_echeancevehiculeService {
    V_echeancevehiculeRepository v_echeancevehiculeRepository;

    @Autowired
    public V_echeancevehiculeService(V_echeancevehiculeRepository v_echeancevehiculeRepository){
        this.v_echeancevehiculeRepository=v_echeancevehiculeRepository;
    }

    public java.util.List<V_echeancevehicule> findAll(){
        return new V_echeancevehicule().findAll();
    }

    public java.util.List<V_echeancevehicule> pagination(Long debut){
        return  new V_echeancevehicule().pagination(debut);
    }

}
