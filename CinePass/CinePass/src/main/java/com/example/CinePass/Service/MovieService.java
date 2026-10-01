package com.example.CinePass.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CinePass.DTO.MovieDTO;
import com.example.CinePass.Entity.Movie;
import com.example.CinePass.Repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setDescription(movieDTO.getDescription());
        movie.setGenre(movieDTO.getGenre());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setDuration(movieDTO.getDuration());
        movie.setLanguage(movieDTO.getLanguage());

        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByGenre(String genre) {
        List<Movie> movies = movieRepository.findByGenre(genre);
        if (movies.isEmpty()) {
            throw new RuntimeException("No movies found for genre " + genre);
        }
        return movies;
    }

    public List<Movie> getMoviesByLanguage(String language) {
        List<Movie> movies = movieRepository.findByLanguage(language);
        if (movies.isEmpty()) {
            throw new RuntimeException("No movies found for language " + language);
        }
        return movies;
    }

    public Movie getMoviesByTitle(String title) {
        Optional<Movie> movieBox = movieRepository.findByTitle(title);
        if (movieBox.isPresent()) {
            return movieBox.get();
        } else {
            throw new RuntimeException("No movies found for the title " + title);
        }
    }

    public Movie updateMovie(Long id, MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No movie found for the id " + id));

        movie.setTitle(movieDTO.getTitle());
        movie.setDescription(movieDTO.getDescription());
        movie.setGenre(movieDTO.getGenre());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setDuration(movieDTO.getDuration());
        movie.setLanguage(movieDTO.getLanguage());

        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}