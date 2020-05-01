package com.lsd.beancopy.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: nhsoft.lsd
 * @Description:
 * @Date:Create：in 2020-05-01 21:55
 * @Modified By：
 */
@Data
public class SystemRoleDTO {

    private Integer systemRoleNum;

    private Integer branchNum;

    private String systemRoleName;

    private List<PrivilegeResourceDTO> privilegeResourceList;
}
