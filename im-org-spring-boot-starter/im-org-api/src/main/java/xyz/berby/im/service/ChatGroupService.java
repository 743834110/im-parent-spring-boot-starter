package xyz.berby.im.service;

import xyz.berby.im.entity.ChatGroup;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 工作群表(ChatGroup)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:03
 */
public interface ChatGroupService {

    /**
     * 通过ID查询单条数据
     *
     * @param groupId 主键
     * @return 实例对象
     */
    ChatGroup queryById(String groupId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ChatGroup> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<ChatGroup> queryByPager(Pager<ChatGroup> pager);

    Pager<ChatGroup> queryByPagerWithNoCount(Pager<ChatGroup> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<ChatGroup> countByPager(Pager<ChatGroup> pager);    
    /**
     * 新增数据
     *
     * @param chatGroup 实例对象
     * @return 实例对象
     */
    ChatGroup insert(ChatGroup chatGroup);

    /**
     * 修改数据
     *
     * @param chatGroup 实例对象
     * @return 实例对象
     */
    ChatGroup update(ChatGroup chatGroup);

    /**
     * 通过主键删除数据
     *
     * @param groupId 主键
     * @return 是否成功
     */
    boolean deleteById(String groupId);

    /**
     * 通过主键数组删除数据
     * @param groupIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] groupIds);    

}