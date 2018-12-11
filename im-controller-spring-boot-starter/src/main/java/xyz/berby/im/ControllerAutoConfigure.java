package xyz.berby.im;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import xyz.berby.im.entity.ServerConfig;
import xyz.berby.im.service.ServerConfigService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 *
 *
 */

@EnableAutoConfiguration(exclude = ControllerAutoConfigure.class)
public class ControllerAutoConfigure {

    public static void main( String[] args ) {

        new SpringApplication(ControllerAutoConfigure.class).run(args);

    }
}
