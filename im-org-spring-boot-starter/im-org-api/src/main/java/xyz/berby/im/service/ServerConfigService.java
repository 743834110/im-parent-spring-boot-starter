package xyz.berby.im.service;

import xyz.berby.im.entity.ServerConfig;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 服务器配置表(ServerConfig)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:16
 */
public interface ServerConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param configId 主键
     * @return 实例对象
     */
    ServerConfig queryById(String configId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ServerConfig> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<ServerConfig> queryByPager(Pager<ServerConfig> pager);

    Pager<ServerConfig> queryByPagerWithNoCount(Pager<ServerConfig> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<ServerConfig> countByPager(Pager<ServerConfig> pager);    
    /**
     * 新增数据
     *
     * @param serverConfig 实例对象
     * @return 实例对象
     */
    ServerConfig insert(ServerConfig serverConfig);

    /**
     * 修改数据
     *
     * @param serverConfig 实例对象
     * @return 实例对象
     */
    ServerConfig update(ServerConfig serverConfig);

    /**
     * 通过主键删除数据
     *
     * @param configId 主键
     * @return 是否成功
     */
    boolean deleteById(String configId);

    /**
     * 通过主键数组删除数据
     * @param configIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] configIds);    

}