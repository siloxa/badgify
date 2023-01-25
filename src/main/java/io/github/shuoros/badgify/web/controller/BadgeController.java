package io.github.shuoros.badgify.web.controller;

import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/badge")
public class BadgeController {

    @GetMapping(path = "/link")
    public ResponseEntity<LabelBadge> linkBadge(HttpServletRequest request, LabelBadge labelBadge) throws Exception {
        return ResponseEntity.ok().body(labelBadge);
    }
}
