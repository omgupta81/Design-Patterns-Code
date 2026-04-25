
// Factory Method Design Pattern Example

// Product
abstract class Burger {

    public abstract void prepare();
}


// Concrete Products

class BasicBurger extends Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger");
    }
}

class StandardBurger extends Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger");
    }
}

class PremiumBurger extends Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger");
    }
}


// Wheat Burger Variants

class BasicWheatBurger extends Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger");
    }
}

class StandardWheatBurger extends Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger");
    }
}

class PremiumWheatBurger extends Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger");
    }
}


// Creator

abstract class BurgerFactory {

    // Factory Method
    public abstract Burger createBurger(String type);

    // Common workflow for ordering burger
    public Burger orderBurger(String type) {

        Burger burger = createBurger(type);

        if (burger != null) {
            burger.prepare();
        } else {
            System.out.println("Invalid Burger Type");
        }

        return burger;
    }
}


// Concrete Factories

class SinghBurger extends BurgerFactory {

    @Override
    public Burger createBurger(String type) {

        switch (type.toLowerCase()) {

            case "basic":
                return new BasicBurger();

            case "standard":
                return new StandardBurger();

            case "premium":
                return new PremiumBurger();

            default:
                return null;
        }
    }
}


class KingBurger extends BurgerFactory {

    @Override
    public Burger createBurger(String type) {

        switch (type.toLowerCase()) {

            case "basic":
                return new BasicWheatBurger();

            case "standard":
                return new StandardWheatBurger();

            case "premium":
                return new PremiumWheatBurger();

            default:
                return null;
        }
    }
}


// Client

public class FactoryMethodDesignPattern {
     public static void main(String[] args) {
        BurgerFactory singhFactory = new SinghBurger();
        BurgerFactory kingFactory = new KingBurger();

        System.out.println("Ordering from Singh Burger:");
        singhFactory.orderBurger("basic");
        singhFactory.orderBurger("standard");
        singhFactory.orderBurger("premium");

        System.out.println("\nOrdering from King Burger:");
        kingFactory.orderBurger("basic");
        kingFactory.orderBurger("standard");
        kingFactory.orderBurger("premium");
    }
}