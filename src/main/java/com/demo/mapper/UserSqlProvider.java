package com.demo.mapper;

import com.demo.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getUserCode() != null) {
            sql.VALUES("user_code", "#{userCode,jdbcType=INTEGER}");
        }
        
        if (record.getUserType() != null) {
            sql.VALUES("user_type", "#{userType,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getMobileNumber() != null) {
            sql.VALUES("mobile_number", "#{mobileNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceId() != null) {
            sql.VALUES("device_id", "#{deviceId,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginPassword() != null) {
            sql.VALUES("login_password", "#{loginPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getHasLoginPassword() != null) {
            sql.VALUES("has_login_password", "#{hasLoginPassword,jdbcType=CHAR}");
        }
        
        if (record.getHandPassword() != null) {
            sql.VALUES("hand_password", "#{handPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getHasHandPassword() != null) {
            sql.VALUES("has_hand_password", "#{hasHandPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedDate() != null) {
            sql.VALUES("created_date", "#{createdDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatedDate() != null) {
            sql.VALUES("updated_date", "#{updatedDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsOldUser() != null) {
            sql.VALUES("is_old_user", "#{isOldUser,jdbcType=CHAR}");
        }
        
        if (record.getUserStyle() != null) {
            sql.VALUES("user_style", "#{userStyle,jdbcType=INTEGER}");
        }
        
        if (record.getValidControl() != null) {
            sql.VALUES("valid_control", "#{validControl,jdbcType=INTEGER}");
        }
        
        if (record.getSyncFlag() != null) {
            sql.VALUES("sync_flag", "#{syncFlag,jdbcType=CHAR}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.VALUES("is_deleted", "#{isDeleted,jdbcType=SMALLINT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getUserType() != null) {
            sql.SET("user_type = #{userType,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getMobileNumber() != null) {
            sql.SET("mobile_number = #{mobileNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getDeviceId() != null) {
            sql.SET("device_id = #{deviceId,jdbcType=VARCHAR}");
        }
        
        if (record.getLoginPassword() != null) {
            sql.SET("login_password = #{loginPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getHasLoginPassword() != null) {
            sql.SET("has_login_password = #{hasLoginPassword,jdbcType=CHAR}");
        }
        
        if (record.getHandPassword() != null) {
            sql.SET("hand_password = #{handPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getHasHandPassword() != null) {
            sql.SET("has_hand_password = #{hasHandPassword,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedDate() != null) {
            sql.SET("created_date = #{createdDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatedDate() != null) {
            sql.SET("updated_date = #{updatedDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsOldUser() != null) {
            sql.SET("is_old_user = #{isOldUser,jdbcType=CHAR}");
        }
        
        if (record.getUserStyle() != null) {
            sql.SET("user_style = #{userStyle,jdbcType=INTEGER}");
        }
        
        if (record.getValidControl() != null) {
            sql.SET("valid_control = #{validControl,jdbcType=INTEGER}");
        }
        
        if (record.getSyncFlag() != null) {
            sql.SET("sync_flag = #{syncFlag,jdbcType=CHAR}");
        }
        
        if (record.getIsDeleted() != null) {
            sql.SET("is_deleted = #{isDeleted,jdbcType=SMALLINT}");
        }
        
        sql.WHERE("user_code = #{userCode,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}