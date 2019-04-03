package xyz.berby.im.vo;

import lombok.*;

import java.util.Date;

/**
 * @author LTF
 * Created on 2019/4/1
 * token节点，用于多系统间的登录交互
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccessToken {


    String subject;
    /**
     * 签发时间
     */
    long issuedAt;
    /**
     * 过期时间
     */
    long expiration;


}
