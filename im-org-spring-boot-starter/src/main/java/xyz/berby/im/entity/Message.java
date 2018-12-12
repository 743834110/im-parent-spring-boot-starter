package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 聊天信息表(Message)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    private static final long serialVersionUID = -10726450306645010L;
    /**
     *消息ID
     */
    private String id;
    /**
     *发送者ID
     */
    private String from;
    /**
     *目标ID
     */
    private String to;
    /**
     *命令码类型
     */
    private Double cmd;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *聊天类型
     */
    private Double chatType;
    /**
     *群ID
     */
    private String groupId;
    /**
     *内容
     */
    private String content;
    /**
     *撤回
     */
    private String recall;
    /**
     *未读消息的用户ID
     */
    private String userIds;


}