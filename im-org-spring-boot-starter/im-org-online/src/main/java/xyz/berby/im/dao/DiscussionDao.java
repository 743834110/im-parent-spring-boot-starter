package xyz.berby.im.dao;

import xyz.berby.im.entity.Discussion;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Discussion)表数据库访问层
 *
 * @author makejava
 * @since 2019-03-03 10:31:07
 */
 
public interface DiscussionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param discussionId 主键
     * @return 实例对象
     */
    Discussion queryById(String discussionId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Discussion> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param discussion 实例对象
     * @return 对象列表
     */
    List<Discussion> queryAll(Discussion discussion);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<Discussion> queryByPager(Pager<Discussion> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<Discussion> pager);
    
    /**
     * 新增数据
     *
     * @param discussion 实例对象
     * @return 影响行数
     */
    int insert(Discussion discussion);

    /**
     * 修改数据
     *
     * @param discussion 实例对象
     * @return 影响行数
     */
    int update(Discussion discussion);

    /**
     * 通过主键删除数据
     *
     * @param discussionId 主键
     * @return 影响行数
     */
    int deleteById(String discussionId);
    
    /**
     * 通过主键数组删除数据
     * @param discussionIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] discussionIds);
}