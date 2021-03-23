package com.mamra.start.movies.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.movies.domain.User;
import com.mamra.start.movies.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class UserApi {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity getUser() throws JsonProcessingException {
        List<User> list = userService.getUsers();
        return ResponseEntity.ok(objectMapper.writeValueAsString(list));
    }

    @CrossOrigin
    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user) throws JsonProcessingException{
        String  response = userService.addUser(user);
        return ResponseEntity.ok(response);

    }
}
