package kappa.springexam.Bootstrap;

import com.github.javafaker.Faker;
import kappa.springexam.repository.SuperHeroJpaRepository;
import kappa.springexam.repository.TeamJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.transaction.Transactional;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class InitDataLoader implements CommandLineRunner {


    private final SuperHeroJpaRepository superHeroJpaRepository;
    private final TeamJpaRepository teamJpaRepository;

    @Bean
    public Faker faker() {
        return new Faker(Locale.forLanguageTag("hu-HU"));
    }

    @Value("${app.rootPassword}")
    private String rootPassword;


    @Override
    public void run(String... args) throws Exception {

    }
}
