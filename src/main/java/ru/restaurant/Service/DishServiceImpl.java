package ru.restaurant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurant.DAO.DishDAO;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Restaurant;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * Created by Анатолий on 23.04.2016.
 */
@Service
@Transactional
public class DishServiceImpl implements DishService {

    @Autowired
    DishDAO dishDAO;


    @Transactional
    public Dish get(int id) {
        return dishDAO.get(id);
    }
    @Transactional
    public boolean delete(int id) {
        return dishDAO.delete(id);
    }
    @Transactional
    public Dish save(Dish dish) {
        return dishDAO.save(dish);
    }

    public List<Dish> getByDate(int restId, LocalDate date) {
        return dishDAO.getByDate(restId, date);
    }
}
