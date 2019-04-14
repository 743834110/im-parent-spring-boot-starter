package xyz.berby.im.service.impl.app;

import org.springframework.transaction.annotation.Transactional;
import xyz.berby.im.constant.Constant;
import xyz.berby.im.dao.OrganizationDao;
import xyz.berby.im.entity.Organization;
import xyz.berby.im.entity.UserOrg;
import xyz.berby.im.service.app.AppUserOrgService;
import xyz.berby.im.service.impl.UserOrgServiceImpl;
import org.springframework.stereotype.Service;
import xyz.berby.im.vo.Pager;
import xyz.berby.im.vo.UserOrgStructureResponse;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户部门（班级）表(UserOrg)表服务实现类
 *
 * @author makejava
 * @since 2019-04-14 15:48:43
 */
@Service("appUserOrgService")
@Transactional
public class AppUserOrgServiceImpl extends UserOrgServiceImpl implements AppUserOrgService {

    @Resource
    protected OrganizationDao organizationDao;

    /**
     * 组织架构查询
     * 如果是班级类型，则直接查询本班级成员
     * 其他的类型就是查找子部门，然后再查找子部门成员
     * @param pager 查询vo类
     * @return object
     */
    public List<UserOrgStructureResponse> queryStructureByPager(Pager<UserOrg> pager) {
        UserOrg queryObject = pager.getParam();
        // 根据orgId查询:直接取得orgName.
        List<UserOrgStructureResponse> responseList = new ArrayList<>();
        switch (queryObject.getOrgType()) {
            case Constant.CLASS:
                Organization org = this.organizationDao.queryById(queryObject.getOrgId());
                UserOrgStructureResponse response = new UserOrgStructureResponse();
                List<UserOrg> userOrgList = this.userOrgDao.queryAll(UserOrg.builder()
                        .orgId(queryObject.getOrgId())
                        .build());
                response.setOrgName(org.getShortName());
                response.setUserOrgList(userOrgList);
                response.setOrgId(org.getOrgId());
                responseList.add(response);
                break;
            default:
                List<Organization> organizationList = this.organizationDao.queryAll(
                        Organization.builder()
                                .parentId(queryObject.getOrgId())
                                .build());
                // 获取每个子部门的成员，其实可以这样做，查询完再进行结果的合并
                organizationList.forEach(organization -> {
                    UserOrgStructureResponse element = new UserOrgStructureResponse(
                            organization.getOrgId(),
                            organization.getOrgName(),
                            null);
                    List<UserOrg> list = this.userOrgDao.queryAll(UserOrg.builder()
                            .orgId(organization.getOrgId())
                            .build());
                    element.setUserOrgList(list);
                    responseList.add(element);
                });
        }
        return responseList;
    }
}