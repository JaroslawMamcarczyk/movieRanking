package com.mamra.start.movies.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.movies.domain.Users;
import com.mamra.start.movies.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersService {

    private final UsersRepository usersRepository;
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    @Autowired
    ObjectMapper objectMapper;

    @CrossOrigin
    @GetMapping("/users")
    public ResponseEntity getUsers() throws JsonProcessingException {
        List<Users> users = usersRepository.findAll();
        return ResponseEntity.ok(objectMapper.writeValueAsString(users));
    }

    @CrossOrigin
    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody Users users){
    Optional<Users> usersFromDb = usersRepository.findByName(users.getName());
    if(usersFromDb.isPresent()){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }else {
        Users saveUser = usersRepository.save(users);
        return ResponseEntity.ok(saveUser);
    }
}
}
