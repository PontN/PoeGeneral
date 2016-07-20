package fr.epsi.poe.mobile.projetjava.restaurant;

import fr.epsi.poe.mobile.projetjava.restaurant.controllers.RestaurantController;
import fr.epsi.poe.mobile.projetjava.restaurant.models.Restaurant;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nicolas on 20/07/2016.
 */
public class Main {

    public static void main(String args[]) {

        RestaurantController restaurantController = new RestaurantController();
        double latitude;
        double longitude;


        System.out.println("Hi !");
        System.out.println("You have to precise your GPS coordinates (only in France).");
        System.out.println("42.72 > Latitude > 50.99");
        System.out.println("-5.09 > Longitude > 8.75");


        while (true) {
            try {
                Scanner element = new Scanner(System.in);
                System.out.print("Get latitude : ");
                latitude = element.nextDouble();
                System.out.print("Get longitude : ");
                longitude = element.nextDouble();
                List<Restaurant> restaurantList = restaurantController.getRestaurant(latitude, longitude);

                for (int i = 0; i < restaurantList.size(); i++) {
                    System.out.println(restaurantList.get(i).getName());
                    System.out.println(restaurantList.get(i).getVicinity());
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("You have to get a double");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
