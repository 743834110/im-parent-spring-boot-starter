package xyz.berby.im.dao;

import xyz.berby.im.entity.Dictionary;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 字典表(Dictionary)表数据库访问层
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
 
public interface DictionaryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param dictionaryId 主键
     * @return 实例对象
     */
    Dictionary queryById(String dictionaryId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Dictionary> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dictionary 实例对象
     * @return 对象列表
     */
    List<Dictionary> queryAll(Dictionary dictionary);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<Dictionary> queryByPager(Pager<Dictionary> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<Dictionary> pager);
    
    /**
     * 新增数据
     *
     * @param dictionary 实例对象
     * @return 影响行数
     */
    int insert(Dictionary dictionary);

    /**
     * 修改数据
     *
     * @param dictionary 实例对象
     * @return 影响行数
     */
    int update(Dictionary dictionary);

    /**
     * 通过主键删除数据
     *
     * @param dictionaryId 主键
     * @return 影响行数
     */
    int deleteById(String dictionaryId);
    
    /**
     * 通过主键数组删除数据
     * @param dictionaryIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] dictionaryIds);
}