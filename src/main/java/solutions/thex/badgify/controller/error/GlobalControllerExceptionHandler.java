package solutions.thex.badgify.controller.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import solutions.thex.badgify.exception.NotSatisfiedParametersException;
import solutions.thex.badgify.exception.ServerException;
import solutions.thex.badgify.svg.resolver.badge.LTRLinkResolver;

import java.io.IOException;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private final LTRLinkResolver ltrLinkResolver;

    @Autowired
    public GlobalControllerExceptionHandler(LTRLinkResolver ltrLinkResolver) {
        this.ltrLinkResolver = ltrLinkResolver;
    }

    @ExceptionHandler(NotSatisfiedParametersException.class)
    public ResponseEntity<String> handleNotSatisfiedParametersException(NotSatisfiedParametersException ex) throws IOException {
        return new ResponseEntity<>(//
                ltrLinkResolver.resolve(Map.of(//
                        "theme", "simple",//
                        "size", "m",//
                        "direction", "ltr",//
                        "link", "#",//
                        "title", "422: " + ex.getMessage(),//
                        "icon", "triangle-exclamation",//
                        "bg", "c4160a",//
                        "color", "rgb(255, 255, 255)")),//
                HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<String> handleServerException(ServerException ex) throws IOException {
        return new ResponseEntity<>(//
                ltrLinkResolver.resolve(Map.of(//
                        "theme", "simple",//
                        "size", "m",//
                        "direction", "ltr",//
                        "link", "#",//
                        "title", "503: " + ex.getMessage(),//
                        "icon", "triangle-exclamation",//
                        "bg", "c4160a",//
                        "color", "rgb(255, 255, 255)")),//
                HttpStatus.SERVICE_UNAVAILABLE);
    }

}
