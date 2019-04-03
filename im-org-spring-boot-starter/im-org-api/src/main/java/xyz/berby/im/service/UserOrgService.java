package xyz.berby.im.service;

import xyz.berby.im.entity.UserOrg;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 用户部门（班级）表(UserOrg)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:19
 */
public interface UserOrgService {

    /**
     * 通过ID查询单条数据
     *
     * @param userOrgId 主键
     * @return 实例对象
     */
    UserOrg queryById(String userOrgId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserOrg> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<UserOrg> queryByPager(Pager<UserOrg> pager);

    Pager<UserOrg> queryByPagerWithNoCount(Pager<UserOrg> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<UserOrg> countByPager(Pager<UserOrg> pager);    
    /**
     * 新增数据
     *
     * @param userOrg 实例对象
     * @return 实例对象
     */
    UserOrg insert(UserOrg userOrg);

    /**
     * 修改数据
     *
     * @param userOrg 实例对象
     * @return 实例对象
     */
    UserOrg update(UserOrg userOrg);

    /**
     * 通过主键删除数据
     *
     * @param userOrgId 主键
     * @return 是否成功
     */
    boolean deleteById(String userOrgId);

    /**
     * 通过主键数组删除数据
     * @param userOrgIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] userOrgIds);    

}