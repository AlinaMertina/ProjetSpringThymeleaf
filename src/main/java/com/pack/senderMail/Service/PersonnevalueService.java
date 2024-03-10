package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Personnevalue;
import com.pack.senderMail.Repository.PersonnevalueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonnevalueService {
    PersonnevalueRepository personnevalueRepository;

    @Autowired
    public PersonnevalueService(PersonnevalueRepository personnevalueRepository){
        this.personnevalueRepository=personnevalueRepository;
    }

    public java.util.List<Personnevalue> findAll(){
        return personnevalueRepository.findAll();
    }

    public Personnevalue findById(String idPersonnevalue ){
        return personnevalueRepository.findOne(idPersonnevalue).get();
    }
    public void delete(String idPersonnevalue){
        try{
            personnevalueRepository.delete(idPersonnevalue);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void update(Personnevalue table){
        personnevalueRepository.save(table);
    }

    public java.util.List<Personnevalue> pagination(Long debut){
        return personnevalueRepository.pagination(debut);
    }

}
