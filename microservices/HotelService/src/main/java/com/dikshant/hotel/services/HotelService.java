package com.dikshant.hotel.services;

import com.dikshant.hotel.entites.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);
    List<Hotel> getAllHotels();

    Hotel getHotel(String id);
}
