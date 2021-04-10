package org.challenge.controllers;

import org.challenge.entities.City;
import org.challenge.entities.Sport;
import org.challenge.service.CityService;
import org.challenge.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/city",name = "CityController")
public class CityController {

    @Autowired
    private CityService myService;

    @GetMapping
    public String allCities(Model model) {

        List<City> cityList = myService.getCities();
        model.addAttribute("cities",cityList);

        return "list-cities";
    }

    @GetMapping(value = "/showSports",name = "showSports")
    public String showSports(@RequestParam("cityId") int id,Model model) {

        model.addAttribute("sports",myService.getSportsbyId(id));
        model.addAttribute("cityId",id);

        return "city-list-sports";
    }

   @GetMapping(value = "/add")
   public String addForm(@RequestParam("cityId")int id,Model model) {

       Sport sport = new Sport();
       model.addAttribute("cityId",id);
       model.addAttribute("sport",sport);

       return "add-sport-tocity-form";
   }

    @PostMapping("/saveSport")
    public String saveSport(@RequestParam("cityId")int id,
                            @Valid @ModelAttribute("sport") Sport sport,
                            BindingResult bindingResult,
                            Model model) {

        model.addAttribute("cityId",id);
        if(bindingResult.hasErrors()){
            return "add-sport-tocity-form";
        }

        sport.setCity(new City(id));
        myService.addCitySport(id,sport);

        return "redirect:/city/showSports";
    }

    @GetMapping("/deleteSport")
    public  String deleteSport(@RequestParam("sportId") int id,
                                @RequestParam("cityId") int cityId,
                               Model model){

        model.addAttribute("cityId",cityId);
        myService.deleteCitySport(id);

        return "redirect:/city/showSports";
    }

    @GetMapping("/UpdateSport")
    public String UpdateSport(@RequestParam("sportId") int id,
                                    Model model) {

        Sport sport = myService.getCitySport(id);
        model.addAttribute("cityId",sport.getCity().getId());
        model.addAttribute("sport",sport);

        return "add-sport-tocity-form";
    }


}
