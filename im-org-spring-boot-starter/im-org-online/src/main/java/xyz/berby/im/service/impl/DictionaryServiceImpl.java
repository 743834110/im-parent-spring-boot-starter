package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.Dictionary;
import xyz.berby.im.dao.DictionaryDao;
import xyz.berby.im.service.DictionaryService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import java.util.List;

/**
 * 字典表(Dictionary)表服务实现类
 *
 * @author makejava
 * @since 2019-04-01 17:30:55
 */
@Service("dictionaryService")
@Transactional
public class DictionaryServiceImpl implements DictionaryService {
    @Resource
    private DictionaryDao dictionaryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param dictionaryId 主键
     * @return 实例对象
     */
    @Override
    public Dictionary queryById(String dictionaryId) {
        return this.dictionaryDao.queryById(dictionaryId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Dictionary> queryAllByLimit(int offset, int limit) {
        return this.dictionaryDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Dictionary> queryByPager(Pager<Dictionary> pager) {
        pager = this.countByPager(pager);                
        List<Dictionary> result = dictionaryDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }
     
   /**
     * 
     * 根据分页对象查询数据,不计算页数
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Dictionary> queryByPagerWithNoCount(Pager<Dictionary> pager) {         
        List<Dictionary> result = dictionaryDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<Dictionary> countByPager(Pager<Dictionary> pager) {
        int size = dictionaryDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    @Override
    public Dictionary insert(Dictionary dictionary) {
  dictionary.setDictionaryId(IdUtil.fastSimpleUUID());
        this.dictionaryDao.insert(dictionary);
        return dictionary;
    }

    /**
     * 修改数据
     *
     * @param dictionary 实例对象
     * @return 实例对象
     */
    @Override
    public Dictionary update(Dictionary dictionary) {
        this.dictionaryDao.update(dictionary);
        return this.queryById(dictionary.getDictionaryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param dictionaryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String dictionaryId) {
        return this.dictionaryDao.deleteById(dictionaryId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param dictionaryIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] dictionaryIds) {
        return this.dictionaryDao.deleteByIds(dictionaryIds) == dictionaryIds.length;
    }
}