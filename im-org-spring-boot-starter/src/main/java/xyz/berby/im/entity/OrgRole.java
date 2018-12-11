package xyz.berby.im.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (OrgRole)实体类
 *
 * @author makejava
 * @since 2018-12-11 11:39:32
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrgRole implements Serializable {
    private static final long serialVersionUID = -60078969884326179L;
    
    private String orgRoleId;
    
    private String orgId;
    
    private Double orgRoleNumbers;
    
    private String roleId;
    
    private String roleName;

}