package xyz.berby.im;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import xyz.berby.im.util.ApplicationContextHolder;

@Configuration
public class ImCommonAutoConfigure {
    @Autowired
    public ImCommonAutoConfigure(ApplicationContext applicationContext) {
        ApplicationContextHolder contextHolder = new ApplicationContextHolder();
        contextHolder.setApplicationContext(applicationContext);

    }
}
