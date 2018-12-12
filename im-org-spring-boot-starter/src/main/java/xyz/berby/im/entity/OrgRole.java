package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 组织角色表(OrgRole)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrgRole implements Serializable {
    private static final long serialVersionUID = -14524094629773244L;
        private String orgRoleId;
    /**
     *组织ID
     */
    private String orgId;
    /**
     *部门角色数量
     */
    private Double orgRoleNumbers;
    /**
     *角色ID
     */
    private String roleId;
    /**
     *角色名称
     */
    private String roleName;


}