package fr.epsi.poe.mobile.projetjava.restaurant.services;

import com.google.maps.*;
import com.google.maps.model.*;
import fr.epsi.poe.mobile.projetjava.restaurant.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 19/07/2016.
 */
public class RestaurantServices {

    private String apiKey = "AIzaSyBCip_B2CiQ5e1WN-TFZYXmwmcTGF8JtDE";
    private Boolean openNow = true;
    private Integer radius = 3000;
    private String url;

    public List<Restaurant> getRestaurantFromGoogle(Double latitude, Double longitude) throws IllegalArgumentException {

        //Definition tableau vide
        List<Restaurant> restaurantList = new ArrayList<Restaurant>();

        //Appel Google
        PlacesSearchResponse responseGoogle = callGoogle(latitude, longitude);

        //Transforme réponse Google pour Remplir le Tableau
        restaurantList = callListRestaurant(responseGoogle);

        //Renvoie Tableau
        return restaurantList;
    }

    protected PlacesSearchResponse callGoogle(double latitude, double longitude) {

        GeoApiContext context = new GeoApiContext().setApiKey(apiKey);
        NearbySearchRequest myRequest = PlacesApi.nearbySearchQuery(context, new LatLng(latitude, longitude));
        myRequest.radius(radius);
        myRequest.openNow(openNow);
        myRequest.type(PlaceType.RESTAURANT);

        PlacesSearchResponse response = null;
        try {
            response = myRequest.await();
        } catch (Exception e) {
        }

        return response;
    }

    protected List<Restaurant> callListRestaurant(PlacesSearchResponse responseGoogle) {

        List<Restaurant> restaurantList = new ArrayList<Restaurant>();
        Restaurant resto;

        for (int i = 0; i <responseGoogle.results.length; i++) {
            resto = new Restaurant();
            resto.setName(responseGoogle.results[i].name);
            resto.setVicinity(responseGoogle.results[i].vicinity);
            restaurantList.add(resto);
        }

        return restaurantList;
    }
}




