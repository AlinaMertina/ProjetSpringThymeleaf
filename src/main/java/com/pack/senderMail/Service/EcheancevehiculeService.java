package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Echeancevehicule;
import com.pack.senderMail.Repository.EcheancevehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EcheancevehiculeService {
    EcheancevehiculeRepository echeancevehiculeRepository;

    @Autowired
    public EcheancevehiculeService(EcheancevehiculeRepository echeancevehiculeRepository){
        this.echeancevehiculeRepository=echeancevehiculeRepository;
    }

    public java.util.List<Echeancevehicule> findAll(){
        return echeancevehiculeRepository.findAll();
    }

    public Echeancevehicule findById(Long idEcheancevehicule ){
        return echeancevehiculeRepository.findById(idEcheancevehicule).get();
    }

    public Echeancevehicule findByidvehicule(Long idv,Long ide ){
        return echeancevehiculeRepository.findByidvehicule(idv,ide).get();
    }

    public void delete(Long idEcheancevehicule){
        try{
            echeancevehiculeRepository.delete(idEcheancevehicule);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void update(Echeancevehicule table){
        echeancevehiculeRepository.save(table);
    }

    public java.util.List<Echeancevehicule> pagination(Long debut){
        return echeancevehiculeRepository.pagination(debut);
    }

}
