package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2018-12-09 11:14:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = -38967841098044360L;
    
    private String userId;
    
    private String userAccount;
    
    private String userPassword;
    
    private String userName;
    
    private String userMobile;
    
    private String userEmail;
    
    private String userImageUrl;
    
    private String userDescription;
    
    private Date userPasswordChanged;
    
    private String valid;
    
    private Date userEnabledDate;
    
    private Date userDisabledDate;
    
    private String userAccountLocked;
    
    private Date lastLoginDate;
    
    private Date createTime;
    
    private String createPerson;
    
    private Date modifyTime;
    
    private String modifyPerson;
    
    private String userSex;
    
    private String userType;


}