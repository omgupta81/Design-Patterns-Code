package strategyy;

public class UpiPayment implements PaymentStrategy {
   private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
      
    }

    @Override
    public void pay(int amount) {
        // Code to process UPI payment
        System.out.println("Processing UPI payment of " + amount + " with UPI ID: " + upiId);
    }
}
