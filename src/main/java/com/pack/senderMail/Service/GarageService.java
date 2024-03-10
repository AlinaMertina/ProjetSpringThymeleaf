package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Garage;
import com.pack.senderMail.Repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class GarageService {
    GarageRepository garageRepository;

    @Autowired
    public GarageService(GarageRepository garageRepository){
        this.garageRepository=garageRepository;
    }

    public java.util.List<Garage> findAll(){
        return garageRepository.findAll();
    }

    public Garage findById(Long idGarage ){
        try {
            return garageRepository.findById(idGarage).get();
        } catch (Exception e) {
           return null;
        }
    }
    public Garage findByidvehicule(Long idvehicule ){
        try {
            return garageRepository.findByidvehicule(idvehicule).get();
        } catch (Exception e) {
          return null;
        }
    }

    public void delete(Long idGarage){
        try{
            garageRepository.delete(idGarage);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void update(Garage table){
        garageRepository.save(table);
    }

    public java.util.List<Garage> pagination(Long debut){
        return garageRepository.pagination(debut);
    }

}
