package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.ServerConfig;
import xyz.berby.im.dao.ServerConfigDao;
import xyz.berby.im.service.ServerConfigService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务器配置表(ServerConfig)表服务实现类
 *
 * @author litianfeng
 * @since 2018-12-12 12:39:18
 */
@Service("serverConfigService")
@Transactional
public class ServerConfigServiceImpl implements ServerConfigService {
    @Resource
    private ServerConfigDao serverConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param configId 主键
     * @return 实例对象
     */
    @Override
    public ServerConfig queryById(String configId) {
        return this.serverConfigDao.queryById(configId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ServerConfig> queryAllByLimit(int offset, int limit) {
        return this.serverConfigDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<ServerConfig> queryByPager(Pager<ServerConfig> pager) {
        pager = this.countByPager(pager);                
        List<ServerConfig> result = serverConfigDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<ServerConfig> countByPager(Pager<ServerConfig> pager) {
        int size = serverConfigDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param serverConfig 实例对象
     * @return 实例对象
     */
    @Override
    public ServerConfig insert(ServerConfig serverConfig) {
        this.serverConfigDao.insert(serverConfig);
        return serverConfig;
    }

    /**
     * 修改数据
     *
     * @param serverConfig 实例对象
     * @return 实例对象
     */
    @Override
    public ServerConfig update(ServerConfig serverConfig) {
        this.serverConfigDao.update(serverConfig);
        return this.queryById(serverConfig.getConfigId());
    }

    /**
     * 通过主键删除数据
     *
     * @param configId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String configId) {
        return this.serverConfigDao.deleteById(configId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param configIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] configIds) {
        return this.serverConfigDao.deleteByIds(configIds) == configIds.length;
    }
}