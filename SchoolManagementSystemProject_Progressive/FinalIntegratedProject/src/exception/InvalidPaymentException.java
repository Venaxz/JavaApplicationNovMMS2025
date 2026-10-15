package exception;
public class InvalidPaymentException extends IllegalArgumentException {
    public InvalidPaymentException(String message) { super(message); }
}
