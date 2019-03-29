package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 服务器配置表(ServerConfig)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:31:15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerConfig implements Serializable {
    private static final long serialVersionUID = 275812333109648042L;
        private String configId;
    /**
     *配置key
     */
    private String mappingKey;
    /**
     *配置value
     */
    private String mappingValue;


    public ServerConfig(String mappingKey) {
        this.mappingKey = mappingKey;
    }
}