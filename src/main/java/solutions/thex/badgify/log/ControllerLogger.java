package solutions.thex.badgify.log;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * A logger class specified for the controller layer.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
public class ControllerLogger {

    private final String clazzName;

    public ControllerLogger(Class<?> clazz) {
        this.clazzName = clazz.getSimpleName();
    }

    /**
     * Log a request and its payload.
     *
     * @param methodName the name of method in the controller.
     * @param request    the request.
     * @param payload    the payload.
     */
    public void payloadLog(String methodName, HttpServletRequest request, String... payload) {
        log.info("{}.{}: request: {}, ip: {}, user-agent: {} {}",//
                this.clazzName, methodName,//
                request.getRequestURI(),//
                request.getRemoteAddr(),//
                request.getHeader("User-Agent"),//
                Arrays.toString(payload));
    }

}
