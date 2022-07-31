package solutions.thex.badgify.exception;

public class ServerException extends RuntimeException {

    public ServerException() {
        super("Please Try Again!");
    }

    public ServerException(String message) {
        super(message);
    }

}
