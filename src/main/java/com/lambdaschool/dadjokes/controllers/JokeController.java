package com.lambdaschool.dadjokes.controllers;

import com.lambdaschool.dadjokes.logging.Loggable;
import com.lambdaschool.dadjokes.models.Joke;
import com.lambdaschool.dadjokes.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Loggable
@RestController
public class JokeController {

    @Autowired
    private JokeService jokeService;

    // GET http://localhost:2020/jokes/
    @GetMapping(value="/jokes",
              produces = {"application/json"})
    public ResponseEntity<?> listAllJokes() {
        List<Joke> myList = jokeService.findAll();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // GET http://localhost:2020/jokes/3

    // POST http://localhost:2020/jokes

    // PUT http://localhost:2020/jokes/3

    // DELETE http://localhost:2020/jokes/3
}
