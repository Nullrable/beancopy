package com.lsd.beancopy.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: nhsoft.lsd
 * @Description:
 * @Date:Create：in 2020-05-01 21:54
 * @Modified By：
 */
@Data
public class AppUserDTO {

    private Integer appUserNum;

    private String appUserCode;

    private String appUserName;

    private String appUserPassword;

    private String appUserPhone;

    private String appUserEmail;

    private String appUserPwKey;

    private Date appUserPwEditTime;

    private String appUserSecurityCode;

    private Date appUserSecuritySendTime;

    private String appUserOpenId;

    private BranchDTO branch;

    private SystemRoleDTO systemRole;

    private List<AppParamDTO> appParamList;


}
