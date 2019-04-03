package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.RoleAuth;
import xyz.berby.im.dao.RoleAuthDao;
import xyz.berby.im.service.RoleAuthService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import java.util.List;

/**
 * 角色权限表(RoleAuth)表服务实现类
 *
 * @author makejava
 * @since 2019-04-01 17:30:55
 */
@Service("roleAuthService")
@Transactional
public class RoleAuthServiceImpl implements RoleAuthService {
    @Resource
    private RoleAuthDao roleAuthDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleAuthId 主键
     * @return 实例对象
     */
    @Override
    public RoleAuth queryById(String roleAuthId) {
        return this.roleAuthDao.queryById(roleAuthId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RoleAuth> queryAllByLimit(int offset, int limit) {
        return this.roleAuthDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<RoleAuth> queryByPager(Pager<RoleAuth> pager) {
        pager = this.countByPager(pager);                
        List<RoleAuth> result = roleAuthDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }
     
   /**
     * 
     * 根据分页对象查询数据,不计算页数
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<RoleAuth> queryByPagerWithNoCount(Pager<RoleAuth> pager) {         
        List<RoleAuth> result = roleAuthDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<RoleAuth> countByPager(Pager<RoleAuth> pager) {
        int size = roleAuthDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param roleAuth 实例对象
     * @return 实例对象
     */
    @Override
    public RoleAuth insert(RoleAuth roleAuth) {
  roleAuth.setRoleAuthId(IdUtil.fastSimpleUUID());
        this.roleAuthDao.insert(roleAuth);
        return roleAuth;
    }

    /**
     * 修改数据
     *
     * @param roleAuth 实例对象
     * @return 实例对象
     */
    @Override
    public RoleAuth update(RoleAuth roleAuth) {
        this.roleAuthDao.update(roleAuth);
        return this.queryById(roleAuth.getRoleAuthId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleAuthId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String roleAuthId) {
        return this.roleAuthDao.deleteById(roleAuthId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param roleAuthIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] roleAuthIds) {
        return this.roleAuthDao.deleteByIds(roleAuthIds) == roleAuthIds.length;
    }
}