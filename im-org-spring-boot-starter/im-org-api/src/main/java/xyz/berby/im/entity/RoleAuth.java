package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 角色权限表(RoleAuth)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:31:13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleAuth implements Serializable {
    private static final long serialVersionUID = 394322417347233313L;
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