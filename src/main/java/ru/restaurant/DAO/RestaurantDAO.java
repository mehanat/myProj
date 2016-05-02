package ru.restaurant.DAO;

import ru.restaurant.model.Dish;
import ru.restaurant.model.Restaurant;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Created by �������� on 23.04.2016.
 */
public interface RestaurantDAO {
    List<Restaurant> getAll();
    Set<Dish> getAllDishes(int restId);
    Restaurant save(Restaurant restaurant);
    boolean delete(int id);
}
