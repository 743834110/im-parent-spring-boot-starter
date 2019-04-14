package xyz.berby.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import xyz.berby.im.filter.CrossOriginsFilter;

/**
 *
 *
 */

@Configuration
@ComponentScan({
        "xyz.berby.im.aspect",
        "xyz.berby.im.property",
        "xyz.berby.im.filter",
        "xyz.berby.im.config"
})
@EnableConfigurationProperties
public class ControllerAutoConfigure {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(CrossOriginsFilter crossOriginsFilter) {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(crossOriginsFilter);
        registration.addUrlPatterns("/*");
        registration.setName("crossOriginsFilter");
        registration.setOrder(1);
        return registration;
    }


    public static void main( String[] args ) {

        new SpringApplication(ControllerAutoConfigure.class).run(args);

    }
}
