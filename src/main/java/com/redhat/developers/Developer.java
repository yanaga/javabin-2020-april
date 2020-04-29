package com.redhat.developers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Developer extends PanacheEntity {

    @Min(3)
    public String name;

    @Column(columnDefinition = "varchar(255) default 'Quarkus'")
    public String favoriteFramework;

    /**
     * @return the name
     */
    public String getName() {
        return name.toUpperCase();
    }

    /**
     * @return the favoriteFramework
     */
    public String getFavoriteFramework() {
        return favoriteFramework.toLowerCase();
    }
}