package xyz.berby.im.service;

import xyz.berby.im.entity.Message;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 聊天信息表(Message)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:10
 */
public interface MessageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Message queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Message> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<Message> queryByPager(Pager<Message> pager);

    Pager<Message> queryByPagerWithNoCount(Pager<Message> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<Message> countByPager(Pager<Message> pager);    
    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    Message insert(Message message);

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    Message update(Message message);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    /**
     * 通过主键数组删除数据
     * @param ids 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] ids);    

}