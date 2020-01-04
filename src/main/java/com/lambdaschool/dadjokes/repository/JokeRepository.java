package com.lambdaschool.dadjokes.repository;

import com.lambdaschool.dadjokes.models.Joke;
import org.springframework.data.repository.CrudRepository;

public interface JokeRepository extends CrudRepository<Joke, Long> {
    Joke findById(long id);
}
