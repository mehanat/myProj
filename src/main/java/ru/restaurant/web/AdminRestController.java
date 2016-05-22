package ru.restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.Service.DishService;
import ru.restaurant.Service.LunchService;
import ru.restaurant.Service.RestaurantService;
import ru.restaurant.Service.UserService;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;
import ru.restaurant.model.Restaurant;
import ru.restaurant.model.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Анатолий on 02.05.2016.
 */
@RestController
@RequestMapping(value = "/admin/rest")
public class AdminRestController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    LunchService lunchService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> inputRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.save(restaurant);
        return restaurantService.getAll();
    }

    @RequestMapping(value = "newLunch/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void inputLunch(@PathVariable(value = "id") int restId, @RequestBody Set<Dish> dishes){
        Lunch lunch=new Lunch();
        lunch.setDishes(dishes);
        lunch.setDate(new Date());
        lunch.setRestaurant(restaurantService.get(restId));
        lunchService.save(lunch);
    }

}
