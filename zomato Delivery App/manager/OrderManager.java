package manager;
import java.util.List;

import models.Order;

import java.util.ArrayList;
public class OrderManager {
    private static OrderManager instance;
    private List<Order> orders;

    private OrderManager() {
        this.orders = new ArrayList<>();
    }
     
    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }
    public void createOrder(Order order) {
        orders.add(order);
        System.out.println("Order created with ID: " + order.getOrderId());
    }
    public List<Order> getOrders() {
        return orders;
    }
    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null; // Order not found
    }
    public void payOrder(Order order) {
       order.processPayment();
       orders.remove(order);
       System.out.println("Order with ID: " + order.getOrderId() + " has been paid and removed from the system.");  
    }
    

}
