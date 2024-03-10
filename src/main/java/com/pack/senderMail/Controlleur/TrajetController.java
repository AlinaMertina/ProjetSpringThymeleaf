package com.pack.senderMail.Controlleur;
import com.pack.senderMail.Entity.Trajet;
import com.pack.senderMail.Service.TrajetService;
import java.text.SimpleDateFormat;
import com.pack.senderMail.Work.Returntype;
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
public class TrajetController {

 private final TrajetService trajetService;
    
    @Autowired
    public TrajetController(TrajetService trajetService){
        this.trajetService= trajetService;
    }

    @GetMapping("/gestionvehiculeevaluation/trajets")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,trajetService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @GetMapping("/gestionvehiculeevaluation/trajet")
    public Returntype findOne( @RequestParam("id") Long idTrajet ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,trajetService.findOne(idTrajet));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/gestionvehiculeevaluation/trajet")
    public Returntype  delete(@RequestParam("id") Long idTrajet){
        Returntype returntype = new Returntype();
        try {
            trajetService.delete(idTrajet);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/gestionvehiculeevaluation/trajet")
    public Returntype  update(@RequestBody Trajet table){
        Returntype returntype = new Returntype();
        try {
            trajetService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    
    @PostMapping("/gestionvehiculeevaluation/Trajetup")
    public Returntype  insertup(@RequestBody Trajet table){
        Returntype returntype = new Returntype();
        try {
            trajetService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }


    @PostMapping("/gestionvehiculeevaluation/getlastetrajet")
    public Returntype  getlastetrajet(@RequestBody Long idtrajet){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,trajetService.findidvehicule(idtrajet));
        } catch (Exception e) {
            System.out.println(e);
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
}
