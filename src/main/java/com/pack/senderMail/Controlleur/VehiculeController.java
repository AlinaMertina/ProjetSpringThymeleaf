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
public class VehiculeController {

 private final VehiculeService vehiculeService;
    
    @Autowired
    public VehiculeController(VehiculeService vehiculeService){
        this.vehiculeService= vehiculeService;
    }

    @GetMapping("/sender/vehicules")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,vehiculeService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @GetMapping("/sender/vehicule")
    public Returntype findOne( @RequestParam("id") Long idVehicule ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,vehiculeService.findById(idVehicule));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/sender/vehicule")
    public Returntype  delete(@RequestParam("id") Long idVehicule){
        Returntype returntype = new Returntype();
        try {
            vehiculeService.delete(idVehicule);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/sender/vehicule")
    public Returntype  update(@RequestBody Vehicule table){
        Returntype returntype = new Returntype();
        try {
            Vehicule vehicule = vehiculeService.findById(table.getIdvehicule());
                if(table.getIdvehicule() !=null){
                    vehicule.setIdvehicule(table.getIdvehicule());
                }
                if(table.getNumero() !=null){
                    vehicule.setNumero(table.getNumero());
                }
                if(table.getMarque() !=null){
                    vehicule.setMarque(table.getMarque());
                }
                if(table.getModel() !=null){
                    vehicule.setModel(table.getModel());
                }
                if(table.getIdtypevehicule() !=null){
                    vehicule.setIdtypevehicule(table.getIdtypevehicule());
                }
            vehiculeService.update(vehicule);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/sender/Vehicule")
    public Returntype  insertpost(@RequestBody Vehicule table){
        Returntype returntype = new Returntype();
        try {
            vehiculeService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @PostMapping("/sender/Vehiculeup")
    public Returntype  insertup(@RequestBody Vehicule table){
        Returntype returntype = new Returntype();
        try {
            Vehicule vehicule = vehiculeService.findById(table.getIdvehicule());
                if(table.getIdvehicule() !=null){
                    vehicule.setIdvehicule(table.getIdvehicule());
                }
                if(table.getNumero() !=null){
                    vehicule.setNumero(table.getNumero());
                }
                if(table.getMarque() !=null){
                    vehicule.setMarque(table.getMarque());
                }
                if(table.getModel() !=null){
                    vehicule.setModel(table.getModel());
                }
                if(table.getIdtypevehicule() !=null){
                    vehicule.setIdtypevehicule(table.getIdtypevehicule());
                }
            vehiculeService.update(vehicule);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
}
