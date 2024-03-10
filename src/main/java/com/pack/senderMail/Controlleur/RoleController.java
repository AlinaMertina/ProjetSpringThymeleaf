package com.pack.senderMail.Controlleur;
import com.pack.senderMail.Entity.Role;
import com.pack.senderMail.Service.RoleService;
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

@RestController
@RequestMapping
public class RoleController {

 private final RoleService roleService;
    
    @Autowired
    public RoleController(RoleService roleService){
        this.roleService= roleService;
    }

    @GetMapping("/sender/roles")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,roleService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @GetMapping("/sender/role")
    public Returntype findOne( @RequestParam("id") Long idRole ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,roleService.findOne(idRole));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/sender/role")
    public Returntype  delete(@RequestParam("id") Long idRole){
        Returntype returntype = new Returntype();
        try {
            roleService.delete(idRole);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/sender/role")
    public Returntype  update(@RequestBody Role table){
        Returntype returntype = new Returntype();
        try {
            roleService.update(table);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/sender/role")
    public Returntype  insert(@RequestBody Role table){
        Returntype returntype = new Returntype();
        try {
            roleService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

}
