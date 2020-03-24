package org.LaunchCode.darts.Controllers;

import org.LaunchCode.darts.Data.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("game")
public class Game {

    @GetMapping
    public String displayGame (Model model) {
        model.addAttribute("pageTitle", "Darts");
        model.addAttribute("tabTitle", "Darts-Game");
        model.addAttribute("players", Users.getAll());
        return "game/index";
    }

    //need to have a choose number of players
    //need to have choose player(in order of play order)








}
