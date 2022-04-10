package solutions.thex.badgify.controller.badge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solutions.thex.badgify.svg.wrapper.badge.inline.InlineIconAsResponseWrapper;
import solutions.thex.badgify.svg.wrapper.badge.inline.InlineLinkAsResponseWrapper;
import solutions.thex.badgify.svg.wrapper.badge.inline.InlineProfileAsResponseWrapper;
import solutions.thex.badgify.svg.wrapper.badge.inline.InlineTitleAsResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Controller for the inline badge requests.
 *
 * @author Soroush Shemshadi
 * @version 1.2.0
 * @since 1.1.0
 */
@RestController
@RequestMapping("/api/badge/inline")
public class InlineBadgeController {

    private final InlineLinkAsResponseWrapper inlineLinkAsResponseWrapper;
    private final InlineIconAsResponseWrapper inlineIconAsResponseWrapper;
    private final InlineTitleAsResponseWrapper inlineTitleAsResponseWrapper;
    private final InlineProfileAsResponseWrapper inlineProfileAsResponseWrapper;

    @Autowired
    public InlineBadgeController(InlineLinkAsResponseWrapper inlineLinkAsResponseWrapper,//
                                 InlineIconAsResponseWrapper inlineIconAsResponseWrapper,//
                                 InlineTitleAsResponseWrapper inlineTitleAsResponseWrapper,//
                                 InlineProfileAsResponseWrapper inlineProfileAsResponseWrapper) {
        this.inlineLinkAsResponseWrapper = inlineLinkAsResponseWrapper;
        this.inlineIconAsResponseWrapper = inlineIconAsResponseWrapper;
        this.inlineTitleAsResponseWrapper = inlineTitleAsResponseWrapper;
        this.inlineProfileAsResponseWrapper = inlineProfileAsResponseWrapper;
    }

    @GetMapping(path = "/link/{design}", produces = "image/svg+xml")
    public ResponseEntity<String> inlineLinkBadge(HttpServletRequest request,//
                                                  @PathVariable(value = "design") String design) throws IOException {
        return inlineLinkAsResponseWrapper.wrap(design);
    }

    @GetMapping(path = "/short/link/{design}", produces = "image/svg+xml")
    public ResponseEntity<String> shortInlineLinkBadge(HttpServletRequest request,//
                                                       @PathVariable(value = "design") String design) throws IOException {
        return inlineLinkAsResponseWrapper.wrapShort(design);
    }

    @GetMapping(path = "/icon/{design}", produces = "image/svg+xml")
    public ResponseEntity<String> inlineIconBadge(HttpServletRequest request,//
                                                  @PathVariable(value = "design") String design) throws IOException {
        return inlineIconAsResponseWrapper.wrap(design);
    }

    @GetMapping(path = "/short/icon/{design}", produces = "image/svg+xml")
    public ResponseEntity<String> shortInlineIconBadge(HttpServletRequest request,//
                                                       @PathVariable(value = "design") String design) throws IOException {
        return inlineIconAsResponseWrapper.wrapShort(design);
    }

    @GetMapping(path = "/title/{design}", produces = "image/svg+xml")
    public ResponseEntity<String> inlineTitleBadge(HttpServletRequest request,//
                                                   @PathVariable(value = "design") String design) throws IOException {
        return inlineTitleAsResponseWrapper.wrap(design);
    }

    @GetMapping(path = "/short/title/{design}", produces = "image/svg+xml")
    public ResponseEntity<String> shortInlineTitleBadge(HttpServletRequest request,//
                                                        @PathVariable(value = "design") String design) throws IOException {
        return inlineTitleAsResponseWrapper.wrapShort(design);
    }

    @GetMapping(path = "/profile/{design}", produces = "image/svg+xml")
    public ResponseEntity<String> inlineProfileBadge(HttpServletRequest request,//
                                                     @PathVariable(value = "design") String design) throws IOException {
        return inlineProfileAsResponseWrapper.wrap(design);
    }

    @GetMapping(path = "/short/profile/{design}", produces = "image/svg+xml")
    public ResponseEntity<String> shortInlineProfileBadge(HttpServletRequest request,//
                                                          @PathVariable(value = "design") String design) throws IOException {
        return inlineProfileAsResponseWrapper.wrapShort(design);
    }

}
