package xyz.berby.im.dao;

import xyz.berby.im.entity.UserOrg;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户部门（班级）表(UserOrg)表数据库访问层
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
 
public interface UserOrgDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userOrgId 主键
     * @return 实例对象
     */
    UserOrg queryById(String userOrgId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserOrg> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userOrg 实例对象
     * @return 对象列表
     */
    List<UserOrg> queryAll(UserOrg userOrg);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<UserOrg> queryByPager(Pager<UserOrg> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<UserOrg> pager);
    
    /**
     * 新增数据
     *
     * @param userOrg 实例对象
     * @return 影响行数
     */
    int insert(UserOrg userOrg);

    /**
     * 修改数据
     *
     * @param userOrg 实例对象
     * @return 影响行数
     */
    int update(UserOrg userOrg);

    /**
     * 通过主键删除数据
     *
     * @param userOrgId 主键
     * @return 影响行数
     */
    int deleteById(String userOrgId);
    
    /**
     * 通过主键数组删除数据
     * @param userOrgIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] userOrgIds);
}