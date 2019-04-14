package xyz.berby.im.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.berby.im.annotation.DefaultValue;
import xyz.berby.im.constant.Constant;
import xyz.berby.im.entity.Feedback;
import xyz.berby.im.dao.FeedbackDao;
import xyz.berby.im.property.DefaultSettingProperty;
import xyz.berby.im.service.FeedbackService;
import xyz.berby.im.util.IpUtil;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * (Feedback)表服务实现类
 *
 * @author makejava
 * @since 2019-04-01 17:30:55
 */
@Service("feedbackService")
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackDao feedbackDao;

    @Autowired
    private DefaultSettingProperty property;


    /**
     * 通过ID查询单条数据
     *
     * @param feedbackId 主键
     * @return 实例对象
     */
    @Override
    public Feedback queryById(String feedbackId) {
        return this.feedbackDao.queryById(feedbackId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Feedback> queryAllByLimit(int offset, int limit) {
        return this.feedbackDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Feedback> queryByPager(Pager<Feedback> pager) {
        pager = this.countByPager(pager);                
        List<Feedback> result = feedbackDao.queryByPager(pager);
        // 确定本地文件保存配置
         Map<String, Object> setting = this.property.getSetting();
         String temp = null;
         if (Constant.LOCAL.equals(setting.get(DefaultSettingProperty.STORAGE_MODE))) {
             temp = IpUtil.getServerIpAddress();
         }

         final String webRoot = temp;
         result.forEach(feedback -> {
            String one = feedback.getImageUrlOne();
            String two = feedback.getImageUrlTwo();
            if (one != null) {
                feedback.setImageUrlOne(webRoot + one);
            }
            if (two != null) {
                feedback.setImageUrlTwo(webRoot + two);
            }
        });
        pager.setResult(result);
        return pager;
     }
     
   /**
     * 
     * 根据分页对象查询数据,不计算页数
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<Feedback> queryByPagerWithNoCount(Pager<Feedback> pager) {         
        List<Feedback> result = feedbackDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<Feedback> countByPager(Pager<Feedback> pager) {
        int size = feedbackDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    @Override
    @DefaultValue(expression = "0.pubUserId=user.userId")
    public Feedback insert(Feedback feedback) {
        feedback.setFeedbackId(IdUtil.fastSimpleUUID());
        feedback.setRead("N");
        this.feedbackDao.insert(feedback);
        return feedback;
    }

    /**
     * 修改数据
     *
     * @param feedback 实例对象
     * @return 实例对象
     */
    @Override
    @DefaultValue(expression = "0.userId=user.userId")
    public Feedback update(Feedback feedback) {
        this.feedbackDao.update(feedback);
        return this.queryById(feedback.getFeedbackId());
    }

    /**
     * 通过主键删除数据
     *
     * @param feedbackId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String feedbackId) {
        return this.feedbackDao.deleteById(feedbackId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param feedbackIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] feedbackIds) {
        return this.feedbackDao.deleteByIds(feedbackIds) == feedbackIds.length;
    }
}