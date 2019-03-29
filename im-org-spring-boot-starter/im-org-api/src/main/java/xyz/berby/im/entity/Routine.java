package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 日常活动表  user_type: 直接是查询字段得到的学生或者老师等着两个身份，用来显示的，身份有为：学生、教师  此处留下user_id字段是为了知道是哪位用户发的消息  end_time和end字段之间的关系。(Routine)实体类
 *
 * @author makejava
 * @since 2019-03-26 15:18:19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Routine implements Serializable {
    private static final long serialVersionUID = 976126724107992310L;
        private String routineId;
    /**
     *用户ID
     */
    private String userId;
    /**
     *用户名称
     */
    private String userName;
    /**
     *日常活动类型
     */
    private String routineType;
    /**
     *日常活动内容
     */
    private String content;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *用户类型
     */
    private String userType;
    /**
     *组织ID
     */
    private String orgId;
    /**
     *活动截止日期
     */
    private Date endTime;
    /**
     *活动是否截止
     */
    private String end;
    /**
     *可见年级
     */
    private String grade;
    /**
     *可见范围
     */
    private String visibility;
    /**
     *日常活动标题
     */
    private String title;
    /**
     *组织名称
     */
    private String orgName;


}