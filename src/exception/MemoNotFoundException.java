package exception;

public class MemoNotFoundException extends RuntimeException {
    public MemoNotFoundException() {

    }

    public MemoNotFoundException(String message) {
        super(message);
    }
}
