package io.github.shuoros.badgify.web.controller;

import io.github.shuoros.badgify.aop.controller.InterceptCounterBadgeController;
import io.github.shuoros.badgify.aop.controller.InterceptIconBadgeController;
import io.github.shuoros.badgify.aop.controller.InterceptLabelBadgeController;
import io.github.shuoros.badgify.aop.controller.InterceptTextBadgeController;
import io.github.shuoros.badgify.domain.enumeration.CounterBadgeType;
import io.github.shuoros.badgify.domain.enumeration.Size;
import io.github.shuoros.badgify.domain.enumeration.SocialBadge;
import io.github.shuoros.badgify.domain.enumeration.Theme;
import io.github.shuoros.badgify.domain.model.badge.CounterBadge;
import io.github.shuoros.badgify.domain.model.badge.IconBadge;
import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import io.github.shuoros.badgify.domain.model.badge.TextBadge;
import io.github.shuoros.badgify.domain.model.color.AbstractColor;
import io.github.shuoros.badgify.domain.model.icon.AbstractIcon;
import io.github.shuoros.badgify.domain.model.icon.FontAwesomeIcon;
import io.github.shuoros.badgify.service.badge.BadgeService;
import io.github.shuoros.badgify.util.editor.CaseInsensitiveEnumEditor;
import io.github.shuoros.badgify.util.editor.ColorEditor;
import io.github.shuoros.badgify.util.editor.IconEditor;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/badge")
public class BadgeController {

    @Resource
    private ColorEditor colorEditor;

    @Resource
    private IconEditor iconEditor;

    @Resource(name = "theme-enum-editor")
    private CaseInsensitiveEnumEditor themeCaseInsensitiveEnumEditor;

    @Resource(name = "size-enum-editor")
    private CaseInsensitiveEnumEditor sizeCaseInsensitiveEnumEditor;

    @Resource(name = "counterBadgeType-enum-editor")
    private CaseInsensitiveEnumEditor counterBadgeTypeCaseInsensitiveEnumEditor;

    @Resource
    private BadgeService badgeService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(AbstractColor.class, colorEditor);
        binder.registerCustomEditor(AbstractIcon.class, iconEditor);
        binder.registerCustomEditor(Theme.class, themeCaseInsensitiveEnumEditor);
        binder.registerCustomEditor(Size.class, sizeCaseInsensitiveEnumEditor);
        binder.registerCustomEditor(CounterBadgeType.class, counterBadgeTypeCaseInsensitiveEnumEditor);
    }

    /**
     * http://localhost:8080/api/badge/{id}
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/{id}", produces = "image/svg+xml")
    public ResponseEntity<String> persistedBadge(@PathVariable("id") UUID id) throws Exception {
        return ResponseEntity.ok().body(badgeService.generatePersistedBadge(id));
    }

    /**
     * http://localhost:8080/api/badge/label?text=Badgify&fontColor=lavender&size=l&theme=edge
     *
     * @param labelBadge
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/label", produces = "image/svg+xml")
    @InterceptLabelBadgeController
    public ResponseEntity<String> labelBadge(LabelBadge labelBadge) throws Exception {
        return ResponseEntity.ok().body(badgeService.generateBadge(labelBadge));
    }

    /**
     * http://localhost:8080/api/badge/icon?icon=linkedin&fontColor=lavender&size=l&theme=edge
     *
     * @param iconBadge
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/icon", produces = "image/svg+xml")
    @InterceptIconBadgeController
    public ResponseEntity<String> iconBadge(IconBadge iconBadge) throws Exception {
        return ResponseEntity.ok().body(badgeService.generateBadge(iconBadge));
    }

    /**
     * http://localhost:8080/api/badge/text?text=Badgify&fontColor=lavender&size=l&theme=edge
     *
     * @param textBadge
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/text", produces = "image/svg+xml")
    @InterceptTextBadgeController
    public ResponseEntity<String> textBadge(TextBadge textBadge) throws Exception {
        return ResponseEntity.ok().body(badgeService.generateBadge(textBadge));
    }

    /**
     * http://localhost:8080/api/badge/counter?id=shuoros&type=profile
     *
     * @param counterBadge
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/counter", produces = "image/svg+xml")
    @InterceptCounterBadgeController
    public ResponseEntity<String> counterBadge(CounterBadge counterBadge) throws Exception {
        return ResponseEntity.ok().body(badgeService.generateCounterBadge(counterBadge));
    }

    /**
     *
     * @param socialBadge
     * @param id
     * @param theme
     * @param size
     * @param link
     * @return
     * @throws Exception
     */
    @GetMapping(path = "/{social}/{id}", produces = "image/svg+xml")
    public ResponseEntity<String> socialBadge(
        @PathVariable("social") SocialBadge socialBadge,
        @PathVariable("id") String id,
        @RequestParam(value = "theme", required = false, defaultValue = "simple") Theme theme,
        @RequestParam(value = "size", required = false, defaultValue = "s") Size size,
        @RequestParam(value = "link", required = false, defaultValue = "#") String link
    ) throws Exception {
        return ResponseEntity
            .ok()
            .body(
                badgeService.generateSocialBadge(
                    LabelBadge
                        .builder()
                        .theme(theme)
                        .size(size)
                        .backgroundColor(socialBadge.getBackgroundColor())
                        .fontColor(socialBadge.getFontColor())
                        .link(("#".equals(link)) ? socialBadge.getLink() + id : link)
                        .text(id)
                        .icon(FontAwesomeIcon.builder().name(socialBadge.getIcon()).build())
                        .build()
                )
            );
    }
}
