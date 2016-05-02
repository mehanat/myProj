package ru.restaurant.Service;

import ru.restaurant.model.Dish;
import ru.restaurant.model.Restaurant;

import java.util.List;
import java.util.Set;

/**
 * Created by Анатолий on 26.04.2016.
 */
public interface RestaurantService {
    List<Restaurant> getAll();
    Set<Dish> getAllDishes(int restId);
    Restaurant save(Restaurant restaurant);
    boolean delete(int id);
}
