package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.OrgRole;
import xyz.berby.im.dao.OrgRoleDao;
import xyz.berby.im.service.OrgRoleService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 组织角色表(OrgRole)表服务实现类
 *
 * @author litianfeng
 * @since 2018-12-12 12:39:18
 */
@Service("orgRoleService")
@Transactional
public class OrgRoleServiceImpl implements OrgRoleService {
    @Resource
    private OrgRoleDao orgRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orgRoleId 主键
     * @return 实例对象
     */
    @Override
    public OrgRole queryById(String orgRoleId) {
        return this.orgRoleDao.queryById(orgRoleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<OrgRole> queryAllByLimit(int offset, int limit) {
        return this.orgRoleDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<OrgRole> queryByPager(Pager<OrgRole> pager) {
        pager = this.countByPager(pager);                
        List<OrgRole> result = orgRoleDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<OrgRole> countByPager(Pager<OrgRole> pager) {
        int size = orgRoleDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param orgRole 实例对象
     * @return 实例对象
     */
    @Override
    public OrgRole insert(OrgRole orgRole) {
        this.orgRoleDao.insert(orgRole);
        return orgRole;
    }

    /**
     * 修改数据
     *
     * @param orgRole 实例对象
     * @return 实例对象
     */
    @Override
    public OrgRole update(OrgRole orgRole) {
        this.orgRoleDao.update(orgRole);
        return this.queryById(orgRole.getOrgRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orgRoleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String orgRoleId) {
        return this.orgRoleDao.deleteById(orgRoleId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param orgRoleIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] orgRoleIds) {
        return this.orgRoleDao.deleteByIds(orgRoleIds) == orgRoleIds.length;
    }
}