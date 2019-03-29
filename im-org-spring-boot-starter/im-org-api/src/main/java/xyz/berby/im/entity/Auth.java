package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.*;

/**
 * 操作权限表(Auth)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:30:58
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auth extends AbstractAuth implements Serializable {
    private static final long serialVersionUID = 377881601925341070L;
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
    /**
     *是否为叶子节点
     */
    private String leaf;
    /**
     *是否可用
     */
    private String available;


}