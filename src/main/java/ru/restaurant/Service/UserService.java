package ru.restaurant.Service;

import ru.restaurant.model.Restaurant;
import ru.restaurant.model.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анатолий on 02.05.2016.
 */
public interface UserService {
    List<User> getAll();
    User getById(int id);
    User save(User user);
    boolean delete(int id);
    boolean vote(User user, int restId, LocalDateTime dateTime);
}
