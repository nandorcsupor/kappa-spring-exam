package kappa.springexam.controller;


import kappa.springexam.model.SuperHero;
import kappa.springexam.model.Team;
import kappa.springexam.service.SuperHeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/super-hero")
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SuperHero superHero, Team team) {
        superHeroService.create(superHero, team);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateTeam(@PathVariable String id, @RequestBody SuperHero superHero, Team team) {
        superHeroService.update(id, superHero, team);
    }

    @GetMapping("")
    public List<SuperHero> getAll() {
        return superHeroService.getAllSuperHeroes();
    }

    @GetMapping("/{id}")
    public Optional<SuperHero> getSuperHeroById(@PathVariable String id) {
        return superHeroService.getSuperHeroById(id);
    }
}
