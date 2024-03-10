package com.pack.senderMail.Controlleur;
import com.lowagie.text.html.HtmlParser;
import com.pack.senderMail.Entity.Trajet;
import com.pack.senderMail.Entity.Utilisateur;
import com.pack.senderMail.Entity.V_trajet;
import com.pack.senderMail.Service.LieuService;
import com.pack.senderMail.Service.TrajetService;
import com.pack.senderMail.Service.VehiculeService;

import java.text.SimpleDateFormat;
import com.pack.senderMail.Work.Returntype;

import jakarta.servlet.http.HttpSession;

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
public class TrajetApkController {

    private final TrajetService trajetService;
    private final LieuService lieuService;
    private final VehiculeService vehiculeService;

    Long suivant =0L;
    Long precedent =0L;
    
    @GetMapping("/gestionvehiculeevaluation/Trajetpagprecedent")
    public String paginationprecedent(Model model ,HttpSession session){
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
        model.addAttribute("liste",new V_trajet().pagination(utilisateur.getIdutilisateur(),precedent) );
        model.addAttribute("listelieu",lieuService.findAll() );
        model.addAttribute("listevehicule",vehiculeService.findAll() );


         if(precedent >0 ){
            precedent =precedent -5;
        }
        return  "Trajet";
    }
    @GetMapping("/gestionvehiculeevaluation/Trajetpagsuivant")
    public String paginationsuivant( Model model,HttpSession session ){
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
        model.addAttribute("liste", new V_trajet().pagination(utilisateur.getIdutilisateur(),suivant) );
        model.addAttribute("listelieu",lieuService.findAll() );
        model.addAttribute("listevehicule",vehiculeService.findAll() );


        precedent=suivant-5;
        suivant =suivant +5;
        return  "Trajet";
    }
    @GetMapping("/gestionvehiculeevaluation/Trajetdel")
    public String delete(@RequestParam("id") Long id, Model model,HttpSession session ){
        trajetService.delete(id);
        return paginationprecedent(model,session);
    }

}
