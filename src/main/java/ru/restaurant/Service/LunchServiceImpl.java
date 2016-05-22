package ru.restaurant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurant.DAO.LunchDao;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Анатолий on 02.05.2016.
 */
@Service
@Transactional
public class LunchServiceImpl implements LunchService {

    @Autowired
    LunchDao lunchDao;


    public Lunch get(Date date, int restId) {
        return lunchDao.get(date, restId);
    }


    @Transactional
    public Lunch save(Lunch lunch) {
        return lunchDao.save(lunch);
    }


    @Transactional
    public boolean delete(int id) {
        return lunchDao.delete(id);
    }

    public Set<Dish> getDishes(int id) {
        return lunchDao.getDishes(id);
    }

    public Set<Lunch> getAllByDate(Date date) {
        return lunchDao.getAllByDate(date);
    }
}
