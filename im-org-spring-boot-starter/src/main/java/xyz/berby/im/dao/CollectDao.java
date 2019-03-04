package xyz.berby.im.dao;

import xyz.berby.im.entity.Collect;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 收藏表  collection_type: 简单文本 文件 访问内容(Collect)表数据库访问层
 *
 * @author makejava
 * @since 2019-03-03 10:31:04
 */
 
public interface CollectDao {

    /**
     * 通过ID查询单条数据
     *
     * @param collectionId 主键
     * @return 实例对象
     */
    Collect queryById(String collectionId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Collect> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param collect 实例对象
     * @return 对象列表
     */
    List<Collect> queryAll(Collect collect);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<Collect> queryByPager(Pager<Collect> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<Collect> pager);
    
    /**
     * 新增数据
     *
     * @param collect 实例对象
     * @return 影响行数
     */
    int insert(Collect collect);

    /**
     * 修改数据
     *
     * @param collect 实例对象
     * @return 影响行数
     */
    int update(Collect collect);

    /**
     * 通过主键删除数据
     *
     * @param collectionId 主键
     * @return 影响行数
     */
    int deleteById(String collectionId);
    
    /**
     * 通过主键数组删除数据
     * @param collectionIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] collectionIds);
}