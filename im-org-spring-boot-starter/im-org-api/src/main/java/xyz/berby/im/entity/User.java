package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 用户表  user_type 学生 教师(User)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:31:16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractUser<Auth, Role> implements Serializable {
    private static final long serialVersionUID = 158265149695907059L;
        private String userId;
    /**
     *用户账号
     */
    @NotNull
    private String userAccount;
    /**
     *用户密码
     */

    @JSONField(serialize = false)
    private String userPassword;
    /**
     *用户名称
     */
    private String userName;
    /**
     *手机号
     */
    private String userMobile;
    /**
     *QQ邮箱
     */
    private String userEmail;
    /**
     *用户头像地址
     */
    private String userImageUrl;
    /**
     *用户描述
     */
    private String userDescription;
    /**
     *初始密码更改日期
     */
    private Date userPasswordChanged;
    /**
     *是否有效
     */
    private String valid = "Y";
    /**
     *启用日期
     */
    private Date userEnabledDate;
    /**
     *失效日期
     */
    private Date userDisabledDate;
    /**
     *账号是否锁定
     */
    private String userAccountLocked;
    /**
     *最后登录时间
     */
    private Date lastLoginDate;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *创建人
     */
    private String createPerson;
    /**
     *修改时间
     */
    private Date modifyTime;
    /**
     *修改人
     */
    private String modifyPerson;
    /**
     *用户性别
     */
    private String userSex;
    /**
     *用户类型
     */
    private String userType;
    /**
     *盐值
     */
    private String salt;
    /**
     *留言
     */
    private String words;
    /**
     *校园短号
     */
    private String userShortMobile;
    /**
     * 角色编号
     */
    private String roleId;

    private List<Auth> authList;

    private List<Role> roleList;


}