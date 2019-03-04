package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 部门表 org_type: 社团 机构 班级 pro_type 专业类型(Organization)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:31:11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organization implements Serializable {
    private static final long serialVersionUID = 808579266282727109L;
        private String orgId;
    /**
     *父级节点ID
     */
    private String parentId;
    /**
     *组织类型
     */
    private String orgType;
    /**
     *专业类型
     */
    private String proType;
    /**
     *组织描述
     */
    private String orgDescription;
    /**
     *组织名称
     */
    private String orgName;
    /**
     *组织头像地址
     */
    private String orgImageUrl;
    /**
     *组织公告
     */
    private String orgAnnounce;
    /**
     *是否有效
     */
    private String valid;
    /**
     *用户ID
     */
    private String userId;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *年级
     */
    private String grade;
        private String shortName;
        private String associateType;


}