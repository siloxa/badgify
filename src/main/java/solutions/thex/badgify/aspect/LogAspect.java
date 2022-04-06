package solutions.thex.badgify.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Before(value = "execution(* solutions.thex.badgify.controller..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        AtomicReference<String> payload = new AtomicReference<>("");
        Arrays.stream(joinPoint.getArgs()).filter(arg -> arg instanceof String).forEach(arg -> {
            payload.updateAndGet(v -> v + ", " + arg);
        });
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];

        log.info("{}: request: {}, ip: {}, user-agent: {}, params: {}",//
                joinPoint.toShortString(),//
                request.getRequestURI(),//
                request.getRemoteAddr(),//
                request.getHeader("User-Agent"),//
                payload.get());
    }

}
