package strategyy;


public class CreditCardPayment implements PaymentStrategy {
   private String cardNumber;
   private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        
    }
    @Override
    public void pay(int amount) {
        // Code to process credit card payment
        System.out.println("Processing credit card payment of " + amount + " with Card Number: " + cardNumber + " and Card Holder Name: " + cardHolderName);
    }
}