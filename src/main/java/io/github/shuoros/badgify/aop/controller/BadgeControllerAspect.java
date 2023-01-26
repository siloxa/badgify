package io.github.shuoros.badgify.aop.controller;

import io.github.shuoros.badgify.domain.model.badge.IconBadge;
import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import io.github.shuoros.badgify.domain.model.badge.TextBadge;
import io.github.shuoros.badgify.service.badge.IconBadgeDefaultValueFillerService;
import io.github.shuoros.badgify.service.badge.LabelBadgeDefaultValueFillerService;
import io.github.shuoros.badgify.service.badge.TextBadgeDefaultValueFillerService;
import javax.annotation.Resource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BadgeControllerAspect {

    @Resource
    private LabelBadgeDefaultValueFillerService labelBadgeDefaultValueFillerService;

    @Resource
    private IconBadgeDefaultValueFillerService iconBadgeDefaultValueFillerService;

    @Resource
    private TextBadgeDefaultValueFillerService textBadgeDefaultValueFillerService;

    @Pointcut("@annotation(io.github.shuoros.badgify.aop.controller.InterceptLabelBadgeController)")
    public void interceptLabelBadgeControllerAnnotation() {}

    @Pointcut("@annotation(io.github.shuoros.badgify.aop.controller.InterceptIconBadgeController)")
    public void interceptIconBadgeControllerAnnotation() {}

    @Pointcut("@annotation(io.github.shuoros.badgify.aop.controller.InterceptLabelTextController)")
    public void interceptTextBadgeControllerAnnotation() {}

    @Around("interceptLabelBadgeControllerAnnotation()")
    public Object handleLabelBadge(final ProceedingJoinPoint joinPoint) throws Throwable {
        final LabelBadge labelBadge = (LabelBadge) joinPoint.getArgs()[0];
        labelBadgeDefaultValueFillerService.fillInDefaultValues(labelBadge);
        return joinPoint.proceed();
    }

    @Around("interceptIconBadgeControllerAnnotation()")
    public Object handleIconBadge(final ProceedingJoinPoint joinPoint) throws Throwable {
        final IconBadge iconBadge = (IconBadge) joinPoint.getArgs()[0];
        iconBadgeDefaultValueFillerService.fillInDefaultValues(iconBadge);
        return joinPoint.proceed();
    }

    @Around("interceptTextBadgeControllerAnnotation()")
    public Object handleTextBadge(final ProceedingJoinPoint joinPoint) throws Throwable {
        final TextBadge textBadge = (TextBadge) joinPoint.getArgs()[0];
        textBadgeDefaultValueFillerService.fillInDefaultValues(textBadge);
        return joinPoint.proceed();
    }
}
