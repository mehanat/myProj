package ru.restaurant.Service;

import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;
import ru.restaurant.model.Restaurant;
import ru.restaurant.utils.LunchRating;

import java.util.*;

/**
 * Created by Анатолий on 26.04.2016.
 */
public interface RestaurantService {
    List<Restaurant> getAll();
    Restaurant save(Restaurant restaurant);
    boolean delete(int id);
    Restaurant get(int id);
    void saveLunch(Date date, Set<Dish> lunch, final int id);
    List<LunchRating> getLunchesRating(int id);
    List<LunchRating> getLunchesRating(Date date);
}
