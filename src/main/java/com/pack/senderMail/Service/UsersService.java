package com.pack.senderMail.Service;

import com.pack.senderMail.Entity.Users;
import com.pack.senderMail.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UsersService {
    UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }

    public java.util.List<Users> findAll(){
        return usersRepository.findAll();
    }

    public Users findById(Integer idUsers ){
        return usersRepository.findOne(idUsers).get();
    }
    public void delete(Integer idUsers){
        try{
            usersRepository.delete(idUsers);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void update(Users table){
        usersRepository.save(table);
    }

    public java.util.List<Users> pagination(Long debut){
        return usersRepository.pagination(debut);
    }

}
