package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.annotation.TokenValidate;
import xyz.berby.im.dao.ChatGroupDao;
import xyz.berby.im.entity.ChatGroup;
import xyz.berby.im.entity.Organization;
import xyz.berby.im.dao.OrganizationDao;
import xyz.berby.im.service.OrganizationService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import java.util.List;

/**
 * 部门表 org_type: 社团 机构 班级 pro_type 专业类型(Organization)表服务实现类
 *
 * @author makejava
 * @since 2019-04-01 17:30:55
 */
@Service("organizationService")
@Transactional
public class OrganizationServiceImpl implements OrganizationService {
    @Resource
    protected OrganizationDao organizationDao;

    @Resource
    protected ChatGroupDao chatGroupDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orgId 主键
     * @return 实例对象
     */
    @Override
    public Organization queryById(String orgId) {
        return this.organizationDao.queryById(orgId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Organization> queryAllByLimit(int offset, int limit) {
        return this.organizationDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Organization> queryByPager(Pager<Organization> pager) {
        pager = this.countByPager(pager);                
        List<Organization> result = organizationDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }
     
   /**
     * 
     * 根据分页对象查询数据,不计算页数
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Organization> queryByPagerWithNoCount(Pager<Organization> pager) {         
        List<Organization> result = organizationDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<Organization> countByPager(Pager<Organization> pager) {
        int size = organizationDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param organization 实例对象
     * @return 实例对象
     */
    @Override
    public Organization insert(Organization organization) {
        organization.setOrgId(IdUtil.fastSimpleUUID());
        this.organizationDao.insert(organization);
        // 同时创建聊天群
        ChatGroup chatGroup = ChatGroup.builder()
                .avatar(organization.getOrgImageUrl())
                .orgId(organization.getOrgId())
                .name(organization.getShortName())
                .groupId(organization.getOrgId())
                .userId(organization.getUserId())
                .build();
        this.chatGroupDao.insert(chatGroup);
        return organization;
    }

    /**
     * 修改数据
     *
     * @param organization 实例对象
     * @return 实例对象
     */
    @Override
    public Organization update(Organization organization) {
        this.organizationDao.update(organization);
        return this.queryById(organization.getOrgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param orgId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String orgId) {
        return this.organizationDao.deleteById(orgId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param orgIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] orgIds) {
        return this.organizationDao.deleteByIds(orgIds) == orgIds.length;
    }
}