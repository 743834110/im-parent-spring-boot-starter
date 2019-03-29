package xyz.berby.im.service;

import xyz.berby.im.entity.Dictionary;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 字典表(Dictionary)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:05
 */
public interface DictionaryService {

    /**
     * 通过ID查询单条数据
     *
     * @param dictionaryId 主键
     * @return 实例对象
     */
    Dictionary queryById(String dictionaryId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Dictionary> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<Dictionary> queryByPager(Pager<Dictionary> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<Dictionary> countByPager(Pager<Dictionary> pager);    
    /**
     * 新增数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    Dictionary insert(Dictionary dictionary);

    /**
     * 修改数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    Dictionary update(Dictionary dictionary);

    /**
     * 通过主键删除数据
     *
     * @param dictionaryId 主键
     * @return 是否成功
     */
    boolean deleteById(String dictionaryId);

    /**
     * 通过主键数组删除数据
     * @param dictionaryIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] dictionaryIds);    

}