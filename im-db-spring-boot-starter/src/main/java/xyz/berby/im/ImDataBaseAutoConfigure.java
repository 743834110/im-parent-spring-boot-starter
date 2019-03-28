package xyz.berby.im;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.*;

//@EnableAutoConfiguration(exclude = ImDataBaseAutoConfigure.class)
//@Configuration
@ComponentScan(value = {"xyz.berby.im.controller", "xyz.berby.im.service"})

@MapperScan("xyz.berby.im.dao")
@AutoConfigureBefore
public class ImDataBaseAutoConfigure {
    

    public static void main(String [] args) {
        new AnnotationConfigApplicationContext(ImDataBaseAutoConfigure.class);
    }
}
