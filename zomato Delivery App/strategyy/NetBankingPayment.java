package strategyy;


public class NetBankingPayment implements PaymentStrategy {
   private String bankName;
   

    public NetBankingPayment(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public void pay(int amount) {
        // Code to process net banking payment
        System.out.println("Processing net banking payment of " + amount + " with Bank Name: " + bankName);
    }
}

