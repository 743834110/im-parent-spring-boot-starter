package xyz.berby.im.dao;

import xyz.berby.im.entity.File;
import xyz.berby.im.vo.Pager;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 文件表(File)表数据库访问层
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
 
public interface FileDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 实例对象
     */
    File queryById(String fileId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<File> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param file 实例对象
     * @return 对象列表
     */
    List<File> queryAll(File file);

    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
    List<File> queryByPager(Pager<File> pager);

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    int countByPager(Pager<File> pager);
    
    /**
     * 新增数据
     *
     * @param file 实例对象
     * @return 影响行数
     */
    int insert(File file);

    /**
     * 修改数据
     *
     * @param file 实例对象
     * @return 影响行数
     */
    int update(File file);

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 影响行数
     */
    int deleteById(String fileId);
    
    /**
     * 通过主键数组删除数据
     * @param fileIds 主键数组
     * @return 影响样数
     */
    int deleteByIds(String[] fileIds);
}