package xyz.berby.im.service;

import xyz.berby.im.entity.Routine;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 日常活动表  user_type: 直接是查询字段得到的学生或者老师等着两个身份，用来显示的，身份有为：学生、教师  此处留下user_id字段是为了知道是哪位用户发的消息  end_time和end字段之间的关系。(Routine)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:15
 */
public interface RoutineService {

    /**
     * 通过ID查询单条数据
     *
     * @param routineId 主键
     * @return 实例对象
     */
    Routine queryById(String routineId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Routine> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<Routine> queryByPager(Pager<Routine> pager);

    Pager<Routine> queryByPagerWithNoCount(Pager<Routine> pager);
    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<Routine> countByPager(Pager<Routine> pager);


    /**
     * 新增数据
     *
     * @param routine 实例对象
     * @return 实例对象
     */
    Routine insert(Routine routine);

    /**
     * 修改数据
     *
     * @param routine 实例对象
     * @return 实例对象
     */
    Routine update(Routine routine);

    /**
     * 通过主键删除数据
     *
     * @param routineId 主键
     * @return 是否成功
     */
    boolean deleteById(String routineId);

    /**
     * 通过主键数组删除数据
     * @param routineIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] routineIds);    

}