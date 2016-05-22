package ru.restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.restaurant.Service.RestaurantService;
import ru.restaurant.model.Restaurant;

import java.util.List;

/**
 * Created by Анатолий on 01.05.2016.
 */
@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantsController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "ajax", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getRestaurants(){
        return restaurantService.getAll();
    }
}
