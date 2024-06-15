package org.example.demoexams3.service;

import org.example.demoexams3.model.Hamster;
import org.example.demoexams3.model.HamsterDTO;
import org.example.demoexams3.repositories.HamsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HamsterService {

    private final HamsterRepository hamsterRepository;

    @Autowired
    public HamsterService(HamsterRepository hamsterRepository) {
        this.hamsterRepository = hamsterRepository;
    }

    public HamsterDTO create(HamsterDTO body) {
        try {
            Hamster hamster = new Hamster();
            hamster.setName(body.getName());
            hamster.setData(body.getData());
            hamster.setColor(body.getColor());
            hamster.setCharacteristics(body.getCharacteristics());

            Hamster savedHamster = hamsterRepository.save(hamster);
            return new HamsterDTO(savedHamster.getName(), savedHamster.getColor(), savedHamster.getData(), savedHamster.getCharacteristics());
        } catch (Exception e) {
            throw new RuntimeException("Failed to create hamster", e);
        }
    }



    public HamsterDTO findById(Long id) {
        try {
            Optional<Hamster> optionalHamster = hamsterRepository.findById(id);
            if (optionalHamster.isPresent()) {
                Hamster hamster = optionalHamster.get();
                return new HamsterDTO(hamster.getName(), hamster.getColor(), hamster.getData(), hamster.getCharacteristics());
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hamster not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to find hamster by id: " + id, e);
        }
    }

    public boolean deleteById(Long id) {
        try {
            if (hamsterRepository.existsById(id)) {
                hamsterRepository.deleteById(id);
                return true;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hamster not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete hamster with id: " + id, e);
        }
    }

    public HamsterDTO updateById(Long id, HamsterDTO body) {
        try {
            Optional<Hamster> optionalHamster = hamsterRepository.findById(id);
            if (optionalHamster.isPresent()) {
                Hamster hamster = optionalHamster.get();
                hamster.setName(body.getName());
                hamster.setData(body.getData());
                hamster.setColor(body.getColor());
                hamster.setCharacteristics(body.getCharacteristics());

                Hamster updatedHamster = hamsterRepository.save(hamster);
                return new HamsterDTO(updatedHamster.getName(), updatedHamster.getColor(), updatedHamster.getData(), updatedHamster.getCharacteristics());
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hamster not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to update hamster with id: " + id, e);
        }
    }
}
