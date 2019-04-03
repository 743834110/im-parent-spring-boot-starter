package xyz.berby.im.service;

import xyz.berby.im.entity.Role;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 角色表： role_type用于区分班学生社团和机构的角色(Role)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:12
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    Role queryById(String roleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Role> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<Role> queryByPager(Pager<Role> pager);

    Pager<Role> queryByPagerWithNoCount(Pager<Role> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<Role> countByPager(Pager<Role> pager);    
    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(String roleId);

    /**
     * 通过主键数组删除数据
     * @param roleIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] roleIds);    

}