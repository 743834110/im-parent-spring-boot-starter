package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 用户部门角色表(UserOrgRole)实体类
 *
 * @author makejava
 * @since 2019-03-10 19:16:24
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOrgRole implements Serializable {
    private static final long serialVersionUID = -98139056997799168L;
        private String userOrgRoleId;
    /**
     *部门编号
     */
    private String orgId;
    /**
     *角色编号
     */
    private String roleId;
    /**
     *角色名称
     */
    private String roleName;
    /**
     *部门名称
     */
    private String orgName;


}