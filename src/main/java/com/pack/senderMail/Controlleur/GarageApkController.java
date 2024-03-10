package com.pack.senderMail.Controlleur;
import com.pack.senderMail.Entity.*;
import com.pack.senderMail.Service.*;
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
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class GarageApkController {
    

    private final VehiculeService vehiculeService;
    private final GarageService garageService;
    private final V_garageService v_garageService;
    public void alimentation(Model model){
        model.addAttribute("listevehicule", vehiculeService.findAll());
    }
    

    Long suivant =0L;
    Long precedent =0L;
    
    @GetMapping("/sender/Garagepagprecedent")
    public String paginationprecedent(Model model ){
        model.addAttribute("liste", v_garageService.pagination(precedent) );
        alimentation(model);
        if(precedent >0 ){
            precedent =precedent -5;
        }
        return  "Garage";
    }
    @GetMapping("/sender/Garagepagsuivant")
    public String paginationsuivant( Model model ){
       
        model.addAttribute("liste", v_garageService.pagination(suivant) );

        alimentation(model);
        precedent=suivant-5;
        suivant =suivant +5;
        return  "Garage";
    }
    @GetMapping("/sender/Garagedel")
    public String delete(@RequestParam("id") Long id, Model model ){
        garageService.delete(id);
        return paginationprecedent(model);
    }

}