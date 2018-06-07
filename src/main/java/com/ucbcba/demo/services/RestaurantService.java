package com.ucbcba.demo.services;

import com.ucbcba.demo.Entities.City;
import com.ucbcba.demo.Entities.Restaurant;

import java.util.List;

public interface RestaurantService {
    Iterable<Restaurant> listAllRestaurants();

    void saveRestaurant(Restaurant restaurant);

    Restaurant getRestaurant(Integer id);

    void deleteRestaurant(Integer id);

    Iterable<Restaurant> getRestaurantLikeNameCityCategory(String name, Integer cityid, Integer categoryid);

    Iterable<Restaurant> getRestaurantLikeNameCity(String name, Integer cityid);

    Iterable<Restaurant> getRestaurantLikeNameCategory(String name, Integer categoryid);

    Iterable<Restaurant> getRestaurantLikeCityCategory(Integer cityid,Integer categoryid);

    Iterable<Restaurant> getRestaurantByCity(Integer cityid);

    Iterable<Restaurant> getRestaurantByCategory(Integer categoryid);

    Iterable<Restaurant> getRestaurantByName(String name);

    Iterable<Restaurant> listGeneralRanking();

    Iterable<Restaurant> findTop3RestaurantsComentados();
}
