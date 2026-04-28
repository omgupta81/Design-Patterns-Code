package models;

import java.util.List;

public class PickupOrder extends Order {
    private String pickupLocation;

    public PickupOrder(User user, Resturant restaurant, Cart cart, String pickupLocation) {
        super(user, restaurant, cart);
        this.pickupLocation = pickupLocation;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    @Override
    public void getType() {
        System.out.println("This is a pickup order.");
    }
}
