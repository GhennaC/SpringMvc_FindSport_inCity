package org.challenge.controllers;

import org.challenge.entities.Sport;
import org.challenge.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(("/sport"))
public class SportController {

    @Autowired
    private SportService sportService;

    @GetMapping("/list")
    public String getSports(Model model) {

        List<Sport> sportList = sportService.getSports();

        model.addAttribute("sports",sportList);

        return "list-sports";
    }

    @GetMapping("/addForm")
    public String addForm(Model model) {
        Sport sport = new Sport();

        model.addAttribute("sport",sport);

        return "sport-form";
    }

    @PostMapping("/saveSport")
    public String saveSport(@Valid @ModelAttribute("sport") Sport sport,
                            BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return "sport-form";

        sportService.saveSport(sport);
        return "redirect:/sport/list";
    }

    @GetMapping("/delete")
    public String deleteSport(@RequestParam("sportId") int id) {

        sportService.deleteSport(id);
        return"redirect:/sport/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("sportId") int id,
                                    Model model) {

        Sport sport = sportService.getSport(id);

        model.addAttribute("sport",sport);

        return "sport-form";
    }
}
