package com.example.CinePass.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CinePass.DTO.ShowDTO;
import com.example.CinePass.Entity.Booking;
import com.example.CinePass.Entity.Movie;
import com.example.CinePass.Entity.Show;
import com.example.CinePass.Entity.Theatre;
import com.example.CinePass.Repository.BookingRepository;
import com.example.CinePass.Repository.MovieRepository;
import com.example.CinePass.Repository.ShowRepository;
import com.example.CinePass.Repository.TheatreRepository;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public Show createShow(ShowDTO showDTO) {
        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(() -> new RuntimeException("No Movie Found for id " + showDTO.getMovieId()));

        Theatre theatre = theatreRepository.findById(showDTO.getTheatreId())
                .orElseThrow(() -> new RuntimeException("No Theatre Found for id " + showDTO.getTheatreId()));

        Show show = new Show();
        show.setShowTime(showDTO.getShowTime());
        show.setPrice(showDTO.getPrice() != null ? showDTO.getPrice().floatValue() : null);
        show.setMovie(movie);
        show.setTheatre(theatre);

        return showRepository.save(show);
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public List<Show> getShowsByMovie(Long movieId) {
        List<Show> shows = showRepository.findByMovieId(movieId);
        if (shows.isEmpty()) {
            throw new RuntimeException("No shows available for the movie");
        }
        return shows;
    }

    public List<Show> getShowsByTheatre(Long theatreId) {
        List<Show> shows = showRepository.findByTheatreId(theatreId);
        if (shows.isEmpty()) {
            throw new RuntimeException("No shows available for the theatre");
        }
        return shows;
    }

    @Transactional
    public Show updateShow(Long id, ShowDTO showDTO) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No show available for the id " + id));

        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(() -> new RuntimeException("No Movie Found for id " + showDTO.getMovieId()));

        Theatre theatre = theatreRepository.findById(showDTO.getTheatreId())
                .orElseThrow(() -> new RuntimeException("No Theatre Found for id " + showDTO.getTheatreId()));

        show.setShowTime(showDTO.getShowTime());
        show.setPrice(showDTO.getPrice() != null ? showDTO.getPrice().floatValue() : null);
        show.setMovie(movie);
        show.setTheatre(theatre);

        return showRepository.save(show);
    }

    @Transactional
    public void deleteShow(Long id) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No show available for the id " + id));

        List<Booking> bookings = bookingRepository.findByShowId(id);
        if (bookings != null && !bookings.isEmpty()) {
            throw new RuntimeException("Can't delete show with existing bookings");
        }

        showRepository.delete(show);
    }
}