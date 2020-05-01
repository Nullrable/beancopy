package com.lsd.beancopy.model;

import lombok.Data;

/**
 * @Author: nhsoft.lsd
 * @Description:
 * @Date:Create：in 2020-05-01 21:57
 * @Modified By：
 */
@Data
public class AppParam {

    private String paramName;
    private String paramText;

    public AppParam(String paramName, String paramText) {
        this.paramName = paramName;
        this.paramText = paramText;
    }

    public AppParam() {
    }
}
