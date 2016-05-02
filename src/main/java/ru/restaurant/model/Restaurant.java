package ru.restaurant.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;
import java.util.Set;

/**
 * Created by �������� on 23.04.2016.
 */
@Entity
@Table(name = "restaurants")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Restaurant extends NamedEntity {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "lunches",
            joinColumns = @JoinColumn(name = "restId"),
            inverseJoinColumns = @JoinColumn(name = "dishId")
    )
    @JsonIgnore
    private Set<Dish> dishes;

    public Restaurant(){}

    public Set<Dish> getDishes() {
        return dishes;
    }

    private void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }
}
