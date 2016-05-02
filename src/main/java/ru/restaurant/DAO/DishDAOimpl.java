package ru.restaurant.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Restaurant;
import ru.restaurant.utils.TimeConverter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by �������� on 23.04.2016.
 */

@Repository
public class DishDAOimpl implements DishDAO {

    private SessionFactory sessionFactory;

    @Autowired
    DishDAOimpl(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    private Session currentSession(){ return sessionFactory.getCurrentSession(); }



    public Dish get(int id) {
        /*return (Dish) currentSession().createQuery("FROM Dish WHERE id=:id").setInteger("id", id).list().get(0);*/
        return currentSession().get(Dish.class, id);
    }

    public boolean delete(int id) {
        return currentSession().createQuery("DELETE Dish WHERE id=:id").setInteger("id", id).executeUpdate()>0;
    }


    public Dish save(Dish dish) {
        if (dish.isNew()){
            int id=(Integer)currentSession().save(dish);
            dish.setId(id);
        }
        else currentSession().update(dish);
        return dish;
    }

    public List<Dish> getByDate(int restId, LocalDate date) {
        return (List<Dish>) currentSession().createSQLQuery("SELECT * FROM dishes WHERE id IN (SELECT dishid FROM lunches WHERE date=:date)")
                .addEntity(Dish.class)
                .setDate("date", TimeConverter.toDate(date))
                .setCacheable(true)
                .setCacheRegion("dishes")
                .list();
    }
}
