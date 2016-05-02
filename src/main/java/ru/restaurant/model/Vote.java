package ru.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by �������� on 23.04.2016.
 */
@Entity
@Table(name = "votes")
public class Vote extends BasedEntity {

    @Column(name = "userid")
    int userid;
    @Column(name = "restid")
    int restid;
    @Column(name = "date")
    Date date;

    public Vote(){}

    public int getRestid() {
        return restid;
    }

    public void setRestid(int restid) {
        this.restid = restid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
