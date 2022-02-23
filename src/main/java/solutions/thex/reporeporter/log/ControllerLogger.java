package solutions.thex.reporeporter.log;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
public class ControllerLogger {

    private final String clazzName;

    public ControllerLogger(Class<?> clazz) {
        this.clazzName = clazz.getSimpleName();
    }

    public void payloadLog(String methodName, HttpServletRequest request, String... payload) {
        log.info("{}.{}: request: {}, ip: {}, user-agent: {} {}",//
                this.clazzName, methodName,//
                request.getRequestURI(),//
                request.getRemoteAddr(),//
                request.getHeader("User-Agent"),//
                Arrays.toString(payload));
    }

}
