package com.demo.model;

import java.util.Date;

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

    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber == null ? null : mobileNumber.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getHasLoginPassword() {
        return hasLoginPassword;
    }

    public void setHasLoginPassword(String hasLoginPassword) {
        this.hasLoginPassword = hasLoginPassword == null ? null : hasLoginPassword.trim();
    }

    public String getHandPassword() {
        return handPassword;
    }

    public void setHandPassword(String handPassword) {
        this.handPassword = handPassword == null ? null : handPassword.trim();
    }

    public String getHasHandPassword() {
        return hasHandPassword;
    }

    public void setHasHandPassword(String hasHandPassword) {
        this.hasHandPassword = hasHandPassword == null ? null : hasHandPassword.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getIsOldUser() {
        return isOldUser;
    }

    public void setIsOldUser(String isOldUser) {
        this.isOldUser = isOldUser == null ? null : isOldUser.trim();
    }

    public Integer getUserStyle() {
        return userStyle;
    }

    public void setUserStyle(Integer userStyle) {
        this.userStyle = userStyle;
    }

    public Integer getValidControl() {
        return validControl;
    }

    public void setValidControl(Integer validControl) {
        this.validControl = validControl;
    }

    public String getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(String syncFlag) {
        this.syncFlag = syncFlag == null ? null : syncFlag.trim();
    }

    public Short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }
}