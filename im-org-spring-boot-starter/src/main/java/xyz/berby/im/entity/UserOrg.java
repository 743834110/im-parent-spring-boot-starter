package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 用户部门（班级）表(UserOrg)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOrg implements Serializable {
    private static final long serialVersionUID = 897626581740266459L;
        private String userOrgId;
    /**
     *用户ID
     */
    private String userId;
    /**
     *组织ID
     */
    private String orgId;
    /**
     *用户名称
     */
    private String userName;
    /**
     *部门角色ID
     */
    private String orgRoleId;


}