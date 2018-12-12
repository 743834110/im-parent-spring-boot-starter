package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 工作群表(ChatGroup)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatGroup implements Serializable {
    private static final long serialVersionUID = 981253950508680438L;
        private String chatGroupId;
    /**
     *创建组织ID
     */
    private String orgId;
    /**
     *创建ID
     */
    private String userId;
    /**
     *群组名称
     */
    private String chatGroupName;


}