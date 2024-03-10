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
public class UtilisateurApkController {
    
        private final RoleService roleService;

    public void alimentation(Model model){
        model.addAttribute("listerole", roleService.findAll());
    }



    private final UtilisateurService utilisateurService;

        private final V_utilisateurService v_utilisateurService;

    Long suivant =0L;
    Long precedent =0L;
    
    @GetMapping("/sender/Utilisateurpagprecedent")
    public String paginationprecedent(Model model ){

            model.addAttribute("liste", v_utilisateurService.pagination(precedent) );
        alimentation(model);
        if(precedent >0 ){
            precedent =precedent -5;
        }
        return  "Utilisateur";
    }
    @GetMapping("/sender/Utilisateurpagsuivant")
    public String paginationsuivant( Model model ){

            model.addAttribute("liste", v_utilisateurService.pagination(suivant) );

        alimentation(model);
        precedent=suivant-5;
        suivant =suivant +5;
        return  "Utilisateur";
    }
    @GetMapping("/sender/Utilisateurdel")
    public String delete(@RequestParam("id") Long id, Model model ){
        utilisateurService.delete(id);
        return paginationprecedent(model);
    }

}
