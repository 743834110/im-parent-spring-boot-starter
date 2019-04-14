package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.DictionaryType;
import xyz.berby.im.dao.DictionaryTypeDao;
import xyz.berby.im.service.DictionaryTypeService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import java.util.List;

/**
 * 字典类型表(DictionaryType)表服务实现类
 *
 * @author makejava
 * @since 2019-04-01 17:30:55
 */
@Service("dictionaryTypeService")
@Transactional
public class DictionaryTypeServiceImpl implements DictionaryTypeService {
    @Resource
    private DictionaryTypeDao dictionaryTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param codeItemId 主键
     * @return 实例对象
     */
    @Override
    public DictionaryType queryById(String codeItemId) {
        return this.dictionaryTypeDao.queryById(codeItemId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DictionaryType> queryAllByLimit(int offset, int limit) {
        return this.dictionaryTypeDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<DictionaryType> queryByPager(Pager<DictionaryType> pager) {
        pager = this.countByPager(pager);                
        List<DictionaryType> result = dictionaryTypeDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }
     
   /**
     * 
     * 根据分页对象查询数据,不计算页数
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<DictionaryType> queryByPagerWithNoCount(Pager<DictionaryType> pager) {         
        List<DictionaryType> result = dictionaryTypeDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<DictionaryType> countByPager(Pager<DictionaryType> pager) {
        int size = dictionaryTypeDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param dictionaryType 实例对象
     * @return 实例对象
     */
    @Override
    public DictionaryType insert(DictionaryType dictionaryType) {
//      dictionaryType.setCodeItemId(IdUtil.fastSimpleUUID());
        this.dictionaryTypeDao.insert(dictionaryType);
        return dictionaryType;
    }

    /**
     * 修改数据
     *
     * @param dictionaryType 实例对象
     * @return 实例对象
     */
    @Override
    public DictionaryType update(DictionaryType dictionaryType) {
        this.dictionaryTypeDao.update(dictionaryType);
        return this.queryById(dictionaryType.getCodeItemId());
    }

    /**
     * 通过主键删除数据
     *
     * @param codeItemId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String codeItemId) {
        return this.dictionaryTypeDao.deleteById(codeItemId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param codeItemIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] codeItemIds) {
        return this.dictionaryTypeDao.deleteByIds(codeItemIds) == codeItemIds.length;
    }
}