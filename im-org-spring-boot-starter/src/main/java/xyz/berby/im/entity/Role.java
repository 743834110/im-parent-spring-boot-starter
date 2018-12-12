package xyz.berby.im.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 角色表(Role)实体类
 *
 * @author litianfeng
 * @since 2018-12-12 12:32:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = -68693532171490746L;
        private String roleId;
    /**
     *角色名称
     */
    private String roleName;
    /**
     *角色描述
     */
    private String roleDescription;


}