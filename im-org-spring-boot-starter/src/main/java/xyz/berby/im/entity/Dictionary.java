package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 字典表(Dictionary)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary implements Serializable {
    private static final long serialVersionUID = 927416368815504279L;
    /**
     *字典ID
     */
    private String dictionaryId;
    /**
     *分类类别
     */
    private String codeItemId;
    /**
     *具体分类ID
     */
    private String codeId;
    /**
     *具体分类名称
     */
    private String codeName;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *创建人ID
     */
    private String createPerson;
    /**
     *修改时间
     */
    private Date modifyTime;
    /**
     *修改人ID
     */
    private String modifyPerson;
    /**
     *父级节点
     */
    private String parentCodeId;


}