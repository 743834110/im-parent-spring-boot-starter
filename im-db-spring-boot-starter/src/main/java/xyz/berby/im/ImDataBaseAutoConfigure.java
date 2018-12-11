package xyz.berby.im;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import xyz.berby.im.util.ApplicationContextHolder;

import javax.annotation.PostConstruct;

//@EnableAutoConfiguration(exclude = ImDataBaseAutoConfigure.class)
@Configuration
//@PropertySource("classpath:application.properties")
@ComponentScan(value = {"xyz.berby.im.controller", "xyz.berby.im.service"})

@MapperScan("xyz.berby.im.dao")
@AutoConfigureBefore
public class ImDataBaseAutoConfigure {

    @Autowired
    public ImDataBaseAutoConfigure(ApplicationContext applicationContext) {
        ApplicationContextHolder contextHolder = new ApplicationContextHolder();
        contextHolder.setApplicationContext(applicationContext);
    }

    public static void main(String [] args) {
        new AnnotationConfigApplicationContext(ImDataBaseAutoConfigure.class);
    }
}
