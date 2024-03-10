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
public class EcheanceController {

 private final EcheanceService echeanceService;
    
    @Autowired
    public EcheanceController(EcheanceService echeanceService){
        this.echeanceService= echeanceService;
    }

    @GetMapping("/sender/echeances")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,echeanceService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @GetMapping("/sender/echeance")
    public Returntype findOne( @RequestParam("id") Long idEcheance ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,echeanceService.findById(idEcheance));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/sender/echeance")
    public Returntype  delete(@RequestParam("id") Long idEcheance){
        Returntype returntype = new Returntype();
        try {
            echeanceService.delete(idEcheance);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/sender/echeance")
    public Returntype  update(@RequestBody Echeance table){
        Returntype returntype = new Returntype();
        try {
            Echeance echeance = echeanceService.findById(table.getIdecheance());
                if(table.getIdecheance() !=null){
                    echeance.setIdecheance(table.getIdecheance());
                }
                if(table.getNomecheance() !=null){
                    echeance.setNomecheance(table.getNomecheance());
                }
            echeanceService.update(echeance);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/sender/Echeance")
    public Returntype  insertpost(@RequestBody Echeance table){
        Returntype returntype = new Returntype();
        try {
            echeanceService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @PostMapping("/sender/Echeanceup")
    public Returntype  insertup(@RequestBody Echeance table){
        Returntype returntype = new Returntype();
        try {
            Echeance echeance = echeanceService.findById(table.getIdecheance());
                if(table.getIdecheance() !=null){
                    echeance.setIdecheance(table.getIdecheance());
                }
                if(table.getNomecheance() !=null){
                    echeance.setNomecheance(table.getNomecheance());
                }
            echeanceService.update(echeance);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
}
