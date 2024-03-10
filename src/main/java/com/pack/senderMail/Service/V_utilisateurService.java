package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.V_utilisateur;
import com.pack.senderMail.Repository.V_utilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_utilisateurService {
    V_utilisateurRepository v_utilisateurRepository;

    @Autowired
    public V_utilisateurService(V_utilisateurRepository v_utilisateurRepository){
        this.v_utilisateurRepository=v_utilisateurRepository;
    }

    public java.util.List<V_utilisateur> findAll(){
        return new V_utilisateur().findAll();
    }

    public java.util.List<V_utilisateur> pagination(Long debut){
        return  new V_utilisateur().pagination(debut);
    }

}
