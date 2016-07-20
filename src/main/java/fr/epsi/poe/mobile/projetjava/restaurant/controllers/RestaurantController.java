package fr.epsi.poe.mobile.projetjava.restaurant.controllers;

import fr.epsi.poe.mobile.projetjava.restaurant.models.Restaurant;
import fr.epsi.poe.mobile.projetjava.restaurant.services.RestaurantServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 19/07/2016.
 */
public class RestaurantController {

    private RestaurantServices restaurantServices = new RestaurantServices();

    public List<Restaurant> getRestaurant(Double latitude, Double longitude) throws IllegalArgumentException {

        //Parameters null
        if (latitude == null || longitude == null) {
            throw new IllegalArgumentException("Error : latitude and longitude cannot be null.");
        }
        /*//Parameters == 0.0
        if (latitude == 0.0 || longitude == 0.0) {
            throw new IllegalArgumentException("Error : latitude and longitude cannot be equal to 0.");
        }*/
        // Parameters out of France
        if ((42.72 > latitude || latitude > 50.99) || (-5.09 > longitude || longitude > 8.75)) {
            throw new IllegalArgumentException("Error : latitude and longitude cannot be outside of France.");
        }

        return restaurantServices.getRestaurantFromGoogle(latitude, longitude);
    }

}
