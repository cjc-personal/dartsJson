package org.LaunchCode.darts.Controllers;

import org.LaunchCode.darts.Data.Users;
import org.LaunchCode.darts.Model.Game;
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


    @PostMapping("numOfPlayers")
    public String choosePlayersOrder (@RequestParam int numberOfPlayers) {
        newGame.setNumberOfPlayers(numberOfPlayers);
        newGame.setRoundCount(0);

        return "redirect:choosePlayers";
    }
    @GetMapping("choosePlayers")
    public String settingUpPlayers(Model model){
        model.addAttribute("pageTitle", "New Game");
        model.addAttribute("tabTitle", "Darts-New Game");
        model.addAttribute("players", Users.getAll());
        model.addAttribute("newGame", newGame);
        return "game/choosePlayers";
    }

    @PostMapping("choosePlayers")
    public String gamePlaying (@RequestParam Integer player1,
                               @RequestParam(required = false) Integer player2,
                               @RequestParam(required = false) Integer player3,
                               @RequestParam(required = false) Integer player4,
                               Model model) {

        if(newGame.getNumberOfPlayers() > newGame.getPlayersPlaying().size()) {
            newGame.getPlayersPlaying().removeAll(newGame.getPlayersPlaying());
            if(newGame.getNumberOfPlayers()>=2) {

                newGame.addPlayer(Users.getById(player1));
                newGame.addPlayer(Users.getById(player2));
            }
            if(newGame.getNumberOfPlayers()>=3) {
                newGame.addPlayer(Users.getById(player3));
            }
            if(newGame.getNumberOfPlayers()==4) {
                newGame.addPlayer(Users.getById(player4));
            }
            if (newGame.getNumberOfPlayers()==newGame.getPlayersPlaying().size()) {
                newGame.setPlayerBeginningScore(301);
                newGame.increaseRoundCount();
            }
        }
        if(newGame.getRoundCount()>=1) {

        } else {
            model.addAttribute("error","There was an error");
            return "game/choosePlayers";
        }


        return "redirect:../game/gameOn";
    }

    @GetMapping("gameOn")
    public String gameTime(Model model){
        model.addAttribute("pageTitle", "Game");
        model.addAttribute("tabTitle", "Darts-Game");
        model.addAttribute("players", newGame.getPlayersPlaying());

        return "game/gameOn";
    }



    //need to have a choose number of players
    //need to have choose player(in order of play order)








}
