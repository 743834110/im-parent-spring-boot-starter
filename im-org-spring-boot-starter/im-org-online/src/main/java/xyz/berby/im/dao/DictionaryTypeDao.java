package xyz.berby.im.dao;

import xyz.berby.im.entity.DictionaryType;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 字典类型表(DictionaryType)表数据库访问层
 *
 * @author makejava
 * @since 2019-03-03 10:31:06
 */
 
public interface DictionaryTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param codeItemId 主键
     * @return 实例对象
     */
    DictionaryType queryById(String codeItemId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DictionaryType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dictionaryType 实例对象
     * @return 对象列表
     */
    List<DictionaryType> queryAll(DictionaryType dictionaryType);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<DictionaryType> queryByPager(Pager<DictionaryType> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<DictionaryType> pager);
    
    /**
     * 新增数据
     *
     * @param dictionaryType 实例对象
     * @return 影响行数
     */
    int insert(DictionaryType dictionaryType);

    /**
     * 修改数据
     *
     * @param dictionaryType 实例对象
     * @return 影响行数
     */
    int update(DictionaryType dictionaryType);

    /**
     * 通过主键删除数据
     *
     * @param codeItemId 主键
     * @return 影响行数
     */
    int deleteById(String codeItemId);
    
    /**
     * 通过主键数组删除数据
     * @param codeItemIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] codeItemIds);
}