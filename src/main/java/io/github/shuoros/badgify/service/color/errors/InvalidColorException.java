package io.github.shuoros.badgify.service.color.errors;

import io.github.shuoros.badgify.web.rest.errors.ErrorConstants;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class InvalidColorException extends AbstractThrowableProblem {

    public InvalidColorException() {
        super(null, "Incorrect Color", Status.BAD_REQUEST);
    }
}
