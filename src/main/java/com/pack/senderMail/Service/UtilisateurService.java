package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Utilisateur;
import com.pack.senderMail.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UtilisateurService {
    UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository=utilisateurRepository;
    }

    public java.util.List<Utilisateur> findAll(){
        return utilisateurRepository.findAll();
    }

    public Utilisateur findById(Long idUtilisateur ){
        return utilisateurRepository.findById(idUtilisateur).get();
    }
    public void delete(Long idUtilisateur){
        try{
            utilisateurRepository.delete(idUtilisateur);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void update(Utilisateur table){
        utilisateurRepository.save(table);
    }

    public java.util.List<Utilisateur> pagination(Long debut){
        return utilisateurRepository.pagination(debut);
    }
    public Utilisateur findUser(String email,String motpasse ){
        try {
            return utilisateurRepository.findUser(email,motpasse).get();
        } catch (Exception e) {
            System.out.println("select * from utilisateur where email='"+email+"' and password='"+motpasse+"'");
          System.out.println("Utlisateur service ligne 44 "+e+email+motpasse);
          return null;
        }
        
    }
}
