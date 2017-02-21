package com.demo.mapper;

import com.demo.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where user_code = #{userCode,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userCode);

    @Insert({
        "insert into user (user_code, user_type, ",
        "user_name, mobile_number, ",
        "device_id, login_password, ",
        "has_login_password, hand_password, ",
        "has_hand_password, created_date, ",
        "updated_date, is_old_user, ",
        "user_style, valid_control, ",
        "sync_flag, is_deleted)",
        "values (#{userCode,jdbcType=INTEGER}, #{userType,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{mobileNumber,jdbcType=VARCHAR}, ",
        "#{deviceId,jdbcType=VARCHAR}, #{loginPassword,jdbcType=VARCHAR}, ",
        "#{hasLoginPassword,jdbcType=CHAR}, #{handPassword,jdbcType=VARCHAR}, ",
        "#{hasHandPassword,jdbcType=VARCHAR}, #{createdDate,jdbcType=TIMESTAMP}, ",
        "#{updatedDate,jdbcType=TIMESTAMP}, #{isOldUser,jdbcType=CHAR}, ",
        "#{userStyle,jdbcType=INTEGER}, #{validControl,jdbcType=INTEGER}, ",
        "#{syncFlag,jdbcType=CHAR}, #{isDeleted,jdbcType=SMALLINT})"
    })
    int insert(User record);


    @Select({
        "select",
        "user_code, user_type, user_name, mobile_number, device_id, login_password, has_login_password, ",
        "hand_password, has_hand_password, created_date, updated_date, is_old_user, user_style, ",
        "valid_control, sync_flag, is_deleted",
        "from user",
        "where user_code = #{userCode,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_type", property="userType", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile_number", property="mobileNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_id", property="deviceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_password", property="loginPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="has_login_password", property="hasLoginPassword", jdbcType=JdbcType.CHAR),
        @Result(column="hand_password", property="handPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="has_hand_password", property="hasHandPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_date", property="createdDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_date", property="updatedDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_old_user", property="isOldUser", jdbcType=JdbcType.CHAR),
        @Result(column="user_style", property="userStyle", jdbcType=JdbcType.INTEGER),
        @Result(column="valid_control", property="validControl", jdbcType=JdbcType.INTEGER),
        @Result(column="sync_flag", property="syncFlag", jdbcType=JdbcType.CHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.SMALLINT)
    })
    User selectByPrimaryKey(Integer userCode);


    @Update({
        "update user",
        "set user_type = #{userType,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "mobile_number = #{mobileNumber,jdbcType=VARCHAR},",
          "device_id = #{deviceId,jdbcType=VARCHAR},",
          "login_password = #{loginPassword,jdbcType=VARCHAR},",
          "has_login_password = #{hasLoginPassword,jdbcType=CHAR},",
          "hand_password = #{handPassword,jdbcType=VARCHAR},",
          "has_hand_password = #{hasHandPassword,jdbcType=VARCHAR},",
          "created_date = #{createdDate,jdbcType=TIMESTAMP},",
          "updated_date = #{updatedDate,jdbcType=TIMESTAMP},",
          "is_old_user = #{isOldUser,jdbcType=CHAR},",
          "user_style = #{userStyle,jdbcType=INTEGER},",
          "valid_control = #{validControl,jdbcType=INTEGER},",
          "sync_flag = #{syncFlag,jdbcType=CHAR},",
          "is_deleted = #{isDeleted,jdbcType=SMALLINT}",
        "where user_code = #{userCode,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}