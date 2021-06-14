package kappa.springexam.service;

import kappa.springexam.Exception.ValidationException;
import kappa.springexam.model.Kind;
import kappa.springexam.model.SuperHero;
import kappa.springexam.model.Team;
import kappa.springexam.repository.SuperHeroJpaRepository;
import kappa.springexam.repository.TeamJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SuperHeroService {

    private final SuperHeroJpaRepository superHeroJpaRepository;
    private final TeamJpaRepository teamJpaRepository;

    public void create(SuperHero superHero, Team team) {
        validate(superHero, team);
        superHeroJpaRepository.save(superHero);
    }


    public void update(String id, SuperHero superHero, Team team) {
        SuperHero oldSuperHero = superHeroJpaRepository.findById(id).orElse(null);
        validate(superHero, team);
        superHeroJpaRepository.save(superHero.toBuilder()
                .id(oldSuperHero.getId()).name(oldSuperHero
                        .getName()).hero(oldSuperHero.getHero())
                .universe(oldSuperHero
                        .getUniverse())
                .build());
    }

    public List<SuperHero> getAllSuperHeroes() {
        return superHeroJpaRepository.findAll();
    }

    public Optional<SuperHero> getSuperHeroById(String id) {
        return superHeroJpaRepository.findById(id);
    }

    public void validate(SuperHero superHero, Team team) {
        if (!StringUtils.hasText(superHero.getName()) || superHero.getName() == null) {
            throw new ValidationException("Adj már meg nevet pls!");
        }
        if (superHero.getUniverse() == null) {
            throw new ValidationException("Azért valamelyik univerzumban csak kéne léteznie, nem ?");
        }
        if (!superHero.getTeam().getId().isEmpty()) {
            if (superHero.getUniverse() == superHero.getTeam().getUniverse()) {
                if (superHero.getHero() == true && superHero.getTeam().getKind() != Kind.HERO) {
                    throw new ValidationException("Ő nem Hős!!");
                } else if (superHero.getHero() == false && superHero.getTeam().getKind() != Kind.VILLAIN) {
                    throw new ValidationException("Ő nem gonosz!");
                }
            }

        }
    }
}
