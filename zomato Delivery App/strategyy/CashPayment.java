package strategyy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        // Code to process cash payment
        System.out.println("Processing cash payment of " + amount);
    }
}