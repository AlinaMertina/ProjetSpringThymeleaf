package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Trajet;
import com.pack.senderMail.Repository.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TrajetService {
    TrajetRepository trajetRepository;

    @Autowired
    public TrajetService(TrajetRepository trajetRepository){
        this.trajetRepository=trajetRepository;
    }

    public java.util.List<Trajet> findAll(){
        return trajetRepository.findAll();
    }

    public Trajet findOne(Long idTrajet ){
        return trajetRepository.findOne(idTrajet).get();
    }

    public Trajet findidvehicule(Long idTrajet ){
        try {
            return trajetRepository.findidvehicule(idTrajet).get();
        } catch (Exception e) {
            return null;
        }
       
    }

    public void delete(Long idTrajet){
        try{
            trajetRepository.delete(idTrajet);
        }catch(Exception e){
            System.out.println(e);
        }
    }



    public void update(Trajet table){
        trajetRepository.save(table);
    }

    public java.util.List<Trajet> pagination(Long debut){
        return trajetRepository.pagination(debut);
    }
    public java.util.List<Trajet> findByutilisateur(Long idutilisateur,Long debut){
        return trajetRepository.findByutilisateur(idutilisateur,debut);
    }

}
