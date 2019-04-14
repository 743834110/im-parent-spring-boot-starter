package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.dao.WorkGroupMemberDao;
import xyz.berby.im.entity.UserOrg;
import xyz.berby.im.dao.UserOrgDao;
import xyz.berby.im.entity.WorkGroupMember;
import xyz.berby.im.service.UserOrgService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import java.util.List;

/**
 * 用户部门（班级）表(UserOrg)表服务实现类
 *
 * @author makejava
 * @since 2019-04-01 17:30:55
 */
@Service("userOrgService")
@Transactional
public class UserOrgServiceImpl implements UserOrgService {
    @Resource
    protected UserOrgDao userOrgDao;

    @Resource
    protected WorkGroupMemberDao workGroupMemberDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userOrgId 主键
     * @return 实例对象
     */
    @Override
    public UserOrg queryById(String userOrgId) {
        return this.userOrgDao.queryById(userOrgId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserOrg> queryAllByLimit(int offset, int limit) {
        return this.userOrgDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<UserOrg> queryByPager(Pager<UserOrg> pager) {
        pager = this.countByPager(pager);                
        List<UserOrg> result = userOrgDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }
     
   /**
     * 
     * 根据分页对象查询数据,不计算页数
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<UserOrg> queryByPagerWithNoCount(Pager<UserOrg> pager) {         
        List<UserOrg> result = userOrgDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<UserOrg> countByPager(Pager<UserOrg> pager) {
        int size = userOrgDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param userOrg 实例对象
     * @return 实例对象
     */
    @Override
    public UserOrg insert(UserOrg userOrg) {
        userOrg.setUserOrgId(IdUtil.fastSimpleUUID());
        this.userOrgDao.insert(userOrg);
        // 插入时同时想workGroupMember插入一条信息,暂时不考虑其他社团差异因素
        WorkGroupMember workGroupMember = WorkGroupMember.builder()
                .chatGroupId(userOrg.getOrgId())
                .memberId(IdUtil.fastSimpleUUID())
                .userName(userOrg.getUserName())
                .userId(userOrg.getUserId())
                .userAccount(userOrg.getUserId())
                .build();
        this.workGroupMemberDao.insert(workGroupMember);
        return userOrg;
    }

    /**
     * 修改数据
     *
     * @param userOrg 实例对象
     * @return 实例对象
     */
    @Override
    public UserOrg update(UserOrg userOrg) {
        this.userOrgDao.update(userOrg);
        return this.queryById(userOrg.getUserOrgId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userOrgId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userOrgId) {
        return this.userOrgDao.deleteById(userOrgId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param userOrgIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] userOrgIds) {
        return this.userOrgDao.deleteByIds(userOrgIds) == userOrgIds.length;
    }
}