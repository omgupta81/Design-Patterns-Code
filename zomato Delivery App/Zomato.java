
import factory.*;
import manager.*;
import models.*;
import strategyy.*;

public class Zomato {

    private ResturantManager resturantManager;
    private OrderManager orderManager;

    public Zomato() {
        resturantManager = ResturantManager.getInstance();
        orderManager = OrderManager.getInstance();
    }

    public ResturantManager getResturantManager() {
        return resturantManager;
    }

    public void initialize() {
        // Create some restaurants and menu items

        Resturant restaurant1 = new Resturant("Pasta Palace", "indore");
        restaurant1.addMenuItem(new MenuItem("Spaghetti Carbonara", "Classic Italian pasta dish with eggs, cheese, pancetta, and pepper.", 12.99, "1"));
        restaurant1.addMenuItem(new MenuItem("Fettuccine Alfredo", "Creamy pasta dish with butter, cream, and Parmesan cheese.", 11.99, "2"));
        resturantManager.addResturant(restaurant1);

        Resturant restaurant2 = new Resturant("Sushi Central", "indore");
        restaurant2.addMenuItem(new MenuItem("California Roll", "Crab, avocado, and cucumber rolled in seaweed and rice.", 8.99, "3"));
        restaurant2.addMenuItem(new MenuItem("Spicy Tuna Roll", "Tuna mixed with spicy mayo rolled in seaweed and rice.", 9.99, "4"));
        resturantManager.addResturant(restaurant2);

        Resturant restaurant3 = new Resturant("Pizza Delight", "indore");
        restaurant3.addMenuItem(new MenuItem("Margherita Pizza", "Classic pizza with tomato sauce, mozzarella cheese, and fresh basil.", 10.99, "5"));
        restaurant3.addMenuItem(new MenuItem("Pepperoni Pizza", "Pizza topped with tomato sauce, mozzarella cheese, and pepperoni slices.", 11.99, "6"));
        resturantManager.addResturant(restaurant3);

        Resturant restaurant4 = new Resturant("Burger Haven", "indore");
        restaurant4.addMenuItem(new MenuItem("Classic Cheeseburger", "Juicy beef patty with cheddar cheese, lettuce, tomato, and pickles on a sesame seed bun.", 9.99, "7"));
        restaurant4.addMenuItem(new MenuItem("Bacon Burger", "Beef patty topped with crispy bacon, cheddar cheese, lettuce, tomato, and pickles on a sesame seed bun.", 10.99, "8"));
        resturantManager.addResturant(restaurant4);
    }

    public void addRestaurant(Resturant restaurant) {
        resturantManager.addResturant(restaurant);
    }

    public void showRestaurantsByLocation(String location) {
        resturantManager.searchByLocation(location)
                .forEach(r -> System.out.println(
                "Restaurant: " + r.getName()
                + ", Location: " + r.getLocation()));
    }

    public Order placeNowOrder(User user, Resturant restaurant,
            Cart cart,
            PaymentStrategy paymentStrategy) {

        OrderFactory orderFactory = new NowOrder();

        Order order = orderFactory.createOrder(
                user,
                restaurant,
                cart,
                "delivery",
                paymentStrategy
        );

        orderManager.createOrder(order);
        orderManager.payOrder(order);

        return order;
    }

    public Order placeScheduledOrder(User user,
            Resturant restaurant,
            Cart cart,
            PaymentStrategy paymentStrategy,
            String scheduleTime) {

        OrderFactory orderFactory
                = new ScheduledOrder(scheduleTime);

        Order order = orderFactory.createOrder(
                user,
                restaurant,
                cart,
                "pickup",
                paymentStrategy
        );

        orderManager.createOrder(order);
        orderManager.payOrder(order);

        return order;
    }
}
