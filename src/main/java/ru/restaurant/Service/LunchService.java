package ru.restaurant.Service;

import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Анатолий on 02.05.2016.
 */
public interface LunchService {
    Lunch get(Date date, int restId);
    Lunch save(Lunch lunch);
    boolean delete(int id);
    Set<Dish> getDishes(int id);
    Set<Lunch> getAllByDate(Date date);
}
