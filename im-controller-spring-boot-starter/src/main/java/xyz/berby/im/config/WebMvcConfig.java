package xyz.berby.im.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import xyz.berby.im.property.DefaultSettingProperty;
import java.util.Map;

/**
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private Map<String, Object> setting;

    @Autowired
    public WebMvcConfig(DefaultSettingProperty property) {
        this.setting = property.getSetting();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String staticAccessPath = (String) setting.get(DefaultSettingProperty.STATIC_ACCESS_PATH);
        String uploadFolder = (String) setting.get(DefaultSettingProperty.UPLOAD_FOLDER);
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder + "/");
    }

}
