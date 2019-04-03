package xyz.berby.im.service;

import xyz.berby.im.entity.Collect;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 收藏表  collection_type: 简单文本 文件 访问内容(Collect)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:04
 */
public interface CollectService {

    /**
     * 通过ID查询单条数据
     *
     * @param collectionId 主键
     * @return 实例对象
     */
    Collect queryById(String collectionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Collect> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<Collect> queryByPager(Pager<Collect> pager);

    Pager<Collect> queryByPagerWithNoCount(Pager<Collect> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<Collect> countByPager(Pager<Collect> pager);    
    /**
     * 新增数据
     *
     * @param collect 实例对象
     * @return 实例对象
     */
    Collect insert(Collect collect);

    /**
     * 修改数据
     *
     * @param collect 实例对象
     * @return 实例对象
     */
    Collect update(Collect collect);

    /**
     * 通过主键删除数据
     *
     * @param collectionId 主键
     * @return 是否成功
     */
    boolean deleteById(String collectionId);

    /**
     * 通过主键数组删除数据
     * @param collectionIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] collectionIds);    

}