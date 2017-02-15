package com.demo.model;


import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder //连贯接口
@Getter
//@Data  =@Getter+@Setter
public class User {
    private Integer userCode;

    private String userType;

    private String userName;

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