package ru.restaurant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.Service.UserService;
import ru.restaurant.model.User;

import java.time.LocalDateTime;

/**
 * Created by Анатолий on 03.05.2016.
 */
@RestController
@RequestMapping(value = "/user/rest")
public class UserRestController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "{restId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean vote(@PathVariable(value = "restId") int restId, @RequestBody User user){
        LocalDateTime dateTime=LocalDateTime.now();
        return dateTime.getHour()<=11 && userService.vote(user, restId, LocalDateTime.now());
    }
}
