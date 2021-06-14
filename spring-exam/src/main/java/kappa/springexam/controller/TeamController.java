package kappa.springexam.controller;

import kappa.springexam.model.Team;
import kappa.springexam.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamservice;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Team team) {
        teamservice.create(team);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateTeam(@PathVariable String id, @RequestBody Team team) {
        teamservice.update(id, team);
    }

    @GetMapping("")
    public List<Team> getAll() {
        return teamservice.getAllteams();
    }

    @GetMapping("/{id}")
    public Optional<Team> getTeamById(@PathVariable String id) {
        return teamservice.getTeamById(id);
    }
}
