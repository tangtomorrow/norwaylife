package org.tym.blinking.norwaylife.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by tangtomorrow on 2017/2/21.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.tym.blinking.norwaylife.web"})
public class WebConfig extends WebMvcConfigurerAdapter {

    //配置静态资源的处理，要求DispatchServlet对静态资源的请求转发到servlet容器中默认的Servlet上
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
