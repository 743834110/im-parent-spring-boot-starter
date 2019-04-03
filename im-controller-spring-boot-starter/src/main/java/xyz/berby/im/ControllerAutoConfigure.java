package xyz.berby.im;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import xyz.berby.im.filter.CrossOriginsFilter;
import xyz.berby.im.util.ApplicationContextHolder;

/**
 *
 *
 */

@Configuration
@ComponentScan({"xyz.berby.im.aspect", "xyz.berby.im.property", "xyz.berby.im.filter"})
@EnableConfigurationProperties
public class ControllerAutoConfigure {

    @Autowired
    public ControllerAutoConfigure(ApplicationContext applicationContext) {
        ApplicationContextHolder contextHolder = new ApplicationContextHolder();
        contextHolder.setApplicationContext(applicationContext);
    }

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
