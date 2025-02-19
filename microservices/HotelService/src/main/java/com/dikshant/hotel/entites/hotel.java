package com.dikshant.hotel.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hotels")
public class hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;

}
