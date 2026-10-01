package com.example.CinePass.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CinePass.DTO.TheatreDTO;
import com.example.CinePass.Entity.Theatre;
import com.example.CinePass.Repository.TheatreRepository;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre addTheatre(TheatreDTO theatreDTO) {
        Theatre theatre = new Theatre();
        theatre.setTheatreName(theatreDTO.getTheatreName());
        theatre.setTheatreLocation(theatreDTO.getTheatreLocation());
        theatre.setTheatreCapacity(theatreDTO.getTheatreCapacity());
        theatre.setTheatreScreenType(theatreDTO.getTheatreScreenType());

        return theatreRepository.save(theatre);
    }

    public List<Theatre> getTheatreByLocation(String location) {
        List<Theatre> theatres = theatreRepository.findByTheatreLocation(location);
        if (theatres.isEmpty()) {
            throw new RuntimeException("No theatres found for the location entered");
        }
        return theatres;
    }

    public Theatre updateTheatre(Long id, TheatreDTO theatreDTO) {
        Theatre theatre = theatreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No theatre found for the id " + id));

        theatre.setTheatreName(theatreDTO.getTheatreName());
        theatre.setTheatreLocation(theatreDTO.getTheatreLocation());
        theatre.setTheatreCapacity(theatreDTO.getTheatreCapacity());
        theatre.setTheatreScreenType(theatreDTO.getTheatreScreenType());

        return theatreRepository.save(theatre);
    }

    public void deleteTheatre(long id) {
        theatreRepository.deleteById(id);
    }
}