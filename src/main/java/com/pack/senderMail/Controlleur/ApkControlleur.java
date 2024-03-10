package com.pack.senderMail.Controlleur;

import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.senderMail.Entity.Garage;
import com.pack.senderMail.Entity.Trajet;
import com.pack.senderMail.Entity.Utilisateur;
import com.pack.senderMail.Service.GarageService;
import com.pack.senderMail.Service.TrajetService;
import com.pack.senderMail.Service.UtilisateurService;
import com.pack.senderMail.Work.Returntype;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.Calendar;
import java.util.Date;
@Controller
@RequestMapping
@RequiredArgsConstructor
public class ApkControlleur {

    private final UtilisateurService utilisateurService;
    private final TrajetService trajetService;
    private final GarageService garageService;

    @PostMapping("/sender/Garageup")
    public String  insertup(  @RequestParam(name = "idgarage") Long idgarage,
    @RequestParam(name = "date") String date,
    @RequestParam(name = "entersortie") Integer entreSortie,HttpSession session
    ){
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
        try {
            Garage table = new Garage(idgarage, null, convertStringToDate(date), utilisateur.getIdutilisateur(), entreSortie);
            Garage garage = garageService.findById(table.getIdgarage());
                try {
                    if(garage!=null){  
                        if(garage.getEntersortie()==entreSortie){
                            System.out.println("entrer"+garage.getEntersortie());
                            return "redirect:http://localhost:8080/sender/Garagepagprecedent";
                        }else{
                            if(table.getEntersortie()==1 && table.getIdutilisateur()==garage.getIdutilisateur()){
                                garageService.update(garage);
                            }else if(table.getEntersortie()==0){
                                System.out.println("mamoka"+garage.getIdgarage());
                                garage.setIdutilisateur(utilisateur.getIdutilisateur());
                                garage.setDate(table.getDate());
                                garage.setEntersortie(table.getEntersortie());
                                garageService.update(garage);
                            }
                            return "redirect:http://localhost:8080/sender/Garagepagprecedent";
                        }
                    }else{
                        garageService.update(garage);
                    }
                   
                   
                    return "redirect:http://localhost:8080/sender/Garagepagprecedent";
                } catch (Exception e) {
                    System.out.println(e);
                    return "redirect:http://localhost:8080/sender/Garagepagprecedent";
                }
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:http://localhost:8080/sender/Garagepagprecedent";
        }
       
    }

    @PostMapping("/sender/Garage")
    public String  insertpost(
    @RequestParam(name = "idvehicule") Long idVehicule,
    @RequestParam(name = "date") String date,
    @RequestParam(name = "entersortie") Integer entreSortie
    ,Model model,HttpSession session){
       
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
        try {
            Garage garage = garageService.findByidvehicule(idVehicule);
            Garage table = new Garage(null, idVehicule,convertStringToDate(date) , utilisateur.getIdutilisateur(), entreSortie);
            if(garage!=null){
                System.out.println("ereka 11111");
                if(garage.getEntersortie()==entreSortie){
                    return "redirect:http://localhost:8080/sender/Garagepagprecedent";
                }else{
                    if(table.getEntersortie()==1 && garage.getIdutilisateur()==table.getIdutilisateur()){
                        garageService.update(table);
                    }else if(table.getEntersortie()==0){
                        garageService.update(table);
                    }
                    return "redirect:http://localhost:8080/sender/Garagepagprecedent";
                }
                
            }else{
                System.out.println("ereka");
                garageService.update(table);
            }
            return "redirect:http://localhost:8080/sender/Garagepagprecedent";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:http://localhost:8080/sender/Garagepagprecedent";
        }
        
    }


    @PostMapping("/gestionvehiculeevaluation/Trajet")
    public String   insertpost(
    @RequestParam("dateheurdepart") String dateHeureDepart,
    @RequestParam("idlieudepart") Long idlieudepart,
    @RequestParam("kilometragedepart") Double kilometragedepart,
    @RequestParam("dateheurarrive") String dateHeureArrive,
    @RequestParam("idlieuarrive") Long idlieuarrive,
    @RequestParam("kilometragearrive") Double kilometragearrive,
    @RequestParam("quantitecarburant") Double quantitecarburant,
    @RequestParam("prixcarburant") Double prixcarburant,
    @RequestParam("motif") String motif,
    @RequestParam("idvehicule") Long idvehicule,Model model,HttpSession session){
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
        try {
            
            Trajet table = new Trajet();
            table.setDateheurdepart(convertStringToDate(dateHeureDepart));
            table.setIdlieurdepart(idlieudepart);
            table.setKilometragedepart(kilometragedepart);
            table.setDateheurarrive(convertStringToDate(dateHeureArrive));
            table.setIdlieurarrive(idlieuarrive);
            table.setKilometragearrive(kilometragearrive);
            table.setQuantitecarburant(quantitecarburant);
            table.setPrixcarburant(prixcarburant);
            table.setMotif(motif);
            table.setIdvehicule(idvehicule);
            table.setIdutilisateur(utilisateur.getIdutilisateur());
            trajetService.update(table);

            return "redirect:http://localhost:8080/gestionvehiculeevaluation/Trajetpagprecedent";
        } catch (Exception e) {
            System.out.println("ApkControlleur ligne 41 :"+e);
            return "redirect:http://localhost:8080/gestionvehiculeevaluation/Trajetpagprecedent";
        }
      
    }

    @GetMapping("/page")
    public String getPage(Model model) {
      
        model.addAttribute("pageTitle", "Ma page");
        return "Page"; 
    }

    @PostMapping("/sender/connexion")
    public String connexion(@RequestParam("email") String email,@RequestParam("password") String password,Model model,HttpSession httpSession){
        Utilisateur utilisateurvalue  = utilisateurService.findUser(email,password );
        if(utilisateurvalue  !=null){
                httpSession.setAttribute("user", utilisateurvalue);
                httpSession.setAttribute("isconnected", true);
                if(utilisateurvalue.getIdrole()==1){
                    return   "Accuille/Admin";
                }else if(utilisateurvalue.getIdrole()==2){
                    return   "Accuille/Utilisateur";
                }else{
                    return   "Accuille/Station1";
                }
        }else{
            return   "User/Login";
        }
       
    }

    @GetMapping("/sender/login")
    public String login(Model model ){
        return   "User/Login";
    }

    @GetMapping("/sender/register")
    public String register(Model model ){
        return   "User/Register";
    }

    @GetMapping("/importcsv")
    public String importcsv(Model model ){
        return   "Importcsv";
    }

    //fonction de controller 
    public static Date convertStringToDate(String dateString) {
        System.out.println(dateString);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // Gérer l'exception en cas d'échec de la conversion
            e.printStackTrace();
        }
        return parsedDate;
    }
    public static Date ajouterJours(Date date, int jours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, jours);
        return calendar.getTime();
    }

}
