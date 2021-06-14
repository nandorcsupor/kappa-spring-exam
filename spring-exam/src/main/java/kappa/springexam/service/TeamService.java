package kappa.springexam.service;

import kappa.springexam.Exception.ValidationException;
import kappa.springexam.model.Team;
import kappa.springexam.repository.TeamJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamService {

    private final TeamJpaRepository teamJpaRepository;

    public void create(Team team) {
        validate(team);
        teamJpaRepository.save(team);
    }

    public void update(String id, Team team) {
        validate(team);
        Team oldTeam = teamJpaRepository.findById(id).orElse(null);

        teamJpaRepository.save(team.toBuilder()
                .id(oldTeam.getId())
                .kind(oldTeam.getKind())
                .name(oldTeam.getName())
                .universe(oldTeam.getUniverse())
                .build());
    }

    public List<Team> getAllteams() {
        return teamJpaRepository.findAll();
    }

    public Optional<Team> getTeamById(String id) {
        return teamJpaRepository.findById(id);
    }

    public void validate(Team team) {
        if(!StringUtils.hasText(team.getName()) || team.getName() == null) {
            throw new ValidationException("Adj meg nevet!");
        }
        if(team.getUniverse() == null) {
            throw new ValidationException("Adj meg Univerzumot!");
        }
        if (team.getKind() == null) {
            throw  new ValidationException("Adj meg Kind-ot!");
        }
    }
}
