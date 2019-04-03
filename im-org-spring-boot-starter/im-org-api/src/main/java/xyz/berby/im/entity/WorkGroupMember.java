package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 工作群成员表(WorkGroupMember)实体类
 *
 * @author makejava
 * @since 2019-04-01 12:30:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkGroupMember implements Serializable {
    private static final long serialVersionUID = 472496437271988358L;
        private String memberId;
    /**
     *用户ID
     */
    private String userId;
    /**
     *用户账号
     */
    private String userAccount;
    /**
     *群组ID
     */
    private String chatGroupId;
    /**
     *用户名称
     */
    private String userName;
    /**
     *头像地址
     */
    private String memberImageUrl;


}