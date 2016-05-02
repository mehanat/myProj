package ru.restaurant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurant.DAO.RestaurantDAO;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Restaurant;

import java.util.List;
import java.util.Set;

/**
 * Created by Анатолий on 26.04.2016.
 */
@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantDAO restaurantDAO;

    public List<Restaurant> getAll() {
        return restaurantDAO.getAll();
    }

    public Set<Dish> getAllDishes(int restId) {
        return restaurantDAO.getAllDishes(restId);
    }

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return restaurantDAO.save(restaurant);
    }

    @Transactional
    public boolean delete(int id) {
        return restaurantDAO.delete(id);
    }
}
