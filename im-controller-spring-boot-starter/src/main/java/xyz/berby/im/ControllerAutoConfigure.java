package xyz.berby.im;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import xyz.berby.im.util.ApplicationContextHolder;

/**
 *
 *
 */

@EnableAutoConfiguration(exclude = ControllerAutoConfigure.class)
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
