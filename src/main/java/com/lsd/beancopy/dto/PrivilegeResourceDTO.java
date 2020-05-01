package com.lsd.beancopy.dto;

import lombok.Data;

/**
 * @Author: nhsoft.lsd
 * @Description:
 * @Date:Create：in 2020-05-01 22:15
 * @Modified By：
 */
@Data
public class PrivilegeResourceDTO {

    private String privilegeResourceKey;

    private String privilegeResourceName;

    private String privilegeResourceCategory;

    private String privilegeResourceContext;

    private String privilegeResourceParentKey;
}
