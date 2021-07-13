package lld.parkinglot.payment;

import lld.parkinglot.payment.PaymentOption;
import lld.parkinglot.payment.PaymentStatus;

public class CashPayment implements PaymentOption {
    @Override
    public PaymentStatus payAmount(double amountToBePaid) {
        return PaymentStatus.SUCCESS;
    }
}
