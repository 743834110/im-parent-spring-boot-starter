package xyz.berby.im.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import xyz.berby.im.entity.UserOrg;

import java.util.List;

/**
 * @author LTF
 * Created on 2019/4/14
 * 查询某机构组织结构响应视图对象
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserOrgStructureResponse {

    /**
     * ID
     */
    String orgId;
    /**
     * 父组织名称
     */
    String orgName;
    /**
     * 该层组织人员
     */
    List<UserOrg> userOrgList;

}
