package xyz.berby.im.dao;

import xyz.berby.im.entity.ServerConfig;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 服务器配置表(ServerConfig)表数据库访问层
 *
 * @author makejava
 * @since 2019-03-03 10:31:16
 */
 
public interface ServerConfigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param configId 主键
     * @return 实例对象
     */
    ServerConfig queryById(String configId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ServerConfig> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param serverConfig 实例对象
     * @return 对象列表
     */
    List<ServerConfig> queryAll(ServerConfig serverConfig);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<ServerConfig> queryByPager(Pager<ServerConfig> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<ServerConfig> pager);
    
    /**
     * 新增数据
     *
     * @param serverConfig 实例对象
     * @return 影响行数
     */
    int insert(ServerConfig serverConfig);

    /**
     * 修改数据
     *
     * @param serverConfig 实例对象
     * @return 影响行数
     */
    int update(ServerConfig serverConfig);

    /**
     * 通过主键删除数据
     *
     * @param configId 主键
     * @return 影响行数
     */
    int deleteById(String configId);
    
    /**
     * 通过主键数组删除数据
     * @param configIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] configIds);
}