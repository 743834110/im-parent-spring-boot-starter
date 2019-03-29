package xyz.berby.im.service;

import xyz.berby.im.entity.User;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 用户表  user_type 学生 教师(User)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:17
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(String userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<User> queryByPager(Pager<User> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<User> countByPager(Pager<User> pager);    
    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(String userId);

    /**
     * 通过主键数组删除数据
     * @param userIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] userIds);    

}