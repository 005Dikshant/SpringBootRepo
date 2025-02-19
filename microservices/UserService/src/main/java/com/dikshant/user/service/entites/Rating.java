package com.dikshant.user.service.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private String ratingId;


}
