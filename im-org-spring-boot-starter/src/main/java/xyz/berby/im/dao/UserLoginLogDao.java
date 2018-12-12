package xyz.berby.im.dao;

import xyz.berby.im.entity.UserLoginLog;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户登录日志表(UserLoginLog)表数据库访问层
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
 
public interface UserLoginLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param loginLogId 主键
     * @return 实例对象
     */
    UserLoginLog queryById(String loginLogId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserLoginLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userLoginLog 实例对象
     * @return 对象列表
     */
    List<UserLoginLog> queryAll(UserLoginLog userLoginLog);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<UserLoginLog> queryByPager(Pager<UserLoginLog> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<UserLoginLog> pager);
    
    /**
     * 新增数据
     *
     * @param userLoginLog 实例对象
     * @return 影响行数
     */
    int insert(UserLoginLog userLoginLog);

    /**
     * 修改数据
     *
     * @param userLoginLog 实例对象
     * @return 影响行数
     */
    int update(UserLoginLog userLoginLog);

    /**
     * 通过主键删除数据
     *
     * @param loginLogId 主键
     * @return 影响行数
     */
    int deleteById(String loginLogId);
    
    /**
     * 通过主键数组删除数据
     * @param loginLogIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] loginLogIds);
}