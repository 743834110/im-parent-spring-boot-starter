package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (ServerConfig)实体类
 *
 * @author makejava
 * @since 2018-12-09 11:05:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ServerConfig implements Serializable {
    private static final long serialVersionUID = 240139665786080851L;
    //配置ID
    private String configId;
    //配置key
    private String mappingKey;
    //配置value
    private String mappingValue;
    
    private String createPerson;
    
    private Date createTime;
    
    private String modifyPerson;
    
    private Date modifyTime;

    public ServerConfig(String mappingKey) {
        this.mappingKey = mappingKey;
    }
}