package xyz.berby.im.dao;

import xyz.berby.im.entity.OrgRole;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 组织角色表(OrgRole)表数据库访问层
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
 
public interface OrgRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orgRoleId 主键
     * @return 实例对象
     */
    OrgRole queryById(String orgRoleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrgRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orgRole 实例对象
     * @return 对象列表
     */
    List<OrgRole> queryAll(OrgRole orgRole);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<OrgRole> queryByPager(Pager<OrgRole> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<OrgRole> pager);
    
    /**
     * 新增数据
     *
     * @param orgRole 实例对象
     * @return 影响行数
     */
    int insert(OrgRole orgRole);

    /**
     * 修改数据
     *
     * @param orgRole 实例对象
     * @return 影响行数
     */
    int update(OrgRole orgRole);

    /**
     * 通过主键删除数据
     *
     * @param orgRoleId 主键
     * @return 影响行数
     */
    int deleteById(String orgRoleId);
    
    /**
     * 通过主键数组删除数据
     * @param orgRoleIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] orgRoleIds);
}