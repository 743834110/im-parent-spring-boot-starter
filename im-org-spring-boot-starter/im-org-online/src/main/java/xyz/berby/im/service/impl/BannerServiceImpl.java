package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.Banner;
import xyz.berby.im.dao.BannerDao;
import xyz.berby.im.service.BannerService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import java.util.List;

/**
 * 横幅表(Banner)表服务实现类
 *
 * @author makejava
 * @since 2019-03-20 22:20:58
 */
@Service("bannerService")
@Transactional
public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerDao bannerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bannerId 主键
     * @return 实例对象
     */
    @Override
    public Banner queryById(String bannerId) {
        return this.bannerDao.queryById(bannerId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Banner> queryAllByLimit(int offset, int limit) {
        return this.bannerDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Banner> queryByPager(Pager<Banner> pager) {
        pager = this.countByPager(pager);                
        List<Banner> result = bannerDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<Banner> countByPager(Pager<Banner> pager) {
        int size = bannerDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param banner 实例对象
     * @return 实例对象
     */
    @Override
    public Banner insert(Banner banner) {
        banner.setBannerId(IdUtil.fastSimpleUUID());
        this.bannerDao.insert(banner);
        return banner;
    }

    /**
     * 修改数据
     *
     * @param banner 实例对象
     * @return 实例对象
     */
    @Override
    public Banner update(Banner banner) {
        this.bannerDao.update(banner);
        return this.queryById(banner.getBannerId());
    }

    /**
     * 通过主键删除数据
     *
     * @param bannerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String bannerId) {
        return this.bannerDao.deleteById(bannerId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param bannerIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] bannerIds) {
        return this.bannerDao.deleteByIds(bannerIds) == bannerIds.length;
    }
}