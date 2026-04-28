package factory;

import models.Cart;
import models.DeliveryOrder;
import models.Order;
import models.PickupOrder;
import models.Resturant;
import models.User;
import strategyy.PaymentStrategy;

public class NowOrder implements OrderFactory {
    Order order;
    @Override
    public Order createOrder(User user, Resturant restaurant, Cart cart,String type,PaymentStrategy paymentStrategy) {
        if (type.equalsIgnoreCase("delivery")) {
            order = new DeliveryOrder(user, restaurant, cart, user.getLocation());
        } else if (type.equalsIgnoreCase("pickup")) {
            order = new PickupOrder(user, restaurant, cart,restaurant.getLocation());
        } else {
            throw new IllegalArgumentException("Invalid order type: " + type);
        }
       
        order.setPaymentStrategy(paymentStrategy);
        return (Order) order;
    }
      
}