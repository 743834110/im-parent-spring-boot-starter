package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.UserLoginLog;
import xyz.berby.im.dao.UserLoginLogDao;
import xyz.berby.im.service.UserLoginLogService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户登录日志表(UserLoginLog)表服务实现类
 *
 * @author makejava
 * @since 2019-03-03 10:31:18
 */
@Service("userLoginLogService")
@Transactional
public class UserLoginLogServiceImpl implements UserLoginLogService {
    @Resource
    private UserLoginLogDao userLoginLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param loginLogId 主键
     * @return 实例对象
     */
    @Override
    public UserLoginLog queryById(String loginLogId) {
        return this.userLoginLogDao.queryById(loginLogId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserLoginLog> queryAllByLimit(int offset, int limit) {
        return this.userLoginLogDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<UserLoginLog> queryByPager(Pager<UserLoginLog> pager) {
        pager = this.countByPager(pager);                
        List<UserLoginLog> result = userLoginLogDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<UserLoginLog> countByPager(Pager<UserLoginLog> pager) {
        int size = userLoginLogDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param userLoginLog 实例对象
     * @return 实例对象
     */
    @Override
    public UserLoginLog insert(UserLoginLog userLoginLog) {
        this.userLoginLogDao.insert(userLoginLog);
        return userLoginLog;
    }

    /**
     * 修改数据
     *
     * @param userLoginLog 实例对象
     * @return 实例对象
     */
    @Override
    public UserLoginLog update(UserLoginLog userLoginLog) {
        this.userLoginLogDao.update(userLoginLog);
        return this.queryById(userLoginLog.getLoginLogId());
    }

    /**
     * 通过主键删除数据
     *
     * @param loginLogId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String loginLogId) {
        return this.userLoginLogDao.deleteById(loginLogId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param loginLogIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] loginLogIds) {
        return this.userLoginLogDao.deleteByIds(loginLogIds) == loginLogIds.length;
    }
}