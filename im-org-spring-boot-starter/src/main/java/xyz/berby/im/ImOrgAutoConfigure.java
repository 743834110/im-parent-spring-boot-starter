package xyz.berby.im;


import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import xyz.berby.im.entity.ServerConfig;
import xyz.berby.im.service.ServerConfigService;
import xyz.berby.im.vo.Pager;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


/**
 *
 *
 */

//@EnableAutoConfiguration(exclude = ImOrgAutoConfigure.class)
@Configuration
public class ImOrgAutoConfigure {

    public static void main( String[] args ) {

//        String json = "{\"delete\": [\"a\", \"b\", \"c\", \"d\"]}";
//        JSONObject jsonObject = JSON.parseObject(json);
//        JSONArray array = jsonObject.getJSONArray("delete");

        ApplicationContext context = new AnnotationConfigApplicationContext(ImOrgAutoConfigure.class);

    }
}
