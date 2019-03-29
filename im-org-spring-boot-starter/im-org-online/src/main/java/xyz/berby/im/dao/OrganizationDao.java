package xyz.berby.im.dao;

import xyz.berby.im.entity.Organization;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 部门表 org_type: 社团 机构 班级 pro_type 专业类型(Organization)表数据库访问层
 *
 * @author makejava
 * @since 2019-03-03 10:31:11
 */
 
public interface OrganizationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orgId 主键
     * @return 实例对象
     */
    Organization queryById(String orgId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Organization> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param organization 实例对象
     * @return 对象列表
     */
    List<Organization> queryAll(Organization organization);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<Organization> queryByPager(Pager<Organization> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<Organization> pager);
    
    /**
     * 新增数据
     *
     * @param organization 实例对象
     * @return 影响行数
     */
    int insert(Organization organization);

    /**
     * 修改数据
     *
     * @param organization 实例对象
     * @return 影响行数
     */
    int update(Organization organization);

    /**
     * 通过主键删除数据
     *
     * @param orgId 主键
     * @return 影响行数
     */
    int deleteById(String orgId);
    
    /**
     * 通过主键数组删除数据
     * @param orgIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] orgIds);
}