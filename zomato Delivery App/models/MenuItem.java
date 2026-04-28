package models;

public class MenuItem {
    private String name;
    private String description;
    private double price;
    private String id;

    public MenuItem(String name, String description, double price, String id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }
}