package xyz.berby.im.service;

import xyz.berby.im.entity.RoleAuth;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 角色权限表(RoleAuth)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:14
 */
public interface RoleAuthService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleAuthId 主键
     * @return 实例对象
     */
    RoleAuth queryById(String roleAuthId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleAuth> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<RoleAuth> queryByPager(Pager<RoleAuth> pager);

    Pager<RoleAuth> queryByPagerWithNoCount(Pager<RoleAuth> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<RoleAuth> countByPager(Pager<RoleAuth> pager);    
    /**
     * 新增数据
     *
     * @param roleAuth 实例对象
     * @return 实例对象
     */
    RoleAuth insert(RoleAuth roleAuth);

    /**
     * 修改数据
     *
     * @param roleAuth 实例对象
     * @return 实例对象
     */
    RoleAuth update(RoleAuth roleAuth);

    /**
     * 通过主键删除数据
     *
     * @param roleAuthId 主键
     * @return 是否成功
     */
    boolean deleteById(String roleAuthId);

    /**
     * 通过主键数组删除数据
     * @param roleAuthIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] roleAuthIds);    

}