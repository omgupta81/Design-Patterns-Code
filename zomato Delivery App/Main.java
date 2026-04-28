import models.*;
import strategyy.*;


public class Main {

    public static void main(String[] args) {

        Zomato zomato = new Zomato();

        zomato.initialize();
        // Search
        zomato.showRestaurantsByLocation("indore");
            Resturant r1 = zomato.getResturantManager().getResturant(1);
            Resturant r2 = zomato.getResturantManager().getResturant(2);
        // User 1
        User user1 = new User(
                1,
                "John",
                "john@gmail.com",
                "999999",
                "indore");

        Cart cart1 = new Cart(user1, r1);
        cart1.addItem(r1.getMenuItems().get(0));

        zomato.placeNowOrder(
                user1,
                r1,
                cart1,
                new CreditCardPayment(
                        "1234-5678",
                        "John"));

        // User 2
        User user2 = new User(
                2,
                "Jane",
                "jane@gmail.com",
                "888888",
                "indore");

        Cart cart2 = new Cart(user2, r2);
        cart2.addItem(r2.getMenuItems().get(0));

        zomato.placeScheduledOrder(
                user2,
                r2,
                cart2,
                new CashPayment(),
                "2026-05-01 18:00");
    }
}