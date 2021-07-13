package lld.parkinglot.payment;

import lld.parkinglot.payment.PaymentStatus;

public interface PaymentOption {
    PaymentStatus payAmount(double amountToBePaid);
}
