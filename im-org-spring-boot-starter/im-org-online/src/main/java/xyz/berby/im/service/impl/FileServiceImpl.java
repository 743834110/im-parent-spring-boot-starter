package xyz.berby.im.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;
import xyz.berby.im.entity.File;
import xyz.berby.im.dao.FileDao;
import xyz.berby.im.entity.User;
import xyz.berby.im.property.DefaultSettingProperty;
import xyz.berby.im.service.FileService;
import xyz.berby.im.util.ApplicationContextHolder;
import xyz.berby.im.vo.Pager;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 文件表(File)表服务实现类
 *
 * @author makejava
 * @since 2019-04-01 17:30:55
 */
@Service("fileService")
@Transactional
public class FileServiceImpl implements FileService {
    @Resource
    private FileDao fileDao;

    @Autowired
    private DefaultSettingProperty property;


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
     * 
     * 根据分页对象查询数据,不计算页数
     * @param pager 分页对象
     * @return 对象列表
     */
     public Pager<File> queryByPagerWithNoCount(Pager<File> pager) {         
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
        file.setFileId(IdUtil.fastSimpleUUID());
        this.fileDao.insert(file);

        return file;
    }

    /**
     * 进行文件上传
     * @param multipartFile
     * @return
     */
    public File upload(MultipartFile multipartFile, File newFile, User user) throws IOException {
        Map<String, Object> setting = this.property.getSetting();
        String storageMode = (String) setting.get(DefaultSettingProperty.STORAGE_MODE);
        // 本地模式
        if ("local".equals(storageMode)) {
            String uploadDir = (String) setting.get(DefaultSettingProperty.UPLOAD_FOLDER);
            String resourcePrefix = (String) setting.get(DefaultSettingProperty.RESOURCE_PREFIX);
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            String fileName = IdUtil.fastSimpleUUID();
            // 设置基本值
            String originName = multipartFile.getOriginalFilename() == null? "": multipartFile.getOriginalFilename();
            java.io.File file = new java.io.File(uploadDir,  fileName + originName.substring(originName.lastIndexOf('.')));
            FileUtil.mkParentDirs(file);
            newFile.setFilePath(resourcePrefix + java.io.File.separator + file.getName());
            newFile.setCreateTime(new Date());
            newFile.setFileSize((double) multipartFile.getSize());
            newFile.setMimeType(multipartFile.getContentType());
            newFile.setOriginName(multipartFile.getOriginalFilename());
            newFile.setValid("Y");
            newFile.setUserId(user.getUserId());
            newFile.setFileId(fileName);
            this.insert(newFile);
            // 进行文件的存储
            multipartFile.transferTo(file);
        }
        // 三方服务器托管模式
        else {

        }
        return newFile;
    }

    public File[] uploadFiles(MultipartFile[] multipartFiles) {

        File[] files = new File[multipartFiles.length];
        return files;
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