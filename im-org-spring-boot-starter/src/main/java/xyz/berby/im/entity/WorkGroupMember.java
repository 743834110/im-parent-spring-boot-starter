package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 工作群成员表(WorkGroupMember)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkGroupMember implements Serializable {
    private static final long serialVersionUID = -43149220817416840L;
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


}