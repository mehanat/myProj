package ru.restaurant.Service;

import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Анатолий on 02.05.2016.
 */
@ContextConfiguration({
        "classpath:Spring/spring-app.xml",
        "classpath:Spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populate.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class LunchServiceImplTest {

    @Autowired
    LunchService lunchService;

    @Autowired
    RestaurantService restaurantService;

    @Test
    public void testGet() throws Exception {
        lunchService.get(new Date(), 1);
    }

    @Test
    public void testSave() throws Exception {
        Lunch lunch=new Lunch();
        lunch.setDate(new Date());
        lunch.setRestaurant(restaurantService.get(1));
        lunchService.save(lunch);

        Set<Dish> dishes=new HashSet<Dish>();
        Dish dish=new Dish();
            dish.setName("test");
        dishes.add(dish);
        Lunch lunch1=lunchService.get(new Date(), 1);
        lunch1.setDishes(dishes);
        lunchService.save(lunch1);
    }

    @Test
    public void testDelete() throws Exception {
        lunchService.delete(1);
    }

    @Test
    public void testGetDishes() throws Exception {
        lunchService.getDishes(1);
    }
}