package ru.restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.restaurant.LoggedUser;
import ru.restaurant.Service.LunchService;
import ru.restaurant.Service.RestaurantService;
import ru.restaurant.Service.UserService;
import ru.restaurant.model.Lunch;
import ru.restaurant.utils.LunchRating;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Анатолий on 09.05.2016.
 */
@Controller
public class RootController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    LunchService lunchService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String root(){
         return "redirect:restaurants";
    }

    @RequestMapping(value = "/restaurants")
    public String restaurants(Model model){
        model.addAttribute("lunches", restaurantService.getLunchesRating(new Date()));
        return "restaurantsList";
    }

    @RequestMapping(value = "/restaurant/{id}")
    public String restaursntRating(@PathVariable int id, Model model){
        List<LunchRating> rating=restaurantService.getLunchesRating(id);
        model.addAttribute("lunches", rating);
        return "restaurantLunches";
    }

    @RequestMapping(value = "/admin/users")
    public String users(Model model){
        model.addAttribute("users", userService.getAll());
        return "usersList";
    }

    @RequestMapping(value = "/login")
    public String login(Model model,
                        @RequestParam(value = "error", required = false) boolean error,
                        @RequestParam(value = "message", required = false) String message){
        LoggedUser.safeGet();
        model.addAttribute("error", error);
        model.addAttribute("message", message);
        return "login";
    }
}
