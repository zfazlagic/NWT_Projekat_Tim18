package exceptions;

public class activityNotFound extends RuntimeException {
    public activityNotFound(Long id) {
        super("Could NOT find activity with id: " + id);
    }
}
