package ru.restaurant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurant.DAO.UserDAO;
import ru.restaurant.model.Restaurant;
import ru.restaurant.model.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анатолий on 02.05.2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    public List<User> getAll() {
        return userDAO.getAll();
    }

    public User getById(int id) {
        return userDAO.getById(id);
    }
    @Transactional
    public User save(User user) {
        return userDAO.save(user);
    }
    @Transactional
    public boolean delete(int id) {
        return userDAO.delete(id);
    }
    @Transactional
    public boolean vote(User user, Restaurant restaurant, LocalDateTime dateTime) {
        return userDAO.vote(user, restaurant, dateTime);
    }
}
