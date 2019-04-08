package xyz.berby.im.service.impl.app;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.annotation.TokenValidate;
import xyz.berby.im.dao.OrganizationDao;
import xyz.berby.im.entity.Routine;
import xyz.berby.im.entity.User;
import xyz.berby.im.service.impl.RoutineServiceImpl;
import xyz.berby.im.service.app.AppRoutineService;
import org.springframework.stereotype.Service;
import xyz.berby.im.vo.Pager;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 日常活动表  user_type: 直接是查询字段得到的学生或者老师等着两个身份，用来显示的，身份有为：学生、教师  此处留下user_id字段是为了知道是哪位用户发的消息  end_time和end字段之间的关系。(Routine)表服务实现类
 *
 * @author makejava
 * @since 2019-04-03 22:12:10
 */
@Service("appRoutineService")
@Transactional
public class AppRoutineServiceImpl extends RoutineServiceImpl implements AppRoutineService {

    @Resource
    private OrganizationDao organizationDao;

    /**
     * app端日常活动插入操作
     * @param routine
     * @param user
     * @return
     */
    public Routine appInsert(Routine routine, User user) {
        // 设置用户信息
        routine.setUserId(user.getUserId());
        routine.setUserType(user.getUserType());
        routine.setCreateTime(new Date());
        routine.setUserName(user.getUserName());
        return this.insert(routine);
    }

    @TokenValidate
    public Pager<Routine> queryByPager(Pager<Routine> pager) {
        return super.queryByPager(pager);
    }
}