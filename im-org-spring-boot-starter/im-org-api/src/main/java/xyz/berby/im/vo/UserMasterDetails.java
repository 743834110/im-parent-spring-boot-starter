package xyz.berby.im.vo;

import lombok.Getter;
import lombok.Setter;
import xyz.berby.im.entity.User;
import xyz.berby.im.entity.UserOrg;

/**
 * 主子表保存表视图类
 * @author LTF
 * Created on 2019/4/2
 *
 */
@Setter
@Getter
public class UserMasterDetails extends User {


    private InputBean<UserOrg> userOrgs;
}
