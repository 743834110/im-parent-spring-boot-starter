package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 收藏表  collection_type: 简单文本 文件 访问内容(Collect)实体类
 *
 * @author makejava
 * @since 2019-03-03 10:31:04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Collect implements Serializable {
    private static final long serialVersionUID = -57449659084526921L;
        private String collectionId;
    /**
     *用户ID
     */
    private String userId;
    /**
     *创建日期
     */
    private Date createTime;
    /**
     *收藏类型
     */
    private String collectionType;
    /**
     *收藏内容
     */
    private String content;


}