package org.LaunchCode.darts.Controllers;

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
        return "game/index";
    }







}
