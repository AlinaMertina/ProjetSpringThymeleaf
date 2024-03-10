package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Historiqueecheancevehicule;
import com.pack.senderMail.Repository.HistoriqueecheancevehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class HistoriqueecheancevehiculeService {
    HistoriqueecheancevehiculeRepository historiqueecheancevehiculeRepository;

    @Autowired
    public HistoriqueecheancevehiculeService(HistoriqueecheancevehiculeRepository historiqueecheancevehiculeRepository){
        this.historiqueecheancevehiculeRepository=historiqueecheancevehiculeRepository;
    }

    public java.util.List<Historiqueecheancevehicule> findAll(){
        return new Historiqueecheancevehicule().findAll();
    }

    public java.util.List<Historiqueecheancevehicule> pagination(Long debut){
        return  new Historiqueecheancevehicule().pagination(debut);
    }

}
