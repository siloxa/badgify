package io.github.shuoros.badgify.config;

import io.github.shuoros.badgify.util.convrter.RequestParamStringToSizeConverter;
import io.github.shuoros.badgify.util.convrter.RequestParamStringToSocialBadgeConverter;
import io.github.shuoros.badgify.util.convrter.RequestParamStringToThemeConverter;
import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Resource
    private RequestParamStringToSocialBadgeConverter requestParamStringToSocialBadgeConverter;

    @Resource
    private RequestParamStringToSizeConverter requestParamStringToSizeConverter;

    @Resource
    private RequestParamStringToThemeConverter requestParamStringToThemeConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(requestParamStringToSocialBadgeConverter);
        registry.addConverter(requestParamStringToSizeConverter);
        registry.addConverter(requestParamStringToThemeConverter);
    }
}
