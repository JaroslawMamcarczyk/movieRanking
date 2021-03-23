package com.mamra.start.movies.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.movies.domain.User;
import com.mamra.start.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }


    public String addUser(User user){
    Optional<User> usersFromDb = userRepository.findByName(user.getName());
    if(usersFromDb.isPresent()){
        return "Nie można dodać - użytkownik już istnieje";
    }else {
        User saveUser = userRepository.save(user);
        return user.toString()+"Został dodany";
    }
}

public User findById(Long id){
        Optional<User> userFinding = userRepository.findById(id);
    return userFinding.orElse(null);
}
}
