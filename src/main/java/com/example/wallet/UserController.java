package com.example.wallet;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.persistence.RollbackException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    
    @Autowired 
    private UserRepository userRepository;

    UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user, BindingResult bindingResult){
        try{
            userRepository.save(user);
        }catch(TransactionSystemException e){
            return ResponseEntity.ok(e.toString());
        }
        
        return ResponseEntity.ok("Registration done");
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable int id){
       return userRepository.findById(id);
    }

}

