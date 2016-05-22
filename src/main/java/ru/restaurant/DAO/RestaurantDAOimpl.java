package ru.restaurant.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;
import ru.restaurant.model.Restaurant;

import java.util.*;

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

    public Restaurant get(int id) {
        return currentSession().get(Restaurant.class, id);
    }

    public void saveLunch(Date date, Set<Dish> lunch, final int id){

        for (Dish dish:lunch) {

            currentSession().createSQLQuery("INSERT INTO lunches(date, dishid, restid) VALUES (:date, :dishid, :restid)")
                    .setDate("date", date)
                    .setInteger("dishid", dish.getId())
                    .setInteger("restid", id).executeUpdate();
        }
    }

    public Map<Lunch, Integer> getLunchesRating(int id) {
        Map<Lunch, Integer> rating=new HashMap<Lunch, Integer>();

        List<Lunch> lunches=(List<Lunch>)currentSession().createQuery("FROM Lunch lunch WHERE restid=:id")
                .setInteger("id", id).list();
        for (Lunch lunch:lunches){
            rating.put(lunch, lunch.getVotes().size());
        }
        return rating;
    }

    public Map<Lunch, Integer> getLunchesRating(Date date) {
        Map<Lunch, Integer> rating=new HashMap<Lunch, Integer>();
        List<Lunch> lunches=(List<Lunch>)currentSession().createQuery("FROM Lunch lunch WHERE date=:date")
                .setDate("date", date).list();
        for (Lunch lunch:lunches){
            rating.put(lunch, lunch.getVotes().size());
        }
        return rating;
    }
}
