package org.LaunchCode.darts.Controllers;

import org.LaunchCode.darts.Data.Users;
import org.LaunchCode.darts.Model.Game;
import org.LaunchCode.darts.Model.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("game")
public class GameController {
    public Game newGame = new Game();

    @GetMapping
    public String displayGame (Model model) {
        model.addAttribute("pageTitle", "Darts");
        model.addAttribute("tabTitle", "Darts-Game");
        model.addAttribute("players", Users.getAll());
        return "game/index";
    }

    //@PostMapping
    /*public String setsNumOfPlayers(@RequestParam int numberOfPlayers, Model model) {
        newGame.setNumberOfPlayers(numberOfPlayers);
        model.addAttribute("pageTitle", "New Game");
        model.addAttribute("tabTitle", "Darts-New Game");
        model.addAttribute("players", Users.getAll());
        model.addAttribute("numberOfPlayers", newGame);
        return "redirect: game/choosePlayers";
    }*/

    @PostMapping("choosePlayers")
    public String choosePlayersOrder (@RequestParam int numberOfPlayers, Model model) {
        newGame.setNumberOfPlayers(numberOfPlayers);
        model.addAttribute("pageTitle", "New Game");
        model.addAttribute("tabTitle", "Darts-New Game");
        model.addAttribute("players", Users.getAll());
        model.addAttribute("newGame", newGame);
       return "game/choosePlayers";
    }

    @PostMapping("gameOn")
    public String gamePlaying (@RequestParam Player player1,
                               @RequestParam Player player2,
                               @RequestParam(required = false) Player player3,
                               @RequestParam(required = false) Player player4,
                               Model model) {




        return "game/gameOn";
    }


    //need to have a choose number of players
    //need to have choose player(in order of play order)








}
