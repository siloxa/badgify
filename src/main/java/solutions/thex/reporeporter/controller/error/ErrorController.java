package solutions.thex.reporeporter.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import solutions.thex.reporeporter.log.ControllerLogger;

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

    private final ControllerLogger logger = new ControllerLogger(this.getClass());

    /**
     * Handles all errors.
     *
     * @param request The request.
     * @return The error response.
     */
    @RequestMapping(value = "/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        logger.payloadLog("handleError", request);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return new ErrorAsJson(404,//
                        "NOT_FOUND",//
                        "You're desired resource was not found.",//
                        request.getRequestURI()).toString();
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return new ErrorAsJson(500,//
                        "INTERNAL_SERVER_ERROR",//
                        "Please contact us and report the issue.",//
                        request.getRequestURI()).toString();
            }
        }
        return new ErrorAsJson((status != null) ? Integer.parseInt(status.toString()) : -1,//
                "Something's not ok!",//
                "Please contact us and report the issue.",//
                request.getRequestURI()).toString();
    }

}
