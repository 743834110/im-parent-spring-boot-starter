package xyz.berby.im;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import xyz.berby.im.entity.ServerConfig;
import xyz.berby.im.service.ServerConfigService;

import javax.annotation.PostConstruct;
import java.util.List;


/**
 *
 *
 */

//@EnableAutoConfiguration(exclude = ImOrgAutoConfigure.class)
@Configuration
@ComponentScan(value = "xyz.berby.im.aspect")
public class ImOrgAutoConfigure {

    public static void main( String[] args ) {

//        String json = "{\"delete\": [\"a\", \"b\", \"c\", \"d\"]}";
//        JSONObject jsonObject = JSON.parseObject(json);
//        JSONArray array = jsonObject.getJSONArray("delete");
        ApplicationContext context = new AnnotationConfigApplicationContext(ImOrgAutoConfigure.class);
    }
}
