package org.tym.blinking.norwaylife.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by tangtomorrow on 2017/2/21.
 */
@Configuration
@ComponentScan(basePackages = {"org.tym.blinking.norwaylife"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)}
)
public class RootConfig {
}
