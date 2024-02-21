package com.sankethsankuri.movieservice.service;

import com.sankethsankuri.movieservice.model.Movie;
import com.sankethsankuri.movieservice.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public Movie create(Movie movie){
       if(movie == null){
           throw new RuntimeException("Invalid Movie");
       }
        return movieRepository.save(movie);
    }
    public Movie read(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie Not Found"));
    }
    public void update(Long id,Movie movie) {
        if (movie == null || movie.getId() == null) {
            throw new RuntimeException("Invalid movie");
        }
        if (movieRepository.existsById(movie.getId())) {
            movieRepository.save(movie);
        } else {
            throw new RuntimeException("movie Found");
        }

    }
    public void delete(Long id){
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);}
        else{
            throw new RuntimeException("movie not found");
        }
    }
}
