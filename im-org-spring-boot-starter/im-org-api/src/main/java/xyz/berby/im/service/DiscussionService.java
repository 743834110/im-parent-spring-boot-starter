package xyz.berby.im.service;

import xyz.berby.im.entity.Discussion;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * (Discussion)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:07
 */
public interface DiscussionService {

    /**
     * 通过ID查询单条数据
     *
     * @param discussionId 主键
     * @return 实例对象
     */
    Discussion queryById(String discussionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Discussion> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<Discussion> queryByPager(Pager<Discussion> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<Discussion> countByPager(Pager<Discussion> pager);    
    /**
     * 新增数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    Discussion insert(Discussion discussion);

    /**
     * 修改数据
     *
     * @param discussion 实例对象
     * @return 实例对象
     */
    Discussion update(Discussion discussion);

    /**
     * 通过主键删除数据
     *
     * @param discussionId 主键
     * @return 是否成功
     */
    boolean deleteById(String discussionId);

    /**
     * 通过主键数组删除数据
     * @param discussionIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] discussionIds);    

}