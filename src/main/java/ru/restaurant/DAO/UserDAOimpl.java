package ru.restaurant.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurant.model.Restaurant;
import ru.restaurant.model.User;
import ru.restaurant.model.Vote;
import ru.restaurant.utils.TimeConverter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

/**
 * Created by Анатолий on 02.05.2016.
 */
@Repository
public class UserDAOimpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession(){ return sessionFactory.getCurrentSession(); }

    public List<User> getAll() {
        return (List<User>) currentSession().createQuery("FROM User").list();
    }

    public User getById(int id) {
        return currentSession().get(User.class, id);
    }

    public User save(User user) {
        if (user.isNew()){
            int id=(Integer)currentSession().save(user);
            user.setId(id);
        } else currentSession().update(user);
        return user;
    }

    public boolean delete(int id) {
        return currentSession().createQuery("DELETE FROM User WHERE id=:id").setInteger("id", id).executeUpdate()>0;
    }

    public boolean vote(User user, Restaurant restaurant, LocalDateTime dateTime) {
        Vote vote=new Vote();
        vote.setDate(Date.from(dateTime.toInstant(ZoneOffset.UTC)));
        vote.setRestid(restaurant.getId());
        vote.setUserid(user.getId());

        return ((Integer)currentSession().save(vote))>0;
    }
}
