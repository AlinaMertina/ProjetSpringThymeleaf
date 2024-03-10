package com.pack.senderMail.Controlleur;
import com.pack.senderMail.Entity.Typevehicule;
import com.pack.senderMail.Service.TypevehiculeService;
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
public class TypevehiculeApkController {

    private final TypevehiculeService typevehiculeService;
    Long suivant =0L;
    Long precedent =0L;
    
    @GetMapping("/gestionvehiculeevaluation/Typevehiculepagprecedent")
    public String paginationprecedent(Model model ){
        model.addAttribute("liste", typevehiculeService.pagination(precedent) );
         if(precedent >0 ){
            precedent =precedent -5;
        }
        return  "Typevehicule";
    }
    @GetMapping("/gestionvehiculeevaluation/Typevehiculepagsuivant")
    public String paginationsuivant( Model model ){
        model.addAttribute("liste", typevehiculeService.pagination(suivant) );
        precedent=suivant-5;
        suivant =suivant +5;
        return  "Typevehicule";
    }
    @GetMapping("/gestionvehiculeevaluation/Typevehiculedel")
    public String delete(@RequestParam("id") Long id, Model model ){
        typevehiculeService.delete(id);
        return paginationprecedent(model);
    }

}
