package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Lieu;
import com.pack.senderMail.Repository.LieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LieuService {
    LieuRepository lieuRepository;

    @Autowired
    public LieuService(LieuRepository lieuRepository){
        this.lieuRepository=lieuRepository;
    }

    public java.util.List<Lieu> findAll(){
        return lieuRepository.findAll();
    }

    public Lieu findById(Long idLieu ){
        return lieuRepository.findById(idLieu).get();
    }
    public void delete(Long idLieu){
        try{
            lieuRepository.delete(idLieu);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void update(Lieu table){
        lieuRepository.save(table);
    }

    public java.util.List<Lieu> pagination(Long debut){
        return lieuRepository.pagination(debut);
    }

}
