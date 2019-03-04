package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.ChatGroup;
import xyz.berby.im.dao.ChatGroupDao;
import xyz.berby.im.service.ChatGroupService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作群表(ChatGroup)表服务实现类
 *
 * @author makejava
 * @since 2019-03-03 10:31:03
 */
@Service("chatGroupService")
@Transactional
public class ChatGroupServiceImpl implements ChatGroupService {
    @Resource
    private ChatGroupDao chatGroupDao;

    /**
     * 通过ID查询单条数据
     *
     * @param groupId 主键
     * @return 实例对象
     */
    @Override
    public ChatGroup queryById(String groupId) {
        return this.chatGroupDao.queryById(groupId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ChatGroup> queryAllByLimit(int offset, int limit) {
        return this.chatGroupDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<ChatGroup> queryByPager(Pager<ChatGroup> pager) {
        pager = this.countByPager(pager);                
        List<ChatGroup> result = chatGroupDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<ChatGroup> countByPager(Pager<ChatGroup> pager) {
        int size = chatGroupDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param chatGroup 实例对象
     * @return 实例对象
     */
    @Override
    public ChatGroup insert(ChatGroup chatGroup) {
        this.chatGroupDao.insert(chatGroup);
        return chatGroup;
    }

    /**
     * 修改数据
     *
     * @param chatGroup 实例对象
     * @return 实例对象
     */
    @Override
    public ChatGroup update(ChatGroup chatGroup) {
        this.chatGroupDao.update(chatGroup);
        return this.queryById(chatGroup.getGroupId());
    }

    /**
     * 通过主键删除数据
     *
     * @param groupId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String groupId) {
        return this.chatGroupDao.deleteById(groupId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param groupIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] groupIds) {
        return this.chatGroupDao.deleteByIds(groupIds) == groupIds.length;
    }
}