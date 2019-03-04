package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.WorkGroupMember;
import xyz.berby.im.dao.WorkGroupMemberDao;
import xyz.berby.im.service.WorkGroupMemberService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作群成员表(WorkGroupMember)表服务实现类
 *
 * @author makejava
 * @since 2019-03-03 10:31:20
 */
@Service("workGroupMemberService")
@Transactional
public class WorkGroupMemberServiceImpl implements WorkGroupMemberService {
    @Resource
    private WorkGroupMemberDao workGroupMemberDao;

    /**
     * 通过ID查询单条数据
     *
     * @param memberId 主键
     * @return 实例对象
     */
    @Override
    public WorkGroupMember queryById(String memberId) {
        return this.workGroupMemberDao.queryById(memberId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<WorkGroupMember> queryAllByLimit(int offset, int limit) {
        return this.workGroupMemberDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<WorkGroupMember> queryByPager(Pager<WorkGroupMember> pager) {
        pager = this.countByPager(pager);                
        List<WorkGroupMember> result = workGroupMemberDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<WorkGroupMember> countByPager(Pager<WorkGroupMember> pager) {
        int size = workGroupMemberDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param workGroupMember 实例对象
     * @return 实例对象
     */
    @Override
    public WorkGroupMember insert(WorkGroupMember workGroupMember) {
        this.workGroupMemberDao.insert(workGroupMember);
        return workGroupMember;
    }

    /**
     * 修改数据
     *
     * @param workGroupMember 实例对象
     * @return 实例对象
     */
    @Override
    public WorkGroupMember update(WorkGroupMember workGroupMember) {
        this.workGroupMemberDao.update(workGroupMember);
        return this.queryById(workGroupMember.getMemberId());
    }

    /**
     * 通过主键删除数据
     *
     * @param memberId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String memberId) {
        return this.workGroupMemberDao.deleteById(memberId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param memberIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] memberIds) {
        return this.workGroupMemberDao.deleteByIds(memberIds) == memberIds.length;
    }
}