package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (ServerConfig)实体类
 *
 * @author makejava
 * @since 2018-11-03 16:43:35
 */
public class ServerConfig implements Serializable {
    private static final long serialVersionUID = 412907255208962965L;
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

    public ServerConfig() {
    }

    public ServerConfig(String mappingKey) {
        this.mappingKey = mappingKey;
    }

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getMappingKey() {
        return mappingKey;
    }

    public void setMappingKey(String mappingKey) {
        this.mappingKey = mappingKey;
    }

    public String getMappingValue() {
        return mappingValue;
    }

    public void setMappingValue(String mappingValue) {
        this.mappingValue = mappingValue;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyPerson() {
        return modifyPerson;
    }

    public void setModifyPerson(String modifyPerson) {
        this.modifyPerson = modifyPerson;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}