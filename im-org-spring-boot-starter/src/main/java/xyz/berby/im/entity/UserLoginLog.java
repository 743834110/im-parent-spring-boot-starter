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
 * @author makejava
 * @since 2019-03-03 10:31:17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginLog implements Serializable {
    private static final long serialVersionUID = 164311801713785385L;
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
        private String token;


}