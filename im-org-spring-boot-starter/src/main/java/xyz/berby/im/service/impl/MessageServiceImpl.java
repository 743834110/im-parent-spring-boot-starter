package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.Message;
import xyz.berby.im.dao.MessageDao;
import xyz.berby.im.service.MessageService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 聊天信息表(Message)表服务实现类
 *
 * @author litianfeng
 * @since 2018-12-12 12:39:18
 */
@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageDao messageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Message queryById(String id) {
        return this.messageDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Message> queryAllByLimit(int offset, int limit) {
        return this.messageDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Message> queryByPager(Pager<Message> pager) {
        pager = this.countByPager(pager);                
        List<Message> result = messageDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<Message> countByPager(Pager<Message> pager) {
        int size = messageDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public Message insert(Message message) {
        this.messageDao.insert(message);
        return message;
    }

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public Message update(Message message) {
        this.messageDao.update(message);
        return this.queryById(message.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.messageDao.deleteById(id) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param ids 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] ids) {
        return this.messageDao.deleteByIds(ids) == ids.length;
    }
}