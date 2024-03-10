package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Vehicule;
import com.pack.senderMail.Repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class VehiculeService {
    VehiculeRepository vehiculeRepository;

    @Autowired
    public VehiculeService(VehiculeRepository vehiculeRepository){
        this.vehiculeRepository=vehiculeRepository;
    }

    public java.util.List<Vehicule> findAll(){
        return vehiculeRepository.findAll();
    }

    public Vehicule findById(Long idVehicule ){
        return vehiculeRepository.findById(idVehicule).get();
    }
    public void delete(Long idVehicule){
        try{
            vehiculeRepository.delete(idVehicule);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void update(Vehicule table){
        vehiculeRepository.save(table);
    }

    public java.util.List<Vehicule> pagination(Long debut){
        return vehiculeRepository.pagination(debut);
    }

}
