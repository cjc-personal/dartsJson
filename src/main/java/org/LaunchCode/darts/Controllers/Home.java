package org.LaunchCode.darts.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Home {

    @RequestMapping
    public String displayHomePage (Model model) {
        model.addAttribute("pageTitle", "Darts");
        model.addAttribute("tabTitle", "Darts-Home");
        return "index";
    }

}
