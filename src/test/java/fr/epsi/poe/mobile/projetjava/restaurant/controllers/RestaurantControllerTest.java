package fr.epsi.poe.mobile.projetjava.restaurant.controllers;

import fr.epsi.poe.mobile.projetjava.restaurant.models.Restaurant;
import org.junit.Test;

import java.beans.Expression;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;

/**
 * Created by Nicolas on 19/07/2016.
 */
public class RestaurantControllerTest {

    private RestaurantController restaurantController = new RestaurantController();

    // throws = renvoie
    // Exception = Encapsule les erreurs; décrit les erreurs.
    // Si une méthode renvoie a une exeption, on peut faire un try/catch.

    @Test
    public void shouldThrowsExceptionIfParametersAreIllegalParametersArePassed() throws Exception {
        //Exception : longitude et latitude pas null

        try {
            restaurantController.getRestaurant(null, null);
            fail("Fail Test");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be null.");
            assertThat(e).hasNoCause();
        }

        try {
            restaurantController.getRestaurant(null, 12.0);
            fail("Fail Test");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be null.");
            assertThat(e).hasNoCause();
        }

        try {
            restaurantController.getRestaurant(8.0, null);
            fail("Fail Test");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be null.");
            assertThat(e).hasNoCause();
        }
    }

    /*@Test
    public void shouldThrowsExceptionIfParametersAreEqualsToZero() throws Exception {
        //Exception : longitude et latitude !=0 ( on ne se trouve pas a l'équateur)
        try {
            restaurantController.getRestaurant(0.0, 0.0);
            fail("Fail Test");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be equal to 0.");
            assertThat(e).hasNoCause();
        }
        try {
            restaurantController.getRestaurant(2.0, 0.0);
            fail("Fail Test");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be equal to 0.");
            assertThat(e).hasNoCause();
        }
        try {
            restaurantController.getRestaurant(0.0, 9.0);
            fail("Fail Test");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be equal to 0.");
            assertThat(e).hasNoCause();
        }
    }*/

    @Test
    public void shouldThrowsExceptionIfParametersAreOutsideOfFrance() throws Exception{
        //Exception : longitude et latitude en France
        //latitude > et longitude >
        try {
            restaurantController.getRestaurant(53.0, 9.0);
            fail("Fail Test");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be outside of France.");
            assertThat(e).hasNoCause();
        }

        // latitude < et longitude <
        try {
            restaurantController.getRestaurant(30.0, -9.0);
            fail("Fail Test");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be outside of France.");
            assertThat(e).hasNoCause();
        }

        // latitude > et longitude ok
        try {
            restaurantController.getRestaurant(53.0, 6.0);
            fail("Fail Test");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be outside of France.");
            assertThat(e).hasNoCause();
        }
        // latitude > et longitude <
        try {
            restaurantController.getRestaurant(53.0, -10.0);
            fail("Fail Test");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be outside of France.");
            assertThat(e).hasNoCause();
        }
        // latitude < et longitude ok
        try {
            restaurantController.getRestaurant(30.0, 6.0);
            fail("Fail Test");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be outside of France.");
            assertThat(e).hasNoCause();
        }
        // latitude < et longitude >
        try {
            restaurantController.getRestaurant(30.0, 9.0);
            fail("Fail Test");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be outside of France.");
            assertThat(e).hasNoCause();
        }
        //latitude ok et longitude >
        try {
            restaurantController.getRestaurant(45.0, 9.0);
            fail("Fail Test");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be outside of France.");
            assertThat(e).hasNoCause();
        }
        //latitude ok et longitude <
        try {
            restaurantController.getRestaurant(45.0, -9.0);
            fail("Fail Test");
        }
        catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e).hasMessage("Error : latitude and longitude cannot be outside of France.");
            assertThat(e).hasNoCause();
        }
    }

    @Test
    public void shouldRestaurantControllerReturnFromRestaurantServicesRestaurantListNotNull() throws Exception{
        List<Restaurant> restaurantList = restaurantController.getRestaurant(45.7,4.76);
        assertThat(restaurantList).isNotNull();
        assertThat(restaurantList).isNotEmpty();

        for (int i = 0; i<restaurantList.size(); i++) {
            System.out.println(restaurantList.get(i).getName());
            System.out.println(restaurantList.get(i).getVicinity());
        }
    }

}