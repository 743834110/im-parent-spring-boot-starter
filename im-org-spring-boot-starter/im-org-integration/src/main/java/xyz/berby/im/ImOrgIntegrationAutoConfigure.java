package xyz.berby.im;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;


@EnableAutoConfiguration
@Configuration
public class ImOrgIntegrationAutoConfigure {
    public static void main( String[] args ) {

        new SpringApplication(ImOrgIntegrationAutoConfigure.class).run(args);
    }
}
