package xyz.berby.im.dao;

import xyz.berby.im.entity.UserOrgRole;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户部门角色表(UserOrgRole)表数据库访问层
 *
 * @author makejava
 * @since 2019-03-10 19:16:27
 */
 
public interface UserOrgRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userOrgRoleId 主键
     * @return 实例对象
     */
    UserOrgRole queryById(String userOrgRoleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserOrgRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userOrgRole 实例对象
     * @return 对象列表
     */
    List<UserOrgRole> queryAll(UserOrgRole userOrgRole);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<UserOrgRole> queryByPager(Pager<UserOrgRole> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<UserOrgRole> pager);
    
    /**
     * 新增数据
     *
     * @param userOrgRole 实例对象
     * @return 影响行数
     */
    int insert(UserOrgRole userOrgRole);

    /**
     * 修改数据
     *
     * @param userOrgRole 实例对象
     * @return 影响行数
     */
    int update(UserOrgRole userOrgRole);

    /**
     * 通过主键删除数据
     *
     * @param userOrgRoleId 主键
     * @return 影响行数
     */
    int deleteById(String userOrgRoleId);
    
    /**
     * 通过主键数组删除数据
     * @param userOrgRoleIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] userOrgRoleIds);
}