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
public class UtilisateurController {

 private final UtilisateurService utilisateurService;
    
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService){
        this.utilisateurService= utilisateurService;
    }

    @GetMapping("/sender/utilisateurs")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,utilisateurService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @GetMapping("/sender/utilisateur")
    public Returntype findOne( @RequestParam("id") Long idUtilisateur ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,utilisateurService.findById(idUtilisateur));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/sender/utilisateur")
    public Returntype  delete(@RequestParam("id") Long idUtilisateur){
        Returntype returntype = new Returntype();
        try {
            utilisateurService.delete(idUtilisateur);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/sender/utilisateur")
    public Returntype  update(@RequestBody Utilisateur table){
        Returntype returntype = new Returntype();
        try {
            Utilisateur utilisateur = utilisateurService.findById(table.getIdutilisateur());
                if(table.getIdutilisateur() !=null){
                    utilisateur.setIdutilisateur(table.getIdutilisateur());
                }
                if(table.getIdrole() !=null){
                    utilisateur.setIdrole(table.getIdrole());
                }
                if(table.getNomutilisateur() !=null){
                    utilisateur.setNomutilisateur(table.getNomutilisateur());
                }
                if(table.getPrenom() !=null){
                    utilisateur.setPrenom(table.getPrenom());
                }
                if(table.getDatenaissance() !=null){
                    utilisateur.setDatenaissance(table.getDatenaissance());
                }
                if(table.getEmail() !=null){
                    utilisateur.setEmail(table.getEmail());
                }
                if(table.getPassword() !=null){
                    utilisateur.setPassword(table.getPassword());
                }
                if(table.getActiver() !=null){
                    utilisateur.setActiver(table.getActiver());
                }
            utilisateurService.update(utilisateur);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/sender/Utilisateur")
    public Returntype  insertpost(@RequestBody Utilisateur table){
        Returntype returntype = new Returntype();
        try {
            utilisateurService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @PostMapping("/sender/Utilisateurup")
    public Returntype  insertup(@RequestBody Utilisateur table){
        Returntype returntype = new Returntype();
        try {
            Utilisateur utilisateur = utilisateurService.findById(table.getIdutilisateur());
                if(table.getIdutilisateur() !=null){
                    utilisateur.setIdutilisateur(table.getIdutilisateur());
                }
                if(table.getIdrole() !=null){
                    utilisateur.setIdrole(table.getIdrole());
                }
                if(table.getNomutilisateur() !=null){
                    utilisateur.setNomutilisateur(table.getNomutilisateur());
                }
                if(table.getPrenom() !=null){
                    utilisateur.setPrenom(table.getPrenom());
                }
                if(table.getDatenaissance() !=null){
                    utilisateur.setDatenaissance(table.getDatenaissance());
                }
                if(table.getEmail() !=null){
                    utilisateur.setEmail(table.getEmail());
                }
                if(table.getPassword() !=null){
                    utilisateur.setPassword(table.getPassword());
                }
                if(table.getActiver() !=null){
                    utilisateur.setActiver(table.getActiver());
                }
            utilisateurService.update(utilisateur);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
}
