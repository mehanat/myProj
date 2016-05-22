package ru.restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.Service.LunchService;
import ru.restaurant.Service.RestaurantService;
import ru.restaurant.Service.UserService;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;
import ru.restaurant.model.Restaurant;
import ru.restaurant.model.User;
import ru.restaurant.utils.LunchAndDishes;
import ru.restaurant.utils.LunchRating;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by Анатолий on 12.05.2016.
 */
@RestController
@RequestMapping(value = "/admin/ajax")
public class AdminAjaxController {

    @Autowired
    UserService userService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    LunchService lunchService;

    //Users control methods

    @RequestMapping(value = "users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable int id){
        return userService.getById(id);
    }

    @RequestMapping(value = "users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers(){
        return userService.getAll();
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
     public ResponseEntity<String> saveUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            final StringBuilder sb=new StringBuilder();
            result.getFieldErrors().forEach(f -> sb.append(f.getField()).append(" ").append(f.getDefaultMessage()).append("<br>"));
            return new ResponseEntity<String>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            userService.save(user);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

    //Restaurants control methods

    @RequestMapping(value = "restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getRestaurants(){
        return restaurantService.getAll();
    }

    @RequestMapping(value = "restaurants/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant getRestaurants(@PathVariable int id){
        return restaurantService.get(id);
    }

    @RequestMapping(value = "restaurants/{id}", method = RequestMethod.DELETE)
    public void deletRestaurants(@PathVariable int id){
        restaurantService.delete(id);
    }

    @RequestMapping(value = "restaurants", method = RequestMethod.POST)
    public ResponseEntity<String> saveRest(@Valid Restaurant restaurant, BindingResult result){
        if (result.hasErrors()){
            final StringBuilder sb=new StringBuilder();
            result.getFieldErrors().forEach(f -> sb.append(f.getField()).append(" ").append(f.getDefaultMessage()).append("<br>"));
            return new ResponseEntity<String>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            restaurantService.save(restaurant);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "restaurants/lunches/{restId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LunchRating> getLunches(@PathVariable("restId") int restId){
        return restaurantService.getLunchesRating(restId);
    }

    @RequestMapping(value = "restaurants/lunches/{lunchId}/dishes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Dish> getDishes(@PathVariable("lunchId") int lunchId){
        return lunchService.getDishes(lunchId);
    }

    @RequestMapping(value = "restaurants/lunches", method = RequestMethod.POST)
    public  ResponseEntity<String> saveLunch(LunchAndDishes lunchAndDishes){

        for (Dish dish:lunchAndDishes.getDishes()){
            dish.setLunch(lunchAndDishes.getLunch());
        }
        lunchAndDishes.getLunch().setDishes(new HashSet<>(lunchAndDishes.getDishes()));
        lunchService.save(lunchAndDishes.getLunch());

        return new ResponseEntity<String>(HttpStatus.OK);
    }


}
