package com.fiba.orm.presentation.mvc;

import com.fiba.orm.data.entity.Player;
import com.fiba.orm.data.entity.Team;
import com.fiba.orm.data.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/sports")
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    @GetMapping("/team/insert")
    @ResponseBody
    public String insertTeam(){
        Team teamA = new Team(0, "Godoro Spor");
        teamA.setPlayerList(new ArrayList<>());

        Player player1 = new Player(0,"Cem Karaca", 54.21);
        player1.setTeam(teamA);
        teamA.getPlayerList().add(player1);

        Player player2 = new Player(0,"Barış Manço", 76.12);
        player2.setTeam(teamA);
        teamA.getPlayerList().add(player2);

        Player player3 = new Player(0,"Fikret Kızılok", 34.55);
        player3.setTeam(teamA);
        teamA.getPlayerList().add(player3);

        teamRepository.save(teamA);

        return  "Sokuldu :";
    }
}
