package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 用户部门（班级）表(UserOrg)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:31:18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOrg implements Serializable {
    private static final long serialVersionUID = 878586453396589358L;
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
    private String roleId;
    /**
     *父组织ID
     */
    private String parentOrgId;
    /**
     *组织类型
     */
    private String orgType;
    /**
     *年级（在org_type为class类型是不能为空）
     */
    private String grade;
    /**
     *组织名称
     */
    private String orgName;
    /**
     *用户图像url
     */
    private String userImageUrl;
    /**
     *组织简称
     */
    private String shortName;


}