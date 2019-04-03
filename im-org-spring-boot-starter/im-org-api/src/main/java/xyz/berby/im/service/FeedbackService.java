package xyz.berby.im.service;

import xyz.berby.im.entity.Feedback;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * (Feedback)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:08
 */
public interface FeedbackService {

    /**
     * 通过ID查询单条数据
     *
     * @param feedbackId 主键
     * @return 实例对象
     */
    Feedback queryById(String feedbackId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Feedback> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<Feedback> queryByPager(Pager<Feedback> pager);

    Pager<Feedback> queryByPagerWithNoCount(Pager<Feedback> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<Feedback> countByPager(Pager<Feedback> pager);    
    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    Feedback insert(Feedback feedback);

    /**
     * 修改数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    Feedback update(Feedback feedback);

    /**
     * 通过主键删除数据
     *
     * @param feedbackId 主键
     * @return 是否成功
     */
    boolean deleteById(String feedbackId);

    /**
     * 通过主键数组删除数据
     * @param feedbackIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] feedbackIds);    

}