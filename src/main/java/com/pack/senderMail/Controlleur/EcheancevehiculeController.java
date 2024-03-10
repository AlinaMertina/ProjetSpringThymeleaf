package com.pack.senderMail.Controlleur;
import com.pack.senderMail.Entity.*;
import com.pack.senderMail.Repository.HistoriqueecheancevehiculeRepository;
import com.pack.senderMail.Service.*;
import java.text.SimpleDateFormat;
import com.pack.senderMail.Work.*;

import lombok.RequiredArgsConstructor;

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
@RequiredArgsConstructor
public class EcheancevehiculeController {

 private final EcheancevehiculeService echeancevehiculeService;
 private final HistoriqueecheancevehiculeRepository historiqueecheancevehiculeService;
    
   

    @GetMapping("/sender/echeancevehicules")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,echeancevehiculeService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @GetMapping("/sender/echeancevehicule")
    public Returntype findOne( @RequestParam("id") Long idEcheancevehicule ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,echeancevehiculeService.findById(idEcheancevehicule));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/sender/echeancevehicule")
    public Returntype  delete(@RequestParam("id") Long idEcheancevehicule){
        Returntype returntype = new Returntype();
        try {
            echeancevehiculeService.delete(idEcheancevehicule);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/sender/echeancevehicule")
    public Returntype  update(@RequestBody Echeancevehicule table){
        Returntype returntype = new Returntype();
        try {
            Echeancevehicule echeancevehicule = echeancevehiculeService.findById(table.getIdecheancevehicule());
                if(table.getIdecheancevehicule() !=null){
                    echeancevehicule.setIdecheancevehicule(table.getIdecheancevehicule());
                }
                if(table.getIdvehicule() !=null){
                    echeancevehicule.setIdvehicule(table.getIdvehicule());
                }
                if(table.getIdecheance() !=null){
                    echeancevehicule.setIdecheance(table.getIdecheance());
                }
                if(table.getDateecheancevehicule() !=null){
                    echeancevehicule.setDateecheancevehicule(table.getDateecheancevehicule());
                }
            echeancevehiculeService.update(echeancevehicule);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/sender/Echeancevehicule")
    public Returntype  insertpost(@RequestBody Echeancevehicule table){
        Returntype returntype = new Returntype();
       

        try {
            Echeancevehicule echeancevehicule = echeancevehiculeService.findByidvehicule(table.getIdvehicule(), table.getIdecheance());
            if(echeancevehicule==null){
                echeancevehiculeService.update(table);
            }else{
                echeancevehicule.setDateecheancevehicule(table.getDateecheancevehicule());
                echeancevehiculeService.update(echeancevehicule);
            }
            
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @PostMapping("/sender/Echeancevehiculeup")
    public Returntype  insertup(@RequestBody Echeancevehicule table){
        Returntype returntype = new Returntype();
        try {
            Echeancevehicule echeancevehicule = echeancevehiculeService.findById(table.getIdecheancevehicule());
            Historiqueecheancevehicule historiqueecheancevehicule = new Historiqueecheancevehicule(null, echeancevehicule.getIdecheancevehicule(), echeancevehicule.getIdvehicule(), echeancevehicule.getIdecheance(), echeancevehicule.getDateecheancevehicule(), new java.util.Date());
            historiqueecheancevehiculeService.save(historiqueecheancevehicule);

                if(table.getIdecheancevehicule() !=null){
                    echeancevehicule.setIdecheancevehicule(table.getIdecheancevehicule());
                }
                if(table.getIdvehicule() !=null){
                    echeancevehicule.setIdvehicule(table.getIdvehicule());
                }
                if(table.getIdecheance() !=null){
                    echeancevehicule.setIdecheance(table.getIdecheance());
                }
                if(table.getDateecheancevehicule() !=null){
                    echeancevehicule.setDateecheancevehicule(table.getDateecheancevehicule());
                }
            echeancevehiculeService.update(echeancevehicule);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
}
