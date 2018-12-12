package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.Routine;
import xyz.berby.im.dao.RoutineDao;
import xyz.berby.im.service.RoutineService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日常活动表  user_type: 直接是查询字段得到的学生或者老师等着两个身份，用来显示的，身份有为：学生、教师  此处留下user_id字段是为了知道是哪位用户发的消息  end_time和end字段之间的关系。(Routine)表服务实现类
 *
 * @author litianfeng
 * @since 2018-12-12 12:39:18
 */
@Service("routineService")
@Transactional
public class RoutineServiceImpl implements RoutineService {
    @Resource
    private RoutineDao routineDao;

    /**
     * 通过ID查询单条数据
     *
     * @param routineId 主键
     * @return 实例对象
     */
    @Override
    public Routine queryById(String routineId) {
        return this.routineDao.queryById(routineId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Routine> queryAllByLimit(int offset, int limit) {
        return this.routineDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Routine> queryByPager(Pager<Routine> pager) {
        pager = this.countByPager(pager);                
        List<Routine> result = routineDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<Routine> countByPager(Pager<Routine> pager) {
        int size = routineDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param routine 实例对象
     * @return 实例对象
     */
    @Override
    public Routine insert(Routine routine) {
        this.routineDao.insert(routine);
        return routine;
    }

    /**
     * 修改数据
     *
     * @param routine 实例对象
     * @return 实例对象
     */
    @Override
    public Routine update(Routine routine) {
        this.routineDao.update(routine);
        return this.queryById(routine.getRoutineId());
    }

    /**
     * 通过主键删除数据
     *
     * @param routineId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String routineId) {
        return this.routineDao.deleteById(routineId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param routineIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] routineIds) {
        return this.routineDao.deleteByIds(routineIds) == routineIds.length;
    }
}