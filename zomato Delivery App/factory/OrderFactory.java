package factory;

import models.*;
import strategyy.*;


public interface OrderFactory {
    Order createOrder(User user, Resturant restaurant, Cart cart,String type,PaymentStrategy paymentStrategy);
}