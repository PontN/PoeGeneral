package fr.epsi.poe.mobile.projetjava.restaurant.services;

import com.google.maps.model.PlacesSearchResponse;
import fr.epsi.poe.mobile.projetjava.restaurant.models.Restaurant;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;


/**
 * Created by Nicolas on 19/07/2016.
 */
public class RestaurantServicesTest {


    private RestaurantServices restaurantServices = new RestaurantServices();


    @Test
    public void shouldThrowsExceptionIfReturnEmptyListOfRestaurant() {
        //Creation d'une liste restaurantList  qui renvoie à notre liste vide de RestaurantService
        List<Restaurant> restaurantList = restaurantServices.getRestaurantFromGoogle(3.2,12.5);{
            assertThat(restaurantList).isEmpty();
        }
    }

    @Test
    public void shouldGoogleResponseIsNotNull() throws Exception {
        PlacesSearchResponse responseGoogle = restaurantServices.callGoogle(45.7,4.76);{
            assertThat(responseGoogle).isNotNull();
            assertThat(responseGoogle.results).isNotEmpty();

            for (int i = 0; i<responseGoogle.results.length; i++){
                System.out.println("Le nom du restaurant "+ i + " est " + responseGoogle.results[i].name);
            }
        }
    }

}