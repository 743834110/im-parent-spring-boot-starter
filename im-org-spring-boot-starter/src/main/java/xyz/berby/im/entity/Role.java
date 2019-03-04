package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 角色表： role_type用于区分班学生社团和机构的角色(Role)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:31:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractRole implements Serializable {
    private static final long serialVersionUID = 975103770812392833L;
        private String roleId;
    /**
     *角色名称
     */
    private String roleName;
    /**
     *角色描述
     */
    private String roleDescription;
    /**
     *角色类型
     */
    private String roleType;
    /**
     *角色数量
     */
    private Double roleNumber;
    /**
     *创建用户编号
     */
    private String userId;
    /**
     *创建组织编号
     */
    private String orgId;


}