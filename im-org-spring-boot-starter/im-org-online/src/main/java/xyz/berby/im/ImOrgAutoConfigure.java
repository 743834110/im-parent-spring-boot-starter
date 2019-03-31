package xyz.berby.im;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 *
 *
 */

@EnableAutoConfiguration(exclude = ImOrgAutoConfigure.class)
@Configuration
@ComponentScan("xyz.berby.im.property")
public class ImOrgAutoConfigure {

    public static void main( String[] args ) {

        new SpringApplication(ImOrgAutoConfigure.class).run(args);
    }
}
