package org.example.demoexams3.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.demoexams3.model.HamsterDTO;
import org.example.demoexams3.service.HamsterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Хомяки")
@RestController
@RequestMapping("/hamsters")
public class HamsterController {

    private final HamsterService hamsterService;

    public HamsterController(HamsterService hamsterService) {
        this.hamsterService = hamsterService;
    }

    @PostMapping("/create")
    public HamsterDTO createHamster(@RequestBody HamsterDTO body) {
        return hamsterService.create(body);
    }

    @GetMapping("/{id}")
    public HamsterDTO findHamsterById(@PathVariable Long id) {
        return hamsterService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteHamsterById(@PathVariable Long id) {
        return hamsterService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public HamsterDTO updateHamsterById(@PathVariable Long id, @RequestBody HamsterDTO body) {
        return hamsterService.updateById(id, body);
    }
}
