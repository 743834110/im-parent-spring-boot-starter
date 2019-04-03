package xyz.berby.im.service.app;

import xyz.berby.im.service.RoutineService;



/**
 * 日常活动表  user_type: 直接是查询字段得到的学生或者老师等着两个身份，用来显示的，身份有为：学生、教师  此处留下user_id字段是为了知道是哪位用户发的消息  end_time和end字段之间的关系。(Routine)表服务接口
 *
 * @author makejava
 * @since 2019-04-03 22:06:28
 */
public interface AppRoutineService extends RoutineService {

}