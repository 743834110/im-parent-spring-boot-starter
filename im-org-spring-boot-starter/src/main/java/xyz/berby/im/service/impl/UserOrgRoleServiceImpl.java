package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.UserOrgRole;
import xyz.berby.im.dao.UserOrgRoleDao;
import xyz.berby.im.service.UserOrgRoleService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import java.util.List;

/**
 * 用户部门角色表(UserOrgRole)表服务实现类
 *
 * @author makejava
 * @since 2019-03-20 22:21:01
 */
@Service("userOrgRoleService")
@Transactional
public class UserOrgRoleServiceImpl implements UserOrgRoleService {
    @Resource
    private UserOrgRoleDao userOrgRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userOrgRoleId 主键
     * @return 实例对象
     */
    @Override
    public UserOrgRole queryById(String userOrgRoleId) {
        return this.userOrgRoleDao.queryById(userOrgRoleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserOrgRole> queryAllByLimit(int offset, int limit) {
        return this.userOrgRoleDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<UserOrgRole> queryByPager(Pager<UserOrgRole> pager) {
        pager = this.countByPager(pager);                
        List<UserOrgRole> result = userOrgRoleDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<UserOrgRole> countByPager(Pager<UserOrgRole> pager) {
        int size = userOrgRoleDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param userOrgRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserOrgRole insert(UserOrgRole userOrgRole) {
        userOrgRole.setUserOrgRoleId(IdUtil.fastSimpleUUID());
        this.userOrgRoleDao.insert(userOrgRole);
        return userOrgRole;
    }

    /**
     * 修改数据
     *
     * @param userOrgRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserOrgRole update(UserOrgRole userOrgRole) {
        this.userOrgRoleDao.update(userOrgRole);
        return this.queryById(userOrgRole.getUserOrgRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userOrgRoleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userOrgRoleId) {
        return this.userOrgRoleDao.deleteById(userOrgRoleId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param userOrgRoleIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] userOrgRoleIds) {
        return this.userOrgRoleDao.deleteByIds(userOrgRoleIds) == userOrgRoleIds.length;
    }
}