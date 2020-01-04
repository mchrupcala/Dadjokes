package com.lambdaschool.dadjokes.controllers;

import com.lambdaschool.dadjokes.logging.Loggable;
import com.lambdaschool.dadjokes.models.Joke;
import com.lambdaschool.dadjokes.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping(value="/jokes/{id}",
            produces = {"application/json"})
    public ResponseEntity<?> listJokeById(@PathVariable long id) {
        Joke myJoke = jokeService.findJokeById(id);

        return new ResponseEntity<>(myJoke, HttpStatus.OK);
    }

    // POST http://localhost:2020/jokes
    @PostMapping(value="/jokes",
               consumes = {"application/json"})
    public ResponseEntity<?> addNewJoke(@Valid
                                        @RequestBody Joke newJoke)
    {
        jokeService.save(newJoke);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT http://localhost:2020/jokes/3
    @PutMapping(value = "/jokes/{id}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateJoke(@RequestBody Joke joke,
                                        @PathVariable long id) {
        jokeService.update(id, joke);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // DELETE http://localhost:2020/jokes/3
    @DeleteMapping("/jokes/{id}")
    public ResponseEntity<?> deleteJokeById(@PathVariable long id) {
        jokeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
