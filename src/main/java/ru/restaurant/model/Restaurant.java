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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "restaurant")
    @JsonIgnore
    private Set<Lunch> lunches;

    public Restaurant(){}

    public Set<Lunch> getLunches() {
        return lunches;
    }

    public void setLunches(Set<Lunch> lunches) {
        this.lunches = lunches;
    }
}
