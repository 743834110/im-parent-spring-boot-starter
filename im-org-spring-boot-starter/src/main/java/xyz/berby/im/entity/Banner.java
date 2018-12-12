package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 横幅表(Banner)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Banner implements Serializable {
    private static final long serialVersionUID = -11662712967990758L;
        private String bannerId;
    /**
     *图像地址
     */
    private String bannerImageUrl;
    /**
     *横幅标题
     */
    private String bannerTitle;
    /**
     *日常活动ID
     */
    private String routineId;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *组织ID
     */
    private String orgId;


}