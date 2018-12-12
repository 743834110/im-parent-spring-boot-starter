package xyz.berby.im.service;

import xyz.berby.im.entity.DictionaryType;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 字典类型表(DictionaryType)表服务接口
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
public interface DictionaryTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param codeItemId 主键
     * @return 实例对象
     */
    DictionaryType queryById(String codeItemId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DictionaryType> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<DictionaryType> queryByPager(Pager<DictionaryType> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<DictionaryType> countByPager(Pager<DictionaryType> pager);    
    /**
     * 新增数据
     *
     * @param dictionaryType 实例对象
     * @return 实例对象
     */
    DictionaryType insert(DictionaryType dictionaryType);

    /**
     * 修改数据
     *
     * @param dictionaryType 实例对象
     * @return 实例对象
     */
    DictionaryType update(DictionaryType dictionaryType);

    /**
     * 通过主键删除数据
     *
     * @param codeItemId 主键
     * @return 是否成功
     */
    boolean deleteById(String codeItemId);

    /**
     * 通过主键数组删除数据
     * @param codeItemIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] codeItemIds);    

}