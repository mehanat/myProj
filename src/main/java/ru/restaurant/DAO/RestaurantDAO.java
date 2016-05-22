package ru.restaurant.DAO;

import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;
import ru.restaurant.model.Restaurant;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by �������� on 23.04.2016.
 */
public interface RestaurantDAO {
    List<Restaurant> getAll();
    Restaurant save(Restaurant restaurant);
    boolean delete(int id);
    Restaurant get(int id);
    void saveLunch(Date date, Set<Dish> lunch, final int id);
    Map<Lunch, Integer> getLunchesRating(int id);
    Map<Lunch, Integer> getLunchesRating(Date date);
}
