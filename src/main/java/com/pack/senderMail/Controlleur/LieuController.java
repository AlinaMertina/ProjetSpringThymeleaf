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
public class LieuController {

 private final LieuService lieuService;
    
    @Autowired
    public LieuController(LieuService lieuService){
        this.lieuService= lieuService;
    }

    @GetMapping("/sender/lieus")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,lieuService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @GetMapping("/sender/lieu")
    public Returntype findOne( @RequestParam("id") Long idLieu ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,lieuService.findById(idLieu));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/sender/lieu")
    public Returntype  delete(@RequestParam("id") Long idLieu){
        Returntype returntype = new Returntype();
        try {
            lieuService.delete(idLieu);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/sender/lieu")
    public Returntype  update(@RequestBody Lieu table){
        Returntype returntype = new Returntype();
        try {
            Lieu lieu = lieuService.findById(table.getIdlieu());
                if(table.getIdlieu() !=null){
                    lieu.setIdlieu(table.getIdlieu());
                }
                if(table.getNomlieu() !=null){
                    lieu.setNomlieu(table.getNomlieu());
                }
            lieuService.update(lieu);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/sender/Lieu")
    public Returntype  insertpost(@RequestBody Lieu table){
        Returntype returntype = new Returntype();
        try {
            lieuService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @PostMapping("/sender/Lieuup")
    public Returntype  insertup(@RequestBody Lieu table){
        Returntype returntype = new Returntype();
        try {
            Lieu lieu = lieuService.findById(table.getIdlieu());
                if(table.getIdlieu() !=null){
                    lieu.setIdlieu(table.getIdlieu());
                }
                if(table.getNomlieu() !=null){
                    lieu.setNomlieu(table.getNomlieu());
                }
            lieuService.update(lieu);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
}
