package com.lsd.beancopy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: nhsoft.lsd
 * @Description:
 * @Date:Create：in 2020-05-01 22:15
 * @Modified By：
 */
@Data
@AllArgsConstructor
public class PrivilegeResource {

    private String privilegeResourceKey;

    private String privilegeResourceName;

    private String privilegeResourceCategory;

    private String privilegeResourceContext;

    private String privilegeResourceParentKey;

    public PrivilegeResource() {
    }

    public PrivilegeResource(String privilegeResourceKey, String privilegeResourceName) {
        this.privilegeResourceKey = privilegeResourceKey;
        this.privilegeResourceName = privilegeResourceName;
    }
}
