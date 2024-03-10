package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.V_trajet;
import com.pack.senderMail.Repository.V_trajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class V_trajetService {
    V_trajetRepository v_trajetRepository;

    @Autowired
    public V_trajetService(V_trajetRepository v_trajetRepository){
        this.v_trajetRepository=v_trajetRepository;
    }

    public java.util.List<V_trajet> findAll(){
        return new V_trajet().findAll();
    }

    public java.util.List<V_trajet> pagination(Long idutilisateur,Long debut){
        return  new V_trajet().pagination(idutilisateur,debut);
    }

}
