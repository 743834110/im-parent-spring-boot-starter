package xyz.berby.im.service;

import xyz.berby.im.entity.File;
import xyz.berby.im.vo.Pager;
import java.util.List;



/**
 * 文件表(File)表服务接口
 *
 * @author makejava
 * @since 2019-03-03 10:31:09
 */
public interface FileService {

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 实例对象
     */
    File queryById(String fileId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<File> queryAllByLimit(int offset, int limit);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     Pager<File> queryByPager(Pager<File> pager);

    Pager<File> queryByPagerWithNoCount(Pager<File> pager);
    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    Pager<File> countByPager(Pager<File> pager);    
    /**
     * 新增数据
     *
     * @param file 实例对象
     * @return 实例对象
     */
    File insert(File file);

    /**
     * 修改数据
     *
     * @param file 实例对象
     * @return 实例对象
     */
    File update(File file);

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 是否成功
     */
    boolean deleteById(String fileId);

    /**
     * 通过主键数组删除数据
     * @param fileIds 主键数组
     * @return 操作结果
     */
    boolean deleteByIds(String[] fileIds);    

}