package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Typevehicule;
import com.pack.senderMail.Repository.TypevehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TypevehiculeService {
    TypevehiculeRepository typevehiculeRepository;

    @Autowired
    public TypevehiculeService(TypevehiculeRepository typevehiculeRepository){
        this.typevehiculeRepository=typevehiculeRepository;
    }

    public java.util.List<Typevehicule> findAll(){
        return typevehiculeRepository.findAll();
    }

    public Typevehicule findOne(Long idTypevehicule ){
        return typevehiculeRepository.findOne(idTypevehicule).get();
    }
    public void delete(Long idTypevehicule){
        try{
            typevehiculeRepository.delete(idTypevehicule);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void update(Typevehicule table){
        typevehiculeRepository.save(table);
    }

    public java.util.List<Typevehicule> pagination(Long debut){
        return typevehiculeRepository.pagination(debut);
    }

}
