package manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Resturant;
public class ResturantManager {
    private Map<Integer, Resturant> resturants;
    private static ResturantManager instance;

    private ResturantManager() {
        this.resturants = new HashMap<>();
    }

    public static ResturantManager getInstance() {
        if (instance == null) {
            instance = new ResturantManager();
        }
        return instance;
    }

    public void addResturant(Resturant resturant) {
        // Code to add a new restaurant to the system
        resturants.put(resturant.getRestaurantId(), resturant);
    }

    public void updateResturant(Resturant resturant) {
        // Code to update restaurant details
       if(resturants.containsKey(resturant.getRestaurantId())) {
            resturants.remove(resturant.getRestaurantId());
        }
        resturants.put(resturant.getRestaurantId(), resturant);
    }

    public void removeResturant(int restaurantId) {
        // Code to remove a restaurant from the system
        resturants.remove(restaurantId);
    }
    public Resturant getResturant(int restaurantId) {
        // Code to retrieve restaurant details
        return resturants.get(restaurantId);
    }


    public ArrayList<Resturant> searchByLocation(String location) {
        // Code to search for restaurants by location
        ArrayList<Resturant> results = new ArrayList<>();
         for(Resturant resturant : resturants.values()) {
            if(resturant.getLocation().equalsIgnoreCase(location)) {
                results.add(resturant);
            }
        }
        return results;
    }
}


