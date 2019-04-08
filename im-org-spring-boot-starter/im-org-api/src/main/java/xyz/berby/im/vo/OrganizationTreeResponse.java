package xyz.berby.im.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xyz.berby.im.entity.Organization;

import java.util.List;

/**
 * 组织响应树
 * @author lTF
 * Created on 2019/4/4
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationTreeResponse {
    /**
     * 学校机构
     */
    private Organization school;
    /**
     * 学生机构
     */
    private List<Organization> studentAgencies;
}
