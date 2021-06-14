package kappa.springexam.repository;

import kappa.springexam.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperHeroJpaRepository extends JpaRepository<SuperHero, String> {
}
