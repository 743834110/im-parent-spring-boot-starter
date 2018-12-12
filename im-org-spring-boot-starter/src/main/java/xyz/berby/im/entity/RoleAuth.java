package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 角色权限表(RoleAuth)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleAuth implements Serializable {
    private static final long serialVersionUID = 352321509799368923L;
        private String roleAuthId;
    /**
     *角色ID
     */
    private String roleId;
    /**
     *权限ID
     */
    private String authId;


}