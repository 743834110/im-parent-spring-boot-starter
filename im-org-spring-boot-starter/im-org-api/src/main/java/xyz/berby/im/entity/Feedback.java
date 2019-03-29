package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * (Feedback)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:31:07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feedback implements Serializable {
    private static final long serialVersionUID = -48214677205999854L;
        private String feedbackId;
    /**
     *反馈内容
     */
    private String content;
    /**
     *组织ID
     */
    private String orgId;
    /**
     *是否已经查阅
     */
    private String read;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *查阅时间
     */
    private Date readTime;
    /**
     *查阅人ID
     */
    private String userId;
    /**
     *图片URL
     */
    private String imageUrlOne;
    /**
     *图片URL
     */
    private String imageUrlTwo;


}