package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * (Discussion)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:31:06
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discussion implements Serializable {
    private static final long serialVersionUID = 257852369666453879L;
        private String discussionId;
    /**
     *评论内容
     */
    private String content;
    /**
     *父节点ID
     */
    private String parentId;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *日常活动ID
     */
    private String routineId;
        private String userId;
    /**
     *发布者ID
     */
    private String routineUserId;


}