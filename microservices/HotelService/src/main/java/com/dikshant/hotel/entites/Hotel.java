package com.dikshant.hotel.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Table(name="hotels")
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;

}
