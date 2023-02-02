package io.github.shuoros.badgify.aop.controller;

import io.github.shuoros.badgify.domain.model.badge.CounterBadge;
import io.github.shuoros.badgify.domain.model.badge.IconBadge;
import io.github.shuoros.badgify.domain.model.badge.LabelBadge;
import io.github.shuoros.badgify.domain.model.badge.TextBadge;
import io.github.shuoros.badgify.service.badge.*;
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
    private ColorConverterService colorConverterService;

    @Resource
    private LabelBadgeDefaultValueFillerService labelBadgeDefaultValueFillerService;

    @Resource
    private IconBadgeDefaultValueFillerService iconBadgeDefaultValueFillerService;

    @Resource
    private TextBadgeDefaultValueFillerService textBadgeDefaultValueFillerService;

    @Resource
    private CounterBadgeDefaultValueFillerService counterBadgeDefaultValueFillerService;

    @Pointcut("@annotation(io.github.shuoros.badgify.aop.controller.InterceptLabelBadgeController)")
    public void interceptLabelBadgeControllerAnnotation() {}

    @Pointcut("@annotation(io.github.shuoros.badgify.aop.controller.InterceptIconBadgeController)")
    public void interceptIconBadgeControllerAnnotation() {}

    @Pointcut("@annotation(io.github.shuoros.badgify.aop.controller.InterceptTextBadgeController)")
    public void interceptTextBadgeControllerAnnotation() {}

    @Pointcut("@annotation(io.github.shuoros.badgify.aop.controller.InterceptCounterBadgeController)")
    public void interceptCounterBadgeControllerAnnotation() {}

    @Around("interceptLabelBadgeControllerAnnotation()")
    public Object handleLabelBadge(final ProceedingJoinPoint joinPoint) throws Throwable {
        final LabelBadge labelBadge = (LabelBadge) joinPoint.getArgs()[0];
        labelBadgeDefaultValueFillerService.fillInDefaultValues(labelBadge);
        labelBadge.getIcon().resolve(labelBadge.getFontColor());
        return joinPoint.proceed();
    }

    @Around("interceptIconBadgeControllerAnnotation()")
    public Object handleIconBadge(final ProceedingJoinPoint joinPoint) throws Throwable {
        final IconBadge iconBadge = (IconBadge) joinPoint.getArgs()[0];
        iconBadgeDefaultValueFillerService.fillInDefaultValues(iconBadge);
        iconBadge.getIcon().resolve(iconBadge.getFontColor());
        return joinPoint.proceed();
    }

    @Around("interceptTextBadgeControllerAnnotation()")
    public Object handleTextBadge(final ProceedingJoinPoint joinPoint) throws Throwable {
        final TextBadge textBadge = (TextBadge) joinPoint.getArgs()[0];
        textBadgeDefaultValueFillerService.fillInDefaultValues(textBadge);
        return joinPoint.proceed();
    }

    @Around("interceptCounterBadgeControllerAnnotation()")
    public Object handleCounterBadge(final ProceedingJoinPoint joinPoint) throws Throwable {
        final CounterBadge counterBadge = (CounterBadge) joinPoint.getArgs()[0];
        if (counterBadge.getId() == null || (counterBadge.getText() == null && counterBadge.getType() == null)) throw new RuntimeException(
            "id or type is null"
        ); //TODO: I must implement an error handler for badges
        counterBadgeDefaultValueFillerService.fillInDefaultValues(counterBadge);
        counterBadge.getIcon().resolve(colorConverterService.ToRgb(counterBadge.getFontColor()));
        return joinPoint.proceed();
    }
}
