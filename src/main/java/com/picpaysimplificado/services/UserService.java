package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserService repository;

    public void validationTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuario nao pode realizar transaçao");
        }
        if (sender.getBalance().compareTo(amount)< 0){
            throw new Exception("Usuario sem saldo");
        }
    }

//    public User findUserById (Long id) throws Exception{
//        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário nao encontrado"));
//    }
}
