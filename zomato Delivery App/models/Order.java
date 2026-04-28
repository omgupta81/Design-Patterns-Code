package models;

import java.util.ArrayList;
import java.util.List;
import strategyy.PaymentStrategy;


public abstract class Order {
    private int orderId;
    private User user;
    private Resturant restaurant;
   private Cart cart;
    private PaymentStrategy strategy;
    

    public Order(User user, Resturant restaurant, Cart cart) {
        this.user = user;
        this.restaurant = restaurant;
        this.cart = cart;        
        this.orderId = generateOrderId();
      
    }

    private int generateOrderId() {
        // Code to generate a unique order ID
        return (int) (Math.random() * 10000);
    }

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public Resturant getRestaurant() {
        return restaurant;
    }

    public int getTotalPrice() {
        return cart.getTotalPrice();
    }
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void processPayment() {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        strategy.pay(cart.getTotalPrice());
    }
    public void addItem(MenuItem item) {
        cart.addItem(item);
    }
    public List<MenuItem> getItems() {
        return cart.getItems();
    }
    public void removeItem(MenuItem item) {
        cart.removeItem(item);
    }
   
    public abstract void getType();

   
}
