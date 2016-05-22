package ru.restaurant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurant.DAO.UserDAO;
import ru.restaurant.LoggedUser;
import ru.restaurant.model.Restaurant;
import ru.restaurant.model.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анатолий on 02.05.2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

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
    public boolean vote(User user, int restId, LocalDateTime dateTime) {
        return userDAO.vote(user, restId, dateTime);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDAO.getByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("User "+ email + " is not found!");
        } else
        return new LoggedUser(user);
    }
}
