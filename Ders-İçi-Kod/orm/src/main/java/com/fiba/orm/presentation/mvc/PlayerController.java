package com.fiba.orm.presentation.mvc;

import com.fiba.orm.configuration.MyBean;
import com.fiba.orm.data.entity.Player;
import com.fiba.orm.data.repository.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sports")
public class PlayerController {

    PlayerRepository playerRepository;
    private MyBean myBean;

    public PlayerController(PlayerRepository playerRepository, MyBean myBean){
        this.playerRepository = playerRepository;
        this.myBean = myBean;
    }

    @GetMapping("/players/{id}")
    @ResponseBody
    public String getPlayers(@PathVariable("id") long id){
        System.out.println("Çekirdek: " + myBean.getMyLong() +" " + myBean.getMyString());
        List<Player> players = playerRepository.findAllByTeamId(id);
        for (Player player: players
             ) {
            System.out.println(player.getPlayerName());
        }
        return "Başarılı";
    }
}
