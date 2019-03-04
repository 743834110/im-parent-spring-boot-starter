package xyz.berby.im.dao;

import xyz.berby.im.entity.RoleAuth;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色权限表(RoleAuth)表数据库访问层
 *
 * @author makejava
 * @since 2019-03-03 10:31:14
 */
 
public interface RoleAuthDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roleAuthId 主键
     * @return 实例对象
     */
    RoleAuth queryById(String roleAuthId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleAuth> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param roleAuth 实例对象
     * @return 对象列表
     */
    List<RoleAuth> queryAll(RoleAuth roleAuth);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<RoleAuth> queryByPager(Pager<RoleAuth> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<RoleAuth> pager);
    
    /**
     * 新增数据
     *
     * @param roleAuth 实例对象
     * @return 影响行数
     */
    int insert(RoleAuth roleAuth);

    /**
     * 修改数据
     *
     * @param roleAuth 实例对象
     * @return 影响行数
     */
    int update(RoleAuth roleAuth);

    /**
     * 通过主键删除数据
     *
     * @param roleAuthId 主键
     * @return 影响行数
     */
    int deleteById(String roleAuthId);
    
    /**
     * 通过主键数组删除数据
     * @param roleAuthIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] roleAuthIds);
}