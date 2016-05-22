package ru.restaurant.DAO;

import ru.restaurant.model.Dish;
import ru.restaurant.model.Restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Created by �������� on 23.04.2016.
 */
public interface DishDAO {
    Dish get(int id);
    boolean delete(int id);
    Dish save(Dish dish);
}
