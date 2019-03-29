package xyz.berby.im;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import xyz.berby.im.entity.User;
import xyz.berby.im.vo.Pager;

@Slf4j
public class ReflectTest {

    @Test
    public void testUserInterface() {
        User user = new User();
        user.setUserSex("mvn");
        Pager<User> userPager = new Pager<>(user);
        System.out.println(JSON.toJSONString(userPager));
    }
}
