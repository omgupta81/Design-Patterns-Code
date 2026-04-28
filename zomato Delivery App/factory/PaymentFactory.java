package factory;

import strategyy.CashPayment;
import strategyy.CreditCardPayment;
import strategyy.NetBankingPayment;
import strategyy.PaymentStrategy;
import strategyy.UpiPayment;

public class PaymentFactory {
    public static PaymentStrategy getPaymentMethod(String type) {
        switch (type.toLowerCase()) {
            case "creditcard":
                return new CreditCardPayment("1234-5678-9012-3456", "John Doe");
            case "netbanking":
                return new NetBankingPayment("HDFC Bank");  
            case "upi":
                return new UpiPayment("john.doe@upi");
            case "cash":
                return new CashPayment();
            default:
                throw new IllegalArgumentException("Invalid payment type: " + type);
        }
    }
}
