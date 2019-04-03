package xyz.berby.im.service.impl.app;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.Routine;
import xyz.berby.im.entity.User;
import xyz.berby.im.service.impl.RoutineServiceImpl;
import xyz.berby.im.service.app.AppRoutineService;
import org.springframework.stereotype.Service;

/**
 * 日常活动表  user_type: 直接是查询字段得到的学生或者老师等着两个身份，用来显示的，身份有为：学生、教师  此处留下user_id字段是为了知道是哪位用户发的消息  end_time和end字段之间的关系。(Routine)表服务实现类
 *
 * @author makejava
 * @since 2019-04-03 22:12:10
 */
@Service("appRoutineService")
@Transactional
public class AppRoutineServiceImpl extends RoutineServiceImpl implements AppRoutineService {


    public Routine insert(Routine routine, User user) {
        routine.setUserId(user.getUserId());
        return super.insert(routine);
    }



}