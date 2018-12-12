package xyz.berby.im.dao;

import xyz.berby.im.entity.User;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户表  user_type 学生 教师(User)表数据库访问层
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
 
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(String userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User user);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<User> queryByPager(Pager<User> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<User> pager);
    
    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(String userId);
    
    /**
     * 通过主键数组删除数据
     * @param userIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] userIds);
}