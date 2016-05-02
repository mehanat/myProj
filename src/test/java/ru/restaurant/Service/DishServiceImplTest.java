package ru.restaurant.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.restaurant.model.Dish;
import ru.restaurant.utils.TimeConverter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Анатолий on 23.04.2016.
 */
@ContextConfiguration({
        "classpath:Spring/spring-app.xml",
        "classpath:Spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populate.sql", config = @SqlConfig(encoding = "UTF-8"), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class DishServiceImplTest {

    @Autowired
    DishService dishService;


    @Test
    public void testSave() throws Exception {
        Dish dish=new Dish();
        dish.setName("test");
        //dish.setId(1);
        dish.setPrice(20);
        dishService.save(dish);
    }

    @Test
    public void testGet() throws Exception {
        Dish dish =  dishService.get(1);
        assertEquals(1, dish.getId().intValue());
    }

    @Test
    public void testDelete() throws Exception {
        assertTrue(dishService.delete(1));
    }

    @Test
    public void testGetByDate() throws Exception {
        List<Dish> dishes = dishService.getByDate(1, LocalDate.now());
        List<Dish> dishes2 = dishService.getByDate(1, LocalDate.now());
        Object d=dishes.iterator().next();
        int dishId= ((Dish)d).getId();
        assertEquals(dishId, 1);
    }
}