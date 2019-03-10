package xyz.berby.im.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author  LTF
 * 提供服务器基本
 * Created on 2019/3/10
 */
@Component
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "default.server")
public class DefaultSettingProperty {
    /**
     * 服务器安全管理方式： local | database
     */
    private String securityMode;
    /**
     * 服务器设置存储处
     */
    private Map<String, Object> setting;






}
