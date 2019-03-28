package xyz.berby.im;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import xyz.berby.im.util.ApplicationContextHolder;

/**
 *
 *
 */

@Configuration
@ComponentScan({"xyz.berby.im.aspect", "xyz.berby.im.property"})
@EnableConfigurationProperties
public class ControllerAutoConfigure {

    @Autowired
    public ControllerAutoConfigure(ApplicationContext applicationContext) {
        ApplicationContextHolder contextHolder = new ApplicationContextHolder();
        contextHolder.setApplicationContext(applicationContext);
    }


    public static void main( String[] args ) {

        new SpringApplication(ControllerAutoConfigure.class).run(args);

    }
}
