package model;
import api.Printable;
import java.math.BigDecimal;
import java.time.LocalDate;
public class Payment implements Printable, java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private final String studentId;
    private final BigDecimal amount;
    private final PaymentMethod method;
    private final LocalDate date;
    public Payment(String studentId, BigDecimal amount, PaymentMethod method) {
        if (studentId == null || studentId.isBlank()) throw new IllegalArgumentException("Student ID is required.");
        if (amount == null || amount.signum() <= 0) throw new IllegalArgumentException("Payment amount must be greater than zero.");
        this.studentId=studentId; this.amount=amount; this.method=java.util.Objects.requireNonNull(method); this.date=LocalDate.now();
    }
    @Override public String printableSummary() { return toString(); }
    @Override public String toString() { return "Payment{studentId='"+studentId+"', amount="+amount+", method="+method+", date="+date+"}"; }
}
