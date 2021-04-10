package org.challenge.controllers;

import org.challenge.entities.Sport;
import org.challenge.service.MyService;
import org.challenge.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.util.*;

@Controller
@RequestMapping("/search")
public class UserController {

    @Autowired
    private SportService sportService;

    @GetMapping
    public String getNeededSports(Model model) {

        ObjClass objClass = new ObjClass();
        objClass.setSportList(new ArrayList<>());
        Set<String> no = new HashSet<>();

        for (Sport sp : sportService.getSports()){
            no.add(sp.getName());
        }

        model.addAttribute("objClass",objClass);
        model.addAttribute("sports",no);
        return "search-sports";
    }

    @PostMapping("/done")
    public String done (@Valid @ModelAttribute("objClass") ObjClass objClass,
                        BindingResult bindingResult,
                        Model model) {

        if(bindingResult.hasErrors()){

            Set<String> no = new HashSet<>();
            for (Sport sp : sportService.getSports()){
                no.add(sp.getName());
            }

            model.addAttribute("sports",no);
            return "search-sports";
        }

        List<Sport> listSport = sportService.getNeededSports(
                                objClass.getSportList(),
                                objClass.getStart_date(),objClass.getStop_date());
        model.addAttribute("sports",listSport);

        return "output-search";
    }

}
