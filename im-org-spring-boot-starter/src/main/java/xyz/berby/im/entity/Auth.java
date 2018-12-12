package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 操作权限表(Auth)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auth implements Serializable {
    private static final long serialVersionUID = -96143373525853332L;
    /**
     *权限ID
     */
    private String authId;
        private String authName;
    /**
     *权限URL(移动端特指页面)
     */
    private String authUrl;
    /**
     *父级节点
     */
    private String parentId;
    /**
     *权限类型
     */
    private String authType;
    /**
     *服务端的API服务权限
     */
    private String apiUrl;


}