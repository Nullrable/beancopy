package com.lsd.beancopy.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: lsd
 * @Description:
 * @Date:Create：in 2020-05-01 21:55
 * @Modified By：
 */
@Data
public class BranchDTO {

    private Integer branchNum;

    private String branchCode;

    private String branchName;

    private Boolean branchActived;

    private String branchPostcode;

    private String branchAddr;

    private Date branchExpiration;

    private BigDecimal branchLng;

    private BigDecimal branchLat;

    private String branchProvince;

    private String branchCity;

    private String branchDistrict;

    private String branchLinkMan;

    private String branchLinkPhone;

    private Date branchCreateTime;

    private String branchAgentPhone;

    private String branchCreatorPhone;

    private String branchText;

    private String branchImgUrl;

    private String thirdCode;

    private String thirdType;

    private String branchServicePhone;

    private String branchScope;

}
