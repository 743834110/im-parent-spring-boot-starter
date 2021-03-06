package xyz.berby.im.dao;

import xyz.berby.im.entity.Routine;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 日常活动表  user_type: 直接是查询字段得到的学生或者老师等着两个身份，用来显示的，身份有为：学生、教师  此处留下user_id字段是为了知道是哪位用户发的消息  end_time和end字段之间的关系。(Routine)表数据库访问层
 *
 * @author makejava
 * @since 2019-03-03 10:31:15
 */
 
public interface RoutineDao {

    /**
     * 通过ID查询单条数据
     *
     * @param routineId 主键
     * @return 实例对象
     */
    Routine queryById(String routineId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Routine> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param routine 实例对象
     * @return 对象列表
     */
    List<Routine> queryAll(Routine routine);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<Routine> queryByPager(Pager<Routine> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<Routine> pager);
    
    /**
     * 新增数据
     *
     * @param routine 实例对象
     * @return 影响行数
     */
    int insert(Routine routine);

    /**
     * 修改数据
     *
     * @param routine 实例对象
     * @return 影响行数
     */
    int update(Routine routine);

    /**
     * 通过主键删除数据
     *
     * @param routineId 主键
     * @return 影响行数
     */
    int deleteById(String routineId);
    
    /**
     * 通过主键数组删除数据
     * @param routineIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] routineIds);
}