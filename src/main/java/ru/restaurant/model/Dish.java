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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lunch_id")
    protected Lunch lunch;


    public Dish(){}

    public Dish(String name, String description) {
        super();
        this.name=name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Lunch getLunch() {
        return lunch;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
    }
}
