package solutions.thex.badgify.controller.error;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import solutions.thex.badgify.controller.error.util.ErrorAsJson;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Controller for handling errors.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private final ErrorAsJson errorAsJson;

    @Autowired
    public ErrorController(ErrorAsJson errorAsJson) {
        this.errorAsJson = errorAsJson;
    }

    /**
     * Handles all errors.
     *
     * @param request The request.
     * @return The error response.
     */
    @RequestMapping(value = "/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return errorAsJson.generate(404,//
                        "NOT_FOUND",//
                        "You're desired resource was not found.",//
                        request.getRequestURI());
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return errorAsJson.generate(500,//
                        "INTERNAL_SERVER_ERROR",//
                        "Please contact us and report the issue.",//
                        request.getRequestURI());
            }
        }
        return errorAsJson.generate((status != null) ? Integer.parseInt(status.toString()) : -1,//
                "Something's not ok!",//
                "Please contact us and report the issue.",//
                request.getRequestURI());
    }

}
