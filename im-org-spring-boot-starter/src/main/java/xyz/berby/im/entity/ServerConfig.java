package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 服务器配置表(ServerConfig)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerConfig implements Serializable {
    private static final long serialVersionUID = -53733490302619222L;
        private String configId;
    /**
     *键名
     */
    private String mappingKey;
    /**
     *键值
     */
    private String mappingValue;

    public ServerConfig(String mappingKey) {
        this.mappingKey = mappingKey;
    }
}