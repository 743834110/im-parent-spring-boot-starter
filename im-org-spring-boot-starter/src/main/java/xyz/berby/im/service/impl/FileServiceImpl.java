package xyz.berby.im.service.impl;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.File;
import xyz.berby.im.dao.FileDao;
import xyz.berby.im.service.FileService;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件表(File)表服务实现类
 *
 * @author litianfeng
 * @since 2018-12-12 12:39:18
 */
@Service("fileService")
@Transactional
public class FileServiceImpl implements FileService {
    @Resource
    private FileDao fileDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 实例对象
     */
    @Override
    public File queryById(String fileId) {
        return this.fileDao.queryById(fileId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<File> queryAllByLimit(int offset, int limit) {
        return this.fileDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 
     * 根据分页对象查询数据
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<File> queryByPager(Pager<File> pager) {
        pager = this.countByPager(pager);                
        List<File> result = fileDao.queryByPager(pager);
        pager.setResult(result);
        return pager;
     }

    /**
     * 根据分页对象统计记录条数
     * @param pager 分页对象
     * @return 对象列表
     */
    public Pager<File> countByPager(Pager<File> pager) {
        int size = fileDao.countByPager(pager);
        pager.setSize(size);
        return pager;
    }
    /**
     * 新增数据
     *
     * @param file 实例对象
     * @return 实例对象
     */
    @Override
    public File insert(File file) {
        this.fileDao.insert(file);
        return file;
    }

    /**
     * 修改数据
     *
     * @param file 实例对象
     * @return 实例对象
     */
    @Override
    public File update(File file) {
        this.fileDao.update(file);
        return this.queryById(file.getFileId());
    }

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String fileId) {
        return this.fileDao.deleteById(fileId) > 0;
    }
    
    /**
     * 通过主键数组删除数据
     * @param fileIds 主键数组
     * @return 操作结果
     */
     @Override
    public boolean deleteByIds(String[] fileIds) {
        return this.fileDao.deleteByIds(fileIds) == fileIds.length;
    }
}