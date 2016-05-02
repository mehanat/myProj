package ru.restaurant.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.restaurant.Service.RestaurantService;
import ru.restaurant.model.Dish;
import ru.restaurant.model.Restaurant;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Анатолий on 26.04.2016.
 */
@ContextConfiguration({
        "classpath:Spring/spring-app.xml",
        "classpath:Spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populate.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class RestaurantServiceimplTest {

    @Autowired
    RestaurantService restaurantService;

    @Test
    public void testGetAll() throws Exception {
        List<Restaurant> restaurants=restaurantService.getAll();
        assertEquals(restaurants.size(), 1);
    }

    @Test
    public void testGetAllDishes() throws Exception {
        Set<Dish> dishes =  restaurantService.getAllDishes(1);
        assertEquals(dishes.size(), 1);
    }

    @Test
    public void testSave() throws Exception {
        Restaurant restaurant=new Restaurant();
        restaurant.setId(1);
        restaurant.setName("test");
        restaurantService.save(restaurant);
    }

    @Test
    public void testDelete() throws Exception {
        boolean res=restaurantService.delete(1);
        assertTrue(res);
    }
}