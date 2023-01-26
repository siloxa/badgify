package io.github.shuoros.badgify.web.controller;

import io.github.shuoros.badgify.aop.controller.InterceptIconBadgeController;
import io.github.shuoros.badgify.aop.controller.InterceptLabelBadgeController;
import io.github.shuoros.badgify.aop.controller.InterceptTextBadgeController;
import io.github.shuoros.badgify.domain.model.badge.IconBadge;
import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import io.github.shuoros.badgify.domain.model.badge.TextBadge;
import io.github.shuoros.badgify.domain.model.color.Color;
import io.github.shuoros.badgify.util.ColorEditor;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/badge")
public class BadgeController {

    @Resource
    private ColorEditor colorEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Color.class, colorEditor);
    }

    @GetMapping(path = "/link")
    @InterceptLabelBadgeController
    public ResponseEntity<LabelBadge> linkBadge(LabelBadge badge) throws Exception {
        return ResponseEntity.ok().body(badge);
    }

    @GetMapping(path = "/icon")
    @InterceptIconBadgeController
    public ResponseEntity<IconBadge> iconBadge(IconBadge badge) throws Exception {
        return ResponseEntity.ok().body(badge);
    }

    @GetMapping(path = "/text")
    @InterceptTextBadgeController
    public ResponseEntity<TextBadge> textBadge(TextBadge badge) throws Exception {
        return ResponseEntity.ok().body(badge);
    }
}
