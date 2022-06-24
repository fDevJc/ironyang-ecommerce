package ironyang.userservice.exception;

public class NotFoundResourceException extends RuntimeException{
    public NotFoundResourceException(String message) {
        super(message);
    }
}
