// Abstract Factory Design Pattern Example


// Product Family 1 - Burger

abstract class Burger {

    public abstract void prepare();
}


// Concrete Burgers

class BasicBurger extends Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger");
    }
}

class BasicWheatBurger extends Burger {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger");
    }
}


// Product Family 2 - Garlic Bread

abstract class GarlicBread {

    public abstract void prepare();
}


// Concrete Garlic Breads

class BasicGarlicBread extends GarlicBread {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Garlic Bread");
    }
}

class BasicWheatGarlicBread extends GarlicBread {

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Wheat Garlic Bread");
    }
}


// Abstract Factory

abstract class MealFactory {

    public abstract Burger createBurger();

    public abstract GarlicBread createGarlicBread();
}


// Concrete Factory 1

class SinghFactory extends MealFactory {

    @Override
    public Burger createBurger() {
        return new BasicBurger();
    }

    @Override
    public GarlicBread createGarlicBread() {
        return new BasicGarlicBread();
    }
}


// Concrete Factory 2

class KingFactory extends MealFactory {

    @Override
    public Burger createBurger() {
        return new BasicWheatBurger();
    }

    @Override
    public GarlicBread createGarlicBread() {
        return new BasicWheatGarlicBread();
    }
}


// Client

public class AbstractFactoryDesignPattern {

    public static void main(String[] args) {

        MealFactory factory1 = new SinghFactory();

        Burger burger1 = factory1.createBurger();
        GarlicBread bread1 = factory1.createGarlicBread();

        burger1.prepare();
        bread1.prepare();

        System.out.println();

        MealFactory factory2 = new KingFactory();

        Burger burger2 = factory2.createBurger();
        GarlicBread bread2 = factory2.createGarlicBread();

        burger2.prepare();
        bread2.prepare();
    }
}