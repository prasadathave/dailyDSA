package LLDPrep.LLD;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManagementService {
    private static RestaurantManagementService restaurantManagementService = null;

    List<Restaurant> restaurantList = new ArrayList<>();

    private RestaurantManagementService(){

    }

    public static RestaurantManagementService getInstance(){
        if(restaurantManagementService==null){
            restaurantManagementService = new RestaurantManagementService();
        }
        return restaurantManagementService;
    }

    public List<Restaurant> searchRestaurant(String keyword){
        return null;
    }

    public void addRestaurant(){
        // add in list
    }

    public List<Item> searchMenuItem(String keyword){
        return restaurantManagementService.searchMenuItem(keyword);
    }

    public void addMenuItem(){

    }

    public void removeMenuItem(){

    }

    public void editMenuItem(){

    }

}
