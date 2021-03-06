package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 工作群表(ChatGroup)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:31:03
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatGroup implements Serializable {
    private static final long serialVersionUID = -82124317759365546L;
        private String groupId;
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
    private String name;
        private String avatar;


}