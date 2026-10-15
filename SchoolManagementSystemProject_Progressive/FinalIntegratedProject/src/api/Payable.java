package api;
import java.math.BigDecimal;
public interface Payable {
    BigDecimal calculatePayment();
    default boolean isPaymentPositive() { return calculatePayment().signum() > 0; }
    static boolean isValidAmount(BigDecimal amount) { return amount != null && amount.signum() > 0; }
}
