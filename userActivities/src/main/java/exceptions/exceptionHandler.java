package exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class exceptionHandler {
    @ResponseBody
    @ExceptionHandler(activityNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(activityNotFound ex) {
        return ex.getMessage();
    }
}

