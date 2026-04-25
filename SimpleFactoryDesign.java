
// Simple Factory Design Pattern Example


// Product

abstract class Burger {

    // Every burger must define how it is prepared
    public abstract void prepare();
}


// Concrete Products

class BasicBurger extends Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger:");
        System.out.println("- Bun");
        System.out.println("- Veg Patty");
        System.out.println("- Basic Sauce");
    }
}


class StandardBurger extends Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger:");
        System.out.println("- Bun");
        System.out.println("- Cheese Patty");
        System.out.println("- Lettuce");
        System.out.println("- Mayo");
    }
}


class PremiumBurger extends Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger:");
        System.out.println("- Brioche Bun");
        System.out.println("- Double Patty");
        System.out.println("- Cheese");
        System.out.println("- Special Sauce");
        System.out.println("- Extra Toppings");
    }
}


// Factory Class

class BurgerFactory {

    // Creates burger object based on type
    public static Burger createBurger(String type) {

        if (type == null) {
            return null;
        }

        switch (type.toLowerCase()) {

            case "basic":
                return new BasicBurger();

            case "standard":
                return new StandardBurger();

            case "premium":
                return new PremiumBurger();

            default:
                throw new IllegalArgumentException("Invalid burger type: " + type);
        }
    }
}


// Client Code
public class SimpleFactoryDesign {

     public static void main(String[] args) {

        Burger burger1 = BurgerFactory.createBurger("basic");
        burger1.prepare();

        System.out.println();

        Burger burger2 = BurgerFactory.createBurger("standard");
        burger2.prepare();

        System.out.println();

        Burger burger3 = BurgerFactory.createBurger("premium");
        burger3.prepare();
    }
}