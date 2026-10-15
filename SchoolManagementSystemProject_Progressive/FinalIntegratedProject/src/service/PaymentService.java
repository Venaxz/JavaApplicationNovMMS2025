package service;
import model.*;
import api.Payable;
import util.AppLogger;
import java.math.BigDecimal;
public class PaymentService {
    public Payment recordPayment(String studentId, BigDecimal amount, PaymentMethod method) {
        if (!Payable.isValidAmount(amount)) throw new IllegalArgumentException("Payment amount must be greater than zero.");
        Payment p = new Payment(studentId, amount, method); AppLogger.info("Payment recorded for student: " + studentId); return p;
    }
}
