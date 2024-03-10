package com.pack.senderMail.Controlleur;
import com.pack.senderMail.Entity.*;
import com.pack.senderMail.Service.*;
import java.text.SimpleDateFormat;
import com.pack.senderMail.Work.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping
public class GarageController {

 private final GarageService garageService;
    
    @Autowired
    public GarageController(GarageService garageService){
        this.garageService= garageService;
    }

    @GetMapping("/sender/garages")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,garageService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @GetMapping("/sender/garage")
    public Returntype findOne( @RequestParam("id") Long idGarage ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,garageService.findById(idGarage));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/sender/garage")
    public Returntype  delete(@RequestParam("id") Long idGarage){
        Returntype returntype = new Returntype();
        try {
            garageService.delete(idGarage);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/sender/garage")
    public Returntype  update(@RequestBody Garage table){
        Returntype returntype = new Returntype();
        try {
            Garage garage = garageService.findById(table.getIdgarage());
                if(table.getIdgarage() !=null){
                    garage.setIdgarage(table.getIdgarage());
                }
                if(table.getIdvehicule() !=null){
                    garage.setIdvehicule(table.getIdvehicule());
                }
                if(table.getDate() !=null){
                    garage.setDate(table.getDate());
                }
                if(table.getIdutilisateur() !=null){
                    garage.setIdutilisateur(table.getIdutilisateur());
                }
                if(table.getEntersortie() !=null){
                    garage.setEntersortie(table.getEntersortie());
                }
            garageService.update(garage);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

   


   
}
