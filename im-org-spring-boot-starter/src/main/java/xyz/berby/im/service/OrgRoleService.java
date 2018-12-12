package xyz.berby.im.service;

import xyz.berby.im.entity.OrgRole;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 组织角色表(OrgRole)表服务接口
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
public interface OrgRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param orgRoleId 主键
     * @return 实例对象
     */
    OrgRole queryById(String orgRoleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OrgRole> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<OrgRole> queryByPager(Pager<OrgRole> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<OrgRole> countByPager(Pager<OrgRole> pager);    
    /**
     * 新增数据
     *
     * @param orgRole 实例对象
     * @return 实例对象
     */
    OrgRole insert(OrgRole orgRole);

    /**
     * 修改数据
     *
     * @param orgRole 实例对象
     * @return 实例对象
     */
    OrgRole update(OrgRole orgRole);

    /**
     * 通过主键删除数据
     *
     * @param orgRoleId 主键
     * @return 是否成功
     */
    boolean deleteById(String orgRoleId);

    /**
     * 通过主键数组删除数据
     * @param orgRoleIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] orgRoleIds);    

}