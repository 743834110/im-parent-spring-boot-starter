package xyz.berby.im.dao;

import xyz.berby.im.entity.WorkGroupMember;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 工作群成员表(WorkGroupMember)表数据库访问层
 *
 * @author makejava
 * @since 2019-03-03 10:31:20
 */
 
public interface WorkGroupMemberDao {

    /**
     * 通过ID查询单条数据
     *
     * @param memberId 主键
     * @return 实例对象
     */
    WorkGroupMember queryById(String memberId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WorkGroupMember> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param workGroupMember 实例对象
     * @return 对象列表
     */
    List<WorkGroupMember> queryAll(WorkGroupMember workGroupMember);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<WorkGroupMember> queryByPager(Pager<WorkGroupMember> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<WorkGroupMember> pager);
    
    /**
     * 新增数据
     *
     * @param workGroupMember 实例对象
     * @return 影响行数
     */
    int insert(WorkGroupMember workGroupMember);

    /**
     * 修改数据
     *
     * @param workGroupMember 实例对象
     * @return 影响行数
     */
    int update(WorkGroupMember workGroupMember);

    /**
     * 通过主键删除数据
     *
     * @param memberId 主键
     * @return 影响行数
     */
    int deleteById(String memberId);
    
    /**
     * 通过主键数组删除数据
     * @param memberIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] memberIds);
}