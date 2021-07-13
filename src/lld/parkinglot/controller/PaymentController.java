package lld.parkinglot.controller;

import lld.parkinglot.payment.CashPayment;
import lld.parkinglot.payment.PaymentOption;
import lld.parkinglot.payment.PaymentProvider;
import lld.parkinglot.payment.PaymentStatus;

import java.util.Scanner;

public class PaymentController {
    private PaymentStatus paymentStatus;

    public PaymentController() {
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public void initiatePayment(double amountToBePaid) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose Payment Option:\n1. Online\t\t2. Offline : ");
        int option = scanner.nextInt();
        System.out.println();
        PaymentOption paymentOption = PaymentProvider.getPaymentOption(option);
        if (paymentOption == null) {
            paymentOption = new CashPayment();
        }
        paymentStatus = paymentOption.payAmount(amountToBePaid);
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
