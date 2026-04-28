package models;

import java.util.ArrayList;
import java.util.List;
public class Cart {
    private int cartId;
    private User user;
    private Resturant restaurant;
    private List<MenuItem> items;
    private int totalPrice;

    public Cart(User user, Resturant restaurant) {
        this.user = user;
        this.restaurant = restaurant;
        this.cartId = generateCartId();
        this.items = new ArrayList<>();
        this.totalPrice = 0;
    }

    private int generateCartId() {
        // Code to generate a unique cart ID
        return (int) (Math.random() * 10000);
    }

    public int getCartId() {
        return cartId;
    }

    public User getUser() {
        return user;
    }

    public Resturant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void addItem(MenuItem item) {
        this.items.add(item);
        this.totalPrice += item.getPrice();
    }

    public void removeItem(MenuItem item) {
        this.items.remove(item);
        this.totalPrice -= item.getPrice();
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}