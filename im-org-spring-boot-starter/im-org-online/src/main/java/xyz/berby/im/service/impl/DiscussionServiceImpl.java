package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.annotation.DefaultValue;
import xyz.berby.im.entity.Discussion;
import xyz.berby.im.dao.DiscussionDao;
import xyz.berby.im.service.DiscussionService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import java.util.List;

/**
 * (Discussion)表服务实现类
 *
 * @author makejava
 * @since 2019-04-01 17:30:55
 */
@Service("discussionService")
@Transactional
public class DiscussionServiceImpl implements DiscussionService {
    @Resource
    private DiscussionDao discussionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param discussionId 主键
     * @return 实例对象
     */
    @Override
    public Discussion queryById(String discussionId) {
        return this.discussionDao.queryById(discussionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Discussion> queryAllByLimit(int offset, int limit) {
        return this.discussionDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Discussion> queryByPager(Pager<Discussion> pager) {
        pager = this.countByPager(pager);                
        List<Discussion> result = discussionDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }
     
   /**
     * 
     * 根据分页对象查询数据,不计算页数
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Discussion> queryByPagerWithNoCount(Pager<Discussion> pager) {         
        List<Discussion> result = discussionDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<Discussion> countByPager(Pager<Discussion> pager) {
        int size = discussionDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    @Override
    @DefaultValue(expression = "0.routineUserId=user.userId, 0.createTime=now")
    public Discussion insert(Discussion discussion) {
  discussion.setDiscussionId(IdUtil.fastSimpleUUID());
        this.discussionDao.insert(discussion);
        return discussion;
    }

    /**
     * 修改数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    @Override
    public Discussion update(Discussion discussion) {
        this.discussionDao.update(discussion);
        return this.queryById(discussion.getDiscussionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param discussionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String discussionId) {
        return this.discussionDao.deleteById(discussionId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param discussionIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] discussionIds) {
        return this.discussionDao.deleteByIds(discussionIds) == discussionIds.length;
    }
}