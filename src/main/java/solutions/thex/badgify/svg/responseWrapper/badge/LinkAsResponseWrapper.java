package solutions.thex.badgify.svg.responseWrapper.badge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import solutions.thex.badgify.controller.error.util.ErrorAsBadge;
import solutions.thex.badgify.svg.SvgAsResponseWrapper;
import solutions.thex.badgify.svg.resolver.badge.LTRLinkResolver;
import solutions.thex.badgify.svg.resolver.badge.RTLLinkResolver;

import java.io.IOException;
import java.util.Map;

/**
 * An implementation of {@link SvgAsResponseWrapper} which wrap up generated
 * link badge SVG as a response.
 *
 * @author Soroush Shemshadi
 * @version 1.2.0
 * @since 1.0.0
 */
@Service
public class LinkAsResponseWrapper implements SvgAsResponseWrapper {

    private final LTRLinkResolver ltrLinkResolver;
    private final RTLLinkResolver rtlLinkResolver;
    private final ErrorAsBadge errorAsBadge;

    @Autowired
    public LinkAsResponseWrapper(@Qualifier("LTRLinkResolver") LTRLinkResolver ltrLinkResolver,//
                                 RTLLinkResolver rtlLinkResolver,//
                                 ErrorAsBadge errorAsBadge) {
        this.ltrLinkResolver = ltrLinkResolver;
        this.rtlLinkResolver = rtlLinkResolver;
        this.errorAsBadge = errorAsBadge;
    }

    public ResponseEntity<String> wrap(Map<String, String> params) throws IOException {
        if ("-1".equals(params.get("title")) || "-1".equals(params.get("icon")))
            return new ResponseEntity<>(//
                    errorAsBadge.generate(422, "Title or icon not provided!"),//
                    HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(//
                "ltr".equals(params.get("direction")) ?//
                        ltrLinkResolver.resolve(params) ://
                        rtlLinkResolver.resolve(params)//
                , HttpStatus.OK);
    }

}
