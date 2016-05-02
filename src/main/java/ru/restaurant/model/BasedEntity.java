package ru.restaurant.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by �������� on 23.04.2016.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class BasedEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id=0;

    public BasedEntity() {
    }

    protected BasedEntity(Integer id){
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew(){
        return id==0;
    }

}
