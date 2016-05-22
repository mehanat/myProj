package ru.restaurant.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.restaurant.model.Restaurant;
import ru.restaurant.model.Role;
import ru.restaurant.model.User;

import java.time.LocalDateTime;
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
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void testGetAll() throws Exception {
        userService.getAll();
    }

    @Test
    public void testGetById() throws Exception {
        userService.getById(1);
    }

    @Test
    public void testSave() throws Exception {
        User user=new User();
        user.setName("Test");
        user.setRegistered(new Date());
        user.setEmail("test@mail.ru");
        user.setPassword("test");
        Set<Role> roles=new HashSet<Role>();
            roles.add(Role.USER);
        user.setRoles(roles);
        userService.save(user);
    }

    @Test
    public void testDelete() throws Exception {
        userService.delete(1);
    }

    @Test
    public void testVote() throws Exception {
        User user = new User(); user.setId(1);
        userService.vote(user, 1, LocalDateTime.now());
    }
}