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
public class PersonnevalueController {

 private final PersonnevalueService personnevalueService;
    
    @Autowired
    public PersonnevalueController(PersonnevalueService personnevalueService){
        this.personnevalueService= personnevalueService;
    }

    @GetMapping("/varotrafiaraback/personnevalues")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,personnevalueService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @GetMapping("/varotrafiaraback/personnevalue")
    public Returntype findOne( @RequestParam("id") String idPersonnevalue ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,personnevalueService.findById(idPersonnevalue));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/personnevalue")
    public Returntype  delete(@RequestParam("id") String idPersonnevalue){
        Returntype returntype = new Returntype();
        try {
            personnevalueService.delete(idPersonnevalue);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/personnevalue")
    public Returntype  update(@RequestBody Personnevalue table){
        Returntype returntype = new Returntype();
        try {
            Personnevalue personnevalue = personnevalueService.findById(table.getIdpersonnevalue());
                if(table.getIdpersonnevalue() !=null){
                    personnevalue.setIdpersonnevalue(table.getIdpersonnevalue());
                }
                if(table.getNompersonnevalue() !=null){
                    personnevalue.setNompersonnevalue(table.getNompersonnevalue());
                }
            personnevalueService.update(personnevalue);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/Personnevalue")
    public Returntype  insertpost(@RequestBody Personnevalue table){
        Returntype returntype = new Returntype();
        try {
            System.out.println(table.getNompersonnevalue());
                table.setIdpersonnevalue(ModelBuilderExtensions.useCustomSequence("personnevalue"));
            personnevalueService.update(table);
            System.out.println(table.getIdpersonnevalue());
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @PostMapping("/varotrafiaraback/Personnevalueup")
    public Returntype  insertup(@RequestBody Personnevalue table){
        Returntype returntype = new Returntype();
        try {
            Personnevalue personnevalue = personnevalueService.findById(table.getIdpersonnevalue());
                if(table.getIdpersonnevalue() !=null){
                    personnevalue.setIdpersonnevalue(table.getIdpersonnevalue());
                }
                if(table.getNompersonnevalue() !=null){
                    personnevalue.setNompersonnevalue(table.getNompersonnevalue());
                }
            personnevalueService.update(personnevalue);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
}
