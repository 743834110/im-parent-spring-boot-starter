package xyz.berby.im.entity;

import java.util.Date;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 字典类型表(DictionaryType)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryType implements Serializable {
    private static final long serialVersionUID = 813083392960767483L;
        private String codeItemId;
    /**
     *分类名称
     */
    private String codeItemName;
    /**
     *父节点编号
     */
    private String parentId;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *创建人ID
     */
    private String createPerson;
    /**
     *修改人ID
     */
    private String modifyPerson;
    /**
     *修改时间
     */
    private Date modifyTime;


}