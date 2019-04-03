package xyz.berby.im.service;

import xyz.berby.im.entity.UserLoginLog;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 用户登录日志表(UserLoginLog)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:18
 */
public interface UserLoginLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param loginLogId 主键
     * @return 实例对象
     */
    UserLoginLog queryById(String loginLogId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserLoginLog> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<UserLoginLog> queryByPager(Pager<UserLoginLog> pager);

    Pager<UserLoginLog> queryByPagerWithNoCount(Pager<UserLoginLog> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<UserLoginLog> countByPager(Pager<UserLoginLog> pager);    
    /**
     * 新增数据
     *
     * @param userLoginLog 实例对象
     * @return 实例对象
     */
    UserLoginLog insert(UserLoginLog userLoginLog);

    /**
     * 修改数据
     *
     * @param userLoginLog 实例对象
     * @return 实例对象
     */
    UserLoginLog update(UserLoginLog userLoginLog);

    /**
     * 通过主键删除数据
     *
     * @param loginLogId 主键
     * @return 是否成功
     */
    boolean deleteById(String loginLogId);

    /**
     * 通过主键数组删除数据
     * @param loginLogIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] loginLogIds);    

}