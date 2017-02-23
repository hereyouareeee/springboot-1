package com.demo.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder //连贯接口
@Getter
//@Data  =@Getter+@Setter
public class User {
    @ApiModelProperty("用户编码")
    private Integer userCode;
    @ApiModelProperty("用户类型")
    private String userType;
    @ApiModelProperty("用户名称")
    private String userName;
    @ApiModelProperty("手机号")
    private String mobileNumber;

    private String deviceId;

    private String loginPassword;

    private String hasLoginPassword;

    private String handPassword;

    private String hasHandPassword;

    private Date createdDate;

    private Date updatedDate;

    private String isOldUser;

    private Integer userStyle;

    private Integer validControl;

    private String syncFlag;

    private Short isDeleted;

}