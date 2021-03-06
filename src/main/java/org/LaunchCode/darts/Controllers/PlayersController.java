package org.LaunchCode.darts.Controllers;

import org.LaunchCode.darts.Data.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("players")
public class PlayersController {

    @GetMapping
    public String index(Model model){
        model.addAttribute("pageTitle", "Players");
        model.addAttribute("tabTitle", "Darts-Players");
        model.addAttribute("players", Users.getAll());
        return "players/index";
    }

    //need to have a edit for current players
    //need to have a create for new players






}
