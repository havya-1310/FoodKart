package com.havya.practice.service;

import com.havya.practice.enums.SortingStrategy;
import com.havya.practice.models.FoodItem;
import com.havya.practice.models.Rating;
import com.havya.practice.models.Restaurant;
import com.havya.practice.strategy.PriceStrategy;
import com.havya.practice.strategy.RatingStrategy;
import com.havya.practice.strategy.RestaurantSortingStrategy;

import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    UserDao userDao;
    RestaurantDao restaurantDao;

    public RestaurantService() {
        userDao = UserDao.getUserDaoInstance();
        restaurantDao = RestaurantDao.getRestaurantDaoInstance();
    }

    public List<Restaurant> getSortedRestaurants(SortingStrategy sortingStrategy) {
        RestaurantSortingStrategy restaurantSortingStrategy = null;
        if (SortingStrategy.PRICE.equals(sortingStrategy)) {
            restaurantSortingStrategy = new PriceStrategy();
        } else if (SortingStrategy.RATING.equals(sortingStrategy)) {
            restaurantSortingStrategy = new RatingStrategy();
        }
        if (restaurantSortingStrategy != null) {
            return restaurantSortingStrategy.getRestaurants(restaurantDao.getAllRestaurants(), userDao.getLoggedInUser());
        }
        return new ArrayList<>();
    }

    public void addQuantity(String restaurantName, int newQty) throws Exception {
        Restaurant restaurant = restaurantDao.getRestaurant(restaurantName);
        restaurant.getFoodItem().setQuantity(restaurant.getFoodItem().getQuantity() + newQty);
    }

    public void registerRestaurant(String name, List<String> pinCodes, String dishName, int price, int qty) {
        Restaurant restaurant = new Restaurant(name, pinCodes, new FoodItem(dishName, price, qty), new Rating(), userDao.getLoggedInUser());
        restaurantDao.addRestaurant(restaurant);
    }

    public void rateRestaurant(String name, int ratingVal, String comment) throws Exception {
        Restaurant restaurant = restaurantDao.getRestaurant(name);
        Rating rating = restaurant.getRating();
        if (rating == null) {
            rating = new Rating();
        }
        rating.addRating(comment, ratingVal);
        restaurant.setRating(rating);
    }

    public boolean placeOrder(String restaurantName, int qty) throws Exception {
        Restaurant restaurant = restaurantDao.getRestaurant(restaurantName);
        int currentQty = restaurant.getFoodItem().getQuantity();
        if (currentQty < qty) {
            return false;
        }
        restaurant.getFoodItem().setQuantity(currentQty - qty);
        return true;
    }

}
