package ru.restaurant.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Restaurant;

import java.util.List;
import java.util.Set;

/**
 * Created by Анатолий on 26.04.2016.
 */
@Repository
public class RestaurantDAOimpl implements RestaurantDAO {

    private SessionFactory sessionFactory;

    @Autowired
    RestaurantDAOimpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    private Session currentSession(){ return sessionFactory.getCurrentSession(); }

    public List<Restaurant> getAll() {
        return (List<Restaurant>) currentSession().createQuery("FROM Restaurant").list();
    }

    public Set<Dish> getAllDishes(int restId) {
            return currentSession().load(Restaurant.class, restId).getDishes();
    }

    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()){
            int id=(Integer)currentSession().save(restaurant);
            restaurant.setId(id);
        } else currentSession().update(restaurant);
        return restaurant;
    }

    public boolean delete(int id) {
        return currentSession().createQuery("DELETE FROM Restaurant WHERE id=:id").setInteger("id", id).executeUpdate()>0;
    }
}
