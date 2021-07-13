package lld.parkinglot.payment;

import lld.parkinglot.payment.PaymentOption;
import lld.parkinglot.payment.PaymentStatus;

public class OnlinePayment implements PaymentOption {
    @Override
    public PaymentStatus payAmount(double amountToBePaid) {
        System.out.println("paid amount "+amountToBePaid);
        return PaymentStatus.SUCCESS;
    }
}
