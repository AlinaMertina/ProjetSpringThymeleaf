package com.pack.senderMail.Controlleur;
import com.pack.senderMail.Entity.*;
import com.pack.senderMail.Service.*;
import java.text.SimpleDateFormat;
import com.pack.senderMail.Work.*;
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
public class UsersController {

 private final UsersService usersService;
    
    @Autowired
    public UsersController(UsersService usersService){
        this.usersService= usersService;
    }

    @GetMapping("/varotrafiaraback/userss")
    public Returntype findAll(){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,usersService.findAll());
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @GetMapping("/varotrafiaraback/users")
    public Returntype findOne( @RequestParam("id") Integer idUsers ){
        Returntype returntype = new Returntype();
        try {
            returntype = new Returntype(null,usersService.findById(idUsers));
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @DeleteMapping("/varotrafiaraback/users")
    public Returntype  delete(@RequestParam("id") Integer idUsers){
        Returntype returntype = new Returntype();
        try {
            usersService.delete(idUsers);
            returntype = new Returntype(null,"delete");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PutMapping("/varotrafiaraback/users")
    public Returntype  update(@RequestBody Users table){
        Returntype returntype = new Returntype();
        try {
            Users users = usersService.findById(table.getIdusers());
                if(table.getId() !=null){
                    users.setId(table.getId());
                }
                if(table.getUsername() !=null){
                    users.setUsername(table.getUsername());
                }
                if(table.getEmail() !=null){
                    users.setEmail(table.getEmail());
                }
            usersService.update(users);
            returntype = new Returntype(null,"update");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }

    @PostMapping("/varotrafiaraback/Users")
    public Returntype  insertpost(@RequestBody Users table){
        Returntype returntype = new Returntype();
        try {

            usersService.update(table);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
    @PostMapping("/varotrafiaraback/Usersup")
    public Returntype  insertup(@RequestBody Users table){
        Returntype returntype = new Returntype();
        try {
            Users users = usersService.findById(table.getIdusers());
                if(table.getId() !=null){
                    users.setId(table.getId());
                }
                if(table.getUsername() !=null){
                    users.setUsername(table.getUsername());
                }
                if(table.getEmail() !=null){
                    users.setEmail(table.getEmail());
                }
            usersService.update(users);
            returntype = new Returntype(null,"insert");
        } catch (Exception e) {
            returntype = new Returntype(e.getMessage(),null);
            return returntype;
        }
        return returntype;
    }
}
