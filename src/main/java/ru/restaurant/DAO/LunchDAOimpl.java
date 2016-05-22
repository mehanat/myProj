package ru.restaurant.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;
import ru.restaurant.model.Restaurant;

import java.util.Date;
import java.util.Set;

/**
 * Created by Анатолий on 02.05.2016.
 */
@Repository
public class LunchDAOimpl implements LunchDao {

    SessionFactory sessionFactory;

    @Autowired
    public LunchDAOimpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }


    public Lunch get(Date date, int restId) {
        Restaurant res = currentSession().load(Restaurant.class, restId);
        return (Lunch) currentSession().createQuery("FROM Lunch WHERE restaurant=:res AND date=:date").setEntity("res", res).setDate("date", date).list().get(0);
    }

    public Set<Lunch> getAllByDate(Date date) {
        Set<Lunch> lunches=(Set<Lunch>) currentSession().createQuery("FROM Lunch WHERE date=:date").setDate("date", date).list();
        for (Lunch lunch:lunches){
            lunch.getId();
        }
        return lunches;
    }


    public Lunch save(Lunch lunch) {
        if (lunch.isNew()){
            int id=(Integer)currentSession().save(lunch);
            lunch.setId(id);
        } else {
            for (Dish dish:lunch.getDishes()){
                dish.setLunch(lunch);
            }
            currentSession().update(lunch);
        }
        return lunch;
    }


    public boolean delete(int id) {
        return currentSession().createQuery("DELETE FROM Lunch WHERE id=:id").setInteger("id", id).executeUpdate()>0;
    }

    public Set<Dish> getDishes(int id){
        return currentSession().load(Lunch.class, id).getDishes();
    }
}
