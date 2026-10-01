package com.example.CinePass.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CinePass.Entity.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovieId(Long movieId);
    List<Show> findByTheatreId(Long theatreId);
}