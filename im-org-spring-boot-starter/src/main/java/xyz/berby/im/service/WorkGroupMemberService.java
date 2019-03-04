package xyz.berby.im.service;

import xyz.berby.im.entity.WorkGroupMember;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 工作群成员表(WorkGroupMember)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:20
 */
public interface WorkGroupMemberService {

    /**
     * 通过ID查询单条数据
     *
     * @param memberId 主键
     * @return 实例对象
     */
    WorkGroupMember queryById(String memberId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WorkGroupMember> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<WorkGroupMember> queryByPager(Pager<WorkGroupMember> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<WorkGroupMember> countByPager(Pager<WorkGroupMember> pager);    
    /**
     * 新增数据
     *
     * @param workGroupMember 实例对象
     * @return 实例对象
     */
    WorkGroupMember insert(WorkGroupMember workGroupMember);

    /**
     * 修改数据
     *
     * @param workGroupMember 实例对象
     * @return 实例对象
     */
    WorkGroupMember update(WorkGroupMember workGroupMember);

    /**
     * 通过主键删除数据
     *
     * @param memberId 主键
     * @return 是否成功
     */
    boolean deleteById(String memberId);

    /**
     * 通过主键数组删除数据
     * @param memberIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] memberIds);    

}