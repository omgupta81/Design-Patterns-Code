package models;

import java.util.List;

public class DeliveryOrder extends Order {
    private String deliveryAddress;
    

    public DeliveryOrder( User user, Resturant restaurant, Cart cart, String deliveryAddress) {
        super(user, restaurant, cart);
        this.deliveryAddress = deliveryAddress;
       
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
   @Override
    public void getType() {
        System.out.println("This is a delivery order.");
    }   
    
    
}
