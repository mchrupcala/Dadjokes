package com.lambdaschool.dadjokes.services;

import com.lambdaschool.dadjokes.models.Joke;

import java.util.List;

public interface JokeService {
    List<Joke> findAll();

    Joke findJokeById(long id);

    void delete(long id);

    Joke save(Joke joke);

    Joke update(long id, Joke joke);
}
