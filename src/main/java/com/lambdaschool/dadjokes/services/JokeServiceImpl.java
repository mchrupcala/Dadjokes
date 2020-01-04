package com.lambdaschool.dadjokes.services;

import com.lambdaschool.dadjokes.exceptions.ResourceFoundException;
import com.lambdaschool.dadjokes.exceptions.ResourceNotFoundException;
import com.lambdaschool.dadjokes.logging.Loggable;
import com.lambdaschool.dadjokes.models.Joke;
import com.lambdaschool.dadjokes.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "jokeService")
public class JokeServiceImpl implements JokeService {

    @Autowired
    private JokeRepository jokerepos;

    @Override
    public List<Joke> findAll() {
        List<Joke> joke = new ArrayList<>();
        jokerepos.findAll()
                .iterator()
                .forEachRemaining(joke::add);
        return joke;
    }

    @Override
    public Joke findJokeById(long id) {
        return jokerepos.findById(id);
//                .orElseThrow(() -> new ResourceNotFoundException("Joke id " + id + " not found!"));
    }

    @Override
    public void delete(long id) {
        jokerepos.findById(id);
//                .orElseThrow(() -> new ResourceNotFoundException("Role id " + id + " not found!"));
        jokerepos.deleteById(id);
    }

    @Override
    public Joke save(Joke joke) {
        Joke newJoke = new Joke();
        newJoke.setJokequestion(joke.getJokequestion());
        newJoke.setJokeanswer(joke.getJokeanswer());
        newJoke.setIsprivate(joke.isIsprivate());

        // I need to set the currently-logged in user as the joke's user...how?

        return jokerepos.save(joke);
    }


    @Override
    public Joke update(long id, Joke joke) {
        Joke currentJoke = jokerepos.findById(id);
//                .orElseThrow(() -> new EntityNotFoundException(Long.toString(bookid)));

        if (currentJoke != null) {
            if (joke.getJokeanswer() != null) {
                currentJoke.setJokeanswer(joke.getJokeanswer());
            }


            return jokerepos.save(currentJoke);
        } else {
            {
                throw new EntityNotFoundException("Book was not found.");
            }
        }
    }
}
