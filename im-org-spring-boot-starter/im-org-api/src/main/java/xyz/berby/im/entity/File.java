package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 文件表(File)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:31:09
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class File implements Serializable {
    private static final long serialVersionUID = 720424574628317503L;
        private String fileId;
    /**
     *原文件名
     */
    private String originName;
    /**
     *文件大小(byte)
     */
    private Double fileSize;
    /**
     *上传时间
     */
    private Date createTime;
    /**
     *业务ID
     */
    private String busiId;
    /**
     *业务表名称
     */
    private String compId;
    /**
     *mime类型
     */
    private String mimeType;
    /**
     *创建者ID
     */
    private String userId;
    /**
     *是否有效
     */
    private String valid;
    /**
     *文件相对路径
     */
    private String filePath;


}