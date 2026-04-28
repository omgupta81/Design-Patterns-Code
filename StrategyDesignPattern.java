
// Strategy Design Pattern Example


// Behavior Interfaces

interface Talkable {
    void talk();
}

interface Walkable {
    void walk();
}

interface Flyable {
    void fly();
}

interface Projectable {
    void project();
}


// Talk Behaviors

class NormalTalk implements Talkable {

    @Override
    public void talk() {
        System.out.println("Robot speak normally");
    }
}

class NoTalk implements Talkable {

    @Override
    public void talk() {
        System.out.println("This robot cannot talk");
    }
}


// Walk Behaviors

class NormalWalk implements Walkable {

    @Override
    public void walk() {
        System.out.println("Robot walks normally");
    }
}

class NoWalk implements Walkable {

    @Override
    public void walk() {
        System.out.println("This robot cannot walk");
    }
}


// Fly Behaviors

class NormalFly implements Flyable {

    @Override
    public void fly() {
        System.out.println("Robot flies in air");
    }
}

class NoFly implements Flyable {

    @Override
    public void fly() {
        System.out.println("This robot cannot fly");
    }
}


// Projection Behaviors

class NormalProject implements Projectable {

    @Override
    public void project() {
        System.out.println("Robot shows hologram projection");
    }
}

class NoProject implements Projectable {

    @Override
    public void project() {
        System.out.println("This robot cannot project");
    }
}


// Context Class

class Robot {

    private Talkable talkBehavior;
    private Walkable walkBehavior;
    private Flyable flyBehavior;
    private Projectable projectBehavior;

    public Robot(Talkable talkBehavior,
                 Walkable walkBehavior,
                 Flyable flyBehavior,
                 Projectable projectBehavior) {

        this.talkBehavior = talkBehavior;
        this.walkBehavior = walkBehavior;
        this.flyBehavior = flyBehavior;
        this.projectBehavior = projectBehavior;
    }

    public void performTalk() {
        talkBehavior.talk();
    }

    public void performWalk() {
        walkBehavior.walk();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performProject() {
        projectBehavior.project();
    }
}


// Concrete Robots

class CompanionRobot extends Robot {

    public CompanionRobot() {
        super(
            new NormalTalk(),
            new NormalWalk(),
            new NoFly(),
            new NoProject()
        );
    }
}

class SuperRobot extends Robot {

    public SuperRobot() {
        super(
            new NormalTalk(),
            new NormalWalk(),
            new NormalFly(),
            new NormalProject()
        );
    }
}


// Client
public class StrategyDesignPattern {
    public static void main(String[] args) {

        Robot robot1 = new CompanionRobot();

        robot1.performTalk();
        robot1.performWalk();
        robot1.performFly();
        robot1.performProject();

        System.out.println();

        Robot robot2 = new SuperRobot();

        robot2.performTalk();
        robot2.performWalk();
        robot2.performFly();
        robot2.performProject();
    }
}