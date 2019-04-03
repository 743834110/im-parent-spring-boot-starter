package xyz.berby.im.service;

import xyz.berby.im.entity.Organization;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 部门表 org_type: 社团 机构 班级 pro_type 专业类型(Organization)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:11
 */
public interface OrganizationService {

    /**
     * 通过ID查询单条数据
     *
     * @param orgId 主键
     * @return 实例对象
     */
    Organization queryById(String orgId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Organization> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<Organization> queryByPager(Pager<Organization> pager);

    Pager<Organization> queryByPagerWithNoCount(Pager<Organization> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<Organization> countByPager(Pager<Organization> pager);    
    /**
     * 新增数据
     *
     * @param organization 实例对象
     * @return 实例对象
     */
    Organization insert(Organization organization);

    /**
     * 修改数据
     *
     * @param organization 实例对象
     * @return 实例对象
     */
    Organization update(Organization organization);

    /**
     * 通过主键删除数据
     *
     * @param orgId 主键
     * @return 是否成功
     */
    boolean deleteById(String orgId);

    /**
     * 通过主键数组删除数据
     * @param orgIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] orgIds);    

}