package exceptions;

public class activityDetailsNotFound extends RuntimeException {
    public activityDetailsNotFound(Long id) {
        super("Could not find activity detail with id: " + id);
    }
}
