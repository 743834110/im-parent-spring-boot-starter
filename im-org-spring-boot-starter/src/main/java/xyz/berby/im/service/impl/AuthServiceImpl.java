package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.Auth;
import xyz.berby.im.dao.AuthDao;
import xyz.berby.im.service.AuthService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 操作权限表(Auth)表服务实现类
 *
 * @author litianfeng
 * @since 2018-12-12 12:39:18
 */
@Service("authService")
@Transactional
public class AuthServiceImpl implements AuthService {
    @Resource
    private AuthDao authDao;

    /**
     * 通过ID查询单条数据
     *
     * @param authId 主键
     * @return 实例对象
     */
    @Override
    public Auth queryById(String authId) {
        return this.authDao.queryById(authId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Auth> queryAllByLimit(int offset, int limit) {
        return this.authDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Auth> queryByPager(Pager<Auth> pager) {
        pager = this.countByPager(pager);                
        List<Auth> result = authDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<Auth> countByPager(Pager<Auth> pager) {
        int size = authDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param auth 实例对象
     * @return 实例对象
     */
    @Override
    public Auth insert(Auth auth) {
        this.authDao.insert(auth);
        return auth;
    }

    /**
     * 修改数据
     *
     * @param auth 实例对象
     * @return 实例对象
     */
    @Override
    public Auth update(Auth auth) {
        this.authDao.update(auth);
        return this.queryById(auth.getAuthId());
    }

    /**
     * 通过主键删除数据
     *
     * @param authId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String authId) {
        return this.authDao.deleteById(authId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param authIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] authIds) {
        return this.authDao.deleteByIds(authIds) == authIds.length;
    }
}