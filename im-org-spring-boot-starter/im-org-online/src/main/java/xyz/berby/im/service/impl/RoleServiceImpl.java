package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.Role;
import xyz.berby.im.dao.RoleDao;
import xyz.berby.im.service.RoleService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import java.util.List;

/**
 * 角色表： role_type用于区分班学生社团和机构的角色(Role)表服务实现类
 *
 * @author makejava
 * @since 2019-04-01 17:30:55
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(String roleId) {
        return this.roleDao.queryById(roleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Role> queryAllByLimit(int offset, int limit) {
        return this.roleDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Role> queryByPager(Pager<Role> pager) {
        pager = this.countByPager(pager);                
        List<Role> result = roleDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }
     
   /**
     * 
     * 根据分页对象查询数据,不计算页数
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Role> queryByPagerWithNoCount(Pager<Role> pager) {         
        List<Role> result = roleDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<Role> countByPager(Pager<Role> pager) {
        int size = roleDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
  role.setRoleId(IdUtil.fastSimpleUUID());
        this.roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String roleId) {
        return this.roleDao.deleteById(roleId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param roleIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] roleIds) {
        return this.roleDao.deleteByIds(roleIds) == roleIds.length;
    }
}