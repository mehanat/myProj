package ru.restaurant.DAO;

import ru.restaurant.model.Restaurant;
import ru.restaurant.model.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by �������� on 23.04.2016.
 */
public interface UserDAO {
    List<User> getAll();
    User getById(int id);
    User getByEmail(String email);
    User save(User user);
    boolean delete(int id);
    boolean vote(User user, int restId, LocalDateTime dateTime);
}
