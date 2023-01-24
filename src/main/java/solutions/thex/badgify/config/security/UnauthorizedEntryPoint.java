package solutions.thex.badgify.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * An entry point before unauthorized requests. It will log the requested URI, remote ip address and return a 401 error.
 *
 * @author Soroush Shemshadi
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
@Slf4j
public final class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        log.warn("UnauthorizedEntryPoint.commence: " //
                + "path= " + request.getRequestURI()//
                + ", ip= " + request.getRemoteAddr()//
                + ", user agent= " + request.getHeader("User-Agent"));
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

}
