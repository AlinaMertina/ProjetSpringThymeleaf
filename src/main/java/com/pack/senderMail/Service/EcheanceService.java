package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Echeance;
import com.pack.senderMail.Repository.EcheanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EcheanceService {
    EcheanceRepository echeanceRepository;

    @Autowired
    public EcheanceService(EcheanceRepository echeanceRepository){
        this.echeanceRepository=echeanceRepository;
    }

    public java.util.List<Echeance> findAll(){
        return echeanceRepository.findAll();
    }

    public Echeance findById(Long idEcheance ){
        return echeanceRepository.findById(idEcheance).get();
    }
    public void delete(Long idEcheance){
        try{
            echeanceRepository.delete(idEcheance);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void update(Echeance table){
        echeanceRepository.save(table);
    }

    public java.util.List<Echeance> pagination(Long debut){
        return echeanceRepository.pagination(debut);
    }

}
