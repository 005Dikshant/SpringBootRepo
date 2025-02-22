package com.dikshant.rating.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Rating {

    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    @Id
    private String ratingId;

}
