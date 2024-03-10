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
public class UsersApkController {
    

    public void alimentation(Model model){
    }



    private final UsersService usersService;


    Long suivant =0L;
    Long precedent =0L;
    
    @GetMapping("/varotrafiaraback/Userspagprecedent")
    public String paginationprecedent(Model model ){
        //debutwithoutforeignkey
            model.addAttribute("liste", usersService.pagination(precedent) );
        //finwithoutforeignkey


        alimentation(model);
        if(precedent >0 ){
            precedent =precedent -5;
        }
        return  "Users";
    }
    @GetMapping("/varotrafiaraback/Userspagsuivant")
    public String paginationsuivant( Model model ){
        //debutwithoutforeignkey
            model.addAttribute("liste", usersService.pagination(suivant) );
        //finwithoutforeignkey


        alimentation(model);
        precedent=suivant-5;
        suivant =suivant +5;
        return  "Users";
    }
    @GetMapping("/varotrafiaraback/Usersdel")
    public String delete(@RequestParam("id") Integer id, Model model ){
        usersService.delete(id);
        return paginationprecedent(model);
    }

}

