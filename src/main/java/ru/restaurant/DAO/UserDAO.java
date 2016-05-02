package ru.restaurant.DAO;

import ru.restaurant.model.Restaurant;
import ru.restaurant.model.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анатолий on 23.04.2016.
 */
public interface UserDAO {
    List<User> getAll();
    User getById(int id);
    User save(User user);
    boolean delete(int id);
    boolean vote(User user, Restaurant restaurant, LocalDateTime dateTime);
}
