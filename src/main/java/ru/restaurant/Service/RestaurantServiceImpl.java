package ru.restaurant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurant.DAO.RestaurantDAO;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;
import ru.restaurant.model.Restaurant;
import ru.restaurant.utils.LunchRating;

import java.util.*;

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


    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return restaurantDAO.save(restaurant);
    }

    @Transactional
    public boolean delete(int id) {
        return restaurantDAO.delete(id);
    }

    public Restaurant get(int id) {
        return restaurantDAO.get(id);
    }

    public void saveLunch(Date date, Set<Dish> lunch, int id) {
        restaurantDAO.saveLunch(date, lunch, id);
    }

    public List<LunchRating> getLunchesRating(int id) {
        List<LunchRating> ratings=new ArrayList<>();

        for (Map.Entry<Lunch, Integer> pair:restaurantDAO.getLunchesRating(id).entrySet()){
            ratings.add(new LunchRating(pair.getKey(), pair.getValue()));
        }
        return ratings;
    }

    public List<LunchRating> getLunchesRating(Date date){
        List<LunchRating> ratings=new ArrayList<>();

        for (Map.Entry<Lunch, Integer> pair:restaurantDAO.getLunchesRating(date).entrySet()){
            ratings.add(new LunchRating(pair.getKey(), pair.getValue()));
        }
        return ratings;
    }

}
