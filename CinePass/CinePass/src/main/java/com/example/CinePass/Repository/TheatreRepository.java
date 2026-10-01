package com.example.CinePass.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CinePass.Entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    List<Theatre> findByTheatreLocation(String theatreLocation);
}