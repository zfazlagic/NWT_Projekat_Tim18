package exceptions;

public class activityNotFound extends RuntimeException {
    public activityNotFound(Long id) {
        super("Could not find activity with id: " + id);
    }
}
