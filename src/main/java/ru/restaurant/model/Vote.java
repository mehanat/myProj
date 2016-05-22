package ru.restaurant.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by �������� on 23.04.2016.
 */
@Entity
@Table(name = "votes")
public class Vote extends BasedEntity {

    @Column(name = "userid")
    int userid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lunchid")
    Lunch lunch;

    public Vote(){}


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Lunch getLunch() {
        return lunch;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
    }
}
