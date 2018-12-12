package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.Collect;
import xyz.berby.im.dao.CollectDao;
import xyz.berby.im.service.CollectService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 收藏表  collection_type: 简单文本 文件 访问内容(Collect)表服务实现类
 *
 * @author litianfeng
 * @since 2018-12-12 12:39:18
 */
@Service("collectService")
@Transactional
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectDao collectDao;

    /**
     * 通过ID查询单条数据
     *
     * @param collectionId 主键
     * @return 实例对象
     */
    @Override
    public Collect queryById(String collectionId) {
        return this.collectDao.queryById(collectionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Collect> queryAllByLimit(int offset, int limit) {
        return this.collectDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Collect> queryByPager(Pager<Collect> pager) {
        pager = this.countByPager(pager);                
        List<Collect> result = collectDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<Collect> countByPager(Pager<Collect> pager) {
        int size = collectDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param collect 实例对象
     * @return 实例对象
     */
    @Override
    public Collect insert(Collect collect) {
        this.collectDao.insert(collect);
        return collect;
    }

    /**
     * 修改数据
     *
     * @param collect 实例对象
     * @return 实例对象
     */
    @Override
    public Collect update(Collect collect) {
        this.collectDao.update(collect);
        return this.queryById(collect.getCollectionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param collectionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String collectionId) {
        return this.collectDao.deleteById(collectionId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param collectionIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] collectionIds) {
        return this.collectDao.deleteByIds(collectionIds) == collectionIds.length;
    }
}