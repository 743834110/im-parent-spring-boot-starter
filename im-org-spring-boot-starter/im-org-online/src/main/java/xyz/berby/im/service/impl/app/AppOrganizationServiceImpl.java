package xyz.berby.im.service.impl.app;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.entity.Organization;
import xyz.berby.im.service.impl.OrganizationServiceImpl;
import xyz.berby.im.service.app.AppOrganizationService;
import org.springframework.stereotype.Service;
import xyz.berby.im.vo.OrganizationTreeResponse;
import xyz.berby.im.vo.Pager;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门表 org_type: 社团 机构 班级 pro_type 专业类型(Organization)表服务实现类
 *
 * @author makejava
 * @since 2019-04-04 23:25:49
 */
@Service("appOrganizationService")
@Transactional
public class AppOrganizationServiceImpl extends OrganizationServiceImpl implements AppOrganizationService {

    private final static String STUDENT_AGENCY = "STUDENT_AGENCY";

    /**
     * 查询组织结构树
     * 先查询得出顶层机构二级学院，然后遍历每个二级学院的中的学生机构
     * @return list
     */
    public List<OrganizationTreeResponse> queryOrgTreeByPager(Pager<Organization> pager) {
        List<OrganizationTreeResponse> responses = new ArrayList<>();
        List<Organization> organizationList = this.organizationDao.queryByPager(pager);
        organizationList.forEach(organization -> {
            List<Organization> studentAgencies = this.organizationDao.queryByPager(new Pager<>(Organization.builder()
                    .orgType(STUDENT_AGENCY)
                    .parentId(organization.getOrgId())
                    .build()));
            OrganizationTreeResponse response = new OrganizationTreeResponse(organization, studentAgencies);
            responses.add(response);
        });
        return responses;
    }
}