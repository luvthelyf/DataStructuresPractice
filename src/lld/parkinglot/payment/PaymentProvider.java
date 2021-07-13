package lld.parkinglot.payment;

public class PaymentProvider {

    public static PaymentOption getPaymentOption(int option) {
        if(option == 1) {
            return new OnlinePayment();
        } else if (option == 2) {
            return new CashPayment();
        }
        return null;
    }
}
