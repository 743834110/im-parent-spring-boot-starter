package xyz.berby.im.service;

import xyz.berby.im.entity.Auth;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 操作权限表(Auth)表服务接口
 *
 * @author makejava
 * @since 2019-04-01 17:37:55
 */
public interface AuthService {

    /**
     * 通过ID查询单条数据
     *
     * @param authId 主键
     * @return 实例对象
     */
    Auth queryById(String authId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Auth> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<Auth> queryByPager(Pager<Auth> pager);

    /**
     *
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<Auth> queryByPagerWithNoCount(Pager<Auth> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<Auth> countByPager(Pager<Auth> pager);    
    /**
     * 新增数据
     *
     * @param auth 实例对象
     * @return 实例对象
     */
    Auth insert(Auth auth);

    /**
     * 修改数据
     *
     * @param auth 实例对象
     * @return 实例对象
     */
    Auth update(Auth auth);

    /**
     * 通过主键删除数据
     *
     * @param authId 主键
     * @return 是否成功
     */
    boolean deleteById(String authId);

    /**
     * 通过主键数组删除数据
     * @param authIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] authIds);    

}