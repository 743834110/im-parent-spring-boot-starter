package xyz.berby.im.dao;

import xyz.berby.im.entity.Feedback;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Feedback)表数据库访问层
 *
 * @author makejava
 * @since 2019-03-03 10:31:08
 */
 
public interface FeedbackDao {

    /**
     * 通过ID查询单条数据
     *
     * @param feedbackId 主键
     * @return 实例对象
     */
    Feedback queryById(String feedbackId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Feedback> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param feedback 实例对象
     * @return 对象列表
     */
    List<Feedback> queryAll(Feedback feedback);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<Feedback> queryByPager(Pager<Feedback> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<Feedback> pager);
    
    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 影响行数
     */
    int insert(Feedback feedback);

    /**
     * 修改数据
     *
     * @param feedback 实例对象
     * @return 影响行数
     */
    int update(Feedback feedback);

    /**
     * 通过主键删除数据
     *
     * @param feedbackId 主键
     * @return 影响行数
     */
    int deleteById(String feedbackId);
    
    /**
     * 通过主键数组删除数据
     * @param feedbackIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] feedbackIds);
}