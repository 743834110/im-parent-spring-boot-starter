package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.Feedback;
import xyz.berby.im.dao.FeedbackDao;
import xyz.berby.im.service.FeedbackService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Feedback)表服务实现类
 *
 * @author makejava
 * @since 2019-03-03 10:31:08
 */
@Service("feedbackService")
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackDao feedbackDao;

    /**
     * 通过ID查询单条数据
     *
     * @param feedbackId 主键
     * @return 实例对象
     */
    @Override
    public Feedback queryById(String feedbackId) {
        return this.feedbackDao.queryById(feedbackId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Feedback> queryAllByLimit(int offset, int limit) {
        return this.feedbackDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Feedback> queryByPager(Pager<Feedback> pager) {
        pager = this.countByPager(pager);                
        List<Feedback> result = feedbackDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<Feedback> countByPager(Pager<Feedback> pager) {
        int size = feedbackDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    @Override
    public Feedback insert(Feedback feedback) {
        this.feedbackDao.insert(feedback);
        return feedback;
    }

    /**
     * 修改数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    @Override
    public Feedback update(Feedback feedback) {
        this.feedbackDao.update(feedback);
        return this.queryById(feedback.getFeedbackId());
    }

    /**
     * 通过主键删除数据
     *
     * @param feedbackId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String feedbackId) {
        return this.feedbackDao.deleteById(feedbackId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param feedbackIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] feedbackIds) {
        return this.feedbackDao.deleteByIds(feedbackIds) == feedbackIds.length;
    }
}