package xyz.berby.im.service;

import xyz.berby.im.entity.Banner;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 横幅表(Banner)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:02
 */
public interface BannerService {

    /**
     * 通过ID查询单条数据
     *
     * @param bannerId 主键
     * @return 实例对象
     */
    Banner queryById(String bannerId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Banner> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<Banner> queryByPager(Pager<Banner> pager);

    Pager<Banner> queryByPagerWithNoCount(Pager<Banner> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<Banner> countByPager(Pager<Banner> pager);    
    /**
     * 新增数据
     *
     * @param banner 实例对象
     * @return 实例对象
     */
    Banner insert(Banner banner);

    /**
     * 修改数据
     *
     * @param banner 实例对象
     * @return 实例对象
     */
    Banner update(Banner banner);

    /**
     * 通过主键删除数据
     *
     * @param bannerId 主键
     * @return 是否成功
     */
    boolean deleteById(String bannerId);

    /**
     * 通过主键数组删除数据
     * @param bannerIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] bannerIds);    

}