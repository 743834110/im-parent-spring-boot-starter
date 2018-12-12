package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 用户登录日志表(UserLoginLog)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginLog implements Serializable {
    private static final long serialVersionUID = 596678271329138704L;
        private String loginLogId;
    /**
     *登录账号
     */
    private String userAccount;
    /**
     *会话ID
     */
    private String sessionId;
    /**
     *退出时间
     */
    private Date logoutTime;
    /**
     *IP地址
     */
    private String userIp;


}