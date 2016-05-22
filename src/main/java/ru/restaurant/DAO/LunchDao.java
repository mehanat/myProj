package ru.restaurant.DAO;

import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;

import java.util.Date;
import java.util.Set;

/**
 * Created by Анатолий on 02.05.2016.
 */
public interface LunchDao {
    Lunch get(Date date, int restId);
    Set<Lunch> getAllByDate(Date date);
    Lunch save(Lunch lunch);
    boolean delete(int id);
    Set<Dish> getDishes(int id);
}
