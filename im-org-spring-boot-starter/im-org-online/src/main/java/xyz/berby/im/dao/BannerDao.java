package xyz.berby.im.dao;

import xyz.berby.im.entity.Banner;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 横幅表(Banner)表数据库访问层
 *
 * @author makejava
 * @since 2019-03-03 10:31:02
 */
 
public interface BannerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bannerId 主键
     * @return 实例对象
     */
    Banner queryById(String bannerId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Banner> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param banner 实例对象
     * @return 对象列表
     */
    List<Banner> queryAll(Banner banner);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<Banner> queryByPager(Pager<Banner> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<Banner> pager);
    
    /**
     * 新增数据
     *
     * @param banner 实例对象
     * @return 影响行数
     */
    int insert(Banner banner);

    /**
     * 修改数据
     *
     * @param banner 实例对象
     * @return 影响行数
     */
    int update(Banner banner);

    /**
     * 通过主键删除数据
     *
     * @param bannerId 主键
     * @return 影响行数
     */
    int deleteById(String bannerId);
    
    /**
     * 通过主键数组删除数据
     * @param bannerIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] bannerIds);
}