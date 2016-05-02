package ru.restaurant.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * Created by �������� on 23.04.2016.
 */
@Entity
@Table(name = "dishes")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Dish extends NamedEntity {

    @Column(name = "description")
    protected String description;
    @NotNull
    @Column(name = "price")
    protected Integer price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "lunches",
    joinColumns = @JoinColumn(name = "dishId"),
    inverseJoinColumns = @JoinColumn(name = "restId")
    )
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    protected Set<Restaurant> restaurants;

    public Dish(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
