package ru.restaurant.utils;

import ru.restaurant.model.Dish;
import ru.restaurant.model.Lunch;

import java.util.List;

/**
 * Created by Анатолий on 22.05.2016.
 */
public class LunchAndDishes {
    Lunch lunch;
    List<Dish> dishes;

    public Lunch getLunch() {
        return lunch;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}
