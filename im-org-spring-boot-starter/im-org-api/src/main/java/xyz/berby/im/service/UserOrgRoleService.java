package xyz.berby.im.service;

import xyz.berby.im.entity.UserOrgRole;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 用户部门角色表(UserOrgRole)表服务接口
 *
 * @author makejava
 * @since 2019-03-10 19:16:27
 */
public interface UserOrgRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param userOrgRoleId 主键
     * @return 实例对象
     */
    UserOrgRole queryById(String userOrgRoleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserOrgRole> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<UserOrgRole> queryByPager(Pager<UserOrgRole> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<UserOrgRole> countByPager(Pager<UserOrgRole> pager);    
    /**
     * 新增数据
     *
     * @param userOrgRole 实例对象
     * @return 实例对象
     */
    UserOrgRole insert(UserOrgRole userOrgRole);

    /**
     * 修改数据
     *
     * @param userOrgRole 实例对象
     * @return 实例对象
     */
    UserOrgRole update(UserOrgRole userOrgRole);

    /**
     * 通过主键删除数据
     *
     * @param userOrgRoleId 主键
     * @return 是否成功
     */
    boolean deleteById(String userOrgRoleId);

    /**
     * 通过主键数组删除数据
     * @param userOrgRoleIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] userOrgRoleIds);    

}