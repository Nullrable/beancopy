package com.lsd.beancopy;

import com.lsd.beancopy.model.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * @Author: lsd
 * @Description:
 * @Date:Create：in 2020-05-01 22:17
 * @Modified By：
 */
public class ModelGenetator {

    public static List<AppUser> createAppusers(int size){

        List<AppUser> list = new ArrayList<>();

        for(int i = 0; i < size; i++){

            list.add(creatAppUser(i));
        }

        return list;

    }

    public static AppUser creatAppUser(int i){

        AppUser appUser = new AppUser();

        appUser.setAppUserNum(i);
        appUser.setAppUserCode(i + "");
        appUser.setAppUserName(UUID.randomUUID().toString());
        appUser.setAppUserPassword(UUID.randomUUID().toString());
        appUser.setAppUserPhone("13756336363");
        appUser.setAppUserEmail("nnn@qq.com");
        appUser.setAppUserPwKey(UUID.randomUUID().toString());
        appUser.setAppUserPwEditTime(Calendar.getInstance().getTime());
        appUser.setAppUserOpenId(UUID.randomUUID().toString());

        appUser.setBranch(createBranch(i));
        appUser.setSystemRole(createSystemRole(i));

        List<AppParam> appParams = new ArrayList<>();
        appUser.setAppParamList(appParams);
        appUser.getAppParamList().add(new AppParam("key", "ttt"));

        return appUser;
    }


    private static Branch createBranch(int i){
        Branch branch = new Branch();
        branch.setBranchNum(i);
        branch.setBranchCode( i + "");
        branch.setBranchName("lsd");
        branch.setBranchActived(true);
        branch.setBranchPostcode("1111");

        return branch;
    }

    private static SystemRole createSystemRole(int i){
        SystemRole systemRole = new SystemRole();
        systemRole.setBranchNum(i);
        systemRole.setSystemRoleNum(i);
        systemRole.setSystemRoleName("管理员");

        List<PrivilegeResource> privilegeResources = new ArrayList<>();
        privilegeResources.add(new PrivilegeResource("KEY", "CESHI"));

        systemRole.setPrivilegeResourceList(privilegeResources);

        return systemRole;
    }
}
