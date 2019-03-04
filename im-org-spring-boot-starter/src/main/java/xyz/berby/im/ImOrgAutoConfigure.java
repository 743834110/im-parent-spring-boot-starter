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
@ComponentScan(value = "xyz.berby.im.aspect")
public class ImOrgAutoConfigure {

    public static void main( String[] args ) {

//        String json = "{\"delete\": [\"a\", \"b\", \"c\", \"d\"]}";
//        JSONObject jsonObject = JSON.parseObject(json);
//        JSONArray array = jsonObject.getJSONArray("delete");
        new SpringApplication(ImOrgAutoConfigure.class).run(args);
    }
}
