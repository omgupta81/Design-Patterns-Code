package models;

import java.util.List;
import java.util.ArrayList;
public class Resturant {

    private String name;
    private String location;
    private int restaurantId;
    private static int idCounter = 1;
    private List<MenuItem> menuItems;

    public Resturant(String name, String location) {
        this.name = name;
        this.location = location;
        this.restaurantId = idCounter++;
        menuItems=new ArrayList<>();
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    public void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }
}