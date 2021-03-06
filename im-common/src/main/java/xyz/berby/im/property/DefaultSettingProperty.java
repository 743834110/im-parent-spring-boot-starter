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


    public static final String DEFAULT_USER_PASSWORD = "defaultUserPassword";

    public static final String SALT_DIGIT = "saltDigit";

    public static final String PUBLIC_KEY = "publicKey";

    public static final String PRIVATE_KEY = "privateKey";

    public static final String LOGIN_SERVICE_NAME = "loginServiceName";

    public static final String LOGIN_SERVICE_METHOD = "loginServiceMethod";

    public static final String STORAGE_MODE = "storageMode";

    public static final String RESOURCE_PREFIX = "resourcePrefix";

    public static final String STATIC_ACCESS_PATH = "staticAccessPath";

    public static final String UPLOAD_FOLDER = "uploadFolder";


}
