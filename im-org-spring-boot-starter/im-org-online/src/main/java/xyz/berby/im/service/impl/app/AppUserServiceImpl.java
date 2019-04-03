package xyz.berby.im.service.impl.app;

import cn.hutool.crypto.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.dao.UserDao;
import xyz.berby.im.entity.User;
import xyz.berby.im.service.app.AppUserService;

import javax.annotation.Resource;
import java.util.List;

@Service("appUserServiceImpl")
@Transactional
public class AppUserServiceImpl implements AppUserService {

    @Resource
    private UserDao userDao;

    /**
     * app端登录操作
     * @param user user
     * @return
     */
    @Override
    public User login(User user) {
        User queryUser = new User();
        queryUser.setUserAccount(user.getUserAccount());
        List<User> userList = this.userDao.queryAll(queryUser);

        User queriedUser = userList == null || userList.size() == 0? null: userList.get(0);
        // 判断用户是否存在
        if (queriedUser == null)
            throw new RuntimeException("用户或密码错误");
        String password = SecureUtil.hmacSha1(queriedUser.getSalt()).digestHex(user.getUserPassword());
        // 判断登录密码是否正确
        if (!password.equals(queriedUser.getUserPassword())) {
            throw new RuntimeException("用户或密码错误");
        }

        return queriedUser;
    }
}
