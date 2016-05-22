package ru.restaurant.Service;

import ru.restaurant.model.Dish;
import ru.restaurant.model.Restaurant;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Анатолий on 23.04.2016.
 */
public interface DishService {
    Dish get(int id);
    boolean delete(int id);
    Dish save(Dish dish);
}
