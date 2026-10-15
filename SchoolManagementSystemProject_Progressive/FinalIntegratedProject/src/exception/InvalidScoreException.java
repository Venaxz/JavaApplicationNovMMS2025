package exception;
public class InvalidScoreException extends IllegalArgumentException {
    public InvalidScoreException(double score) { super("Score must be between 0 and 100. Received: " + score); }
}
