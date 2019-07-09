package com.xd.ums.dao;

import com.xd.ums.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM ums_user")
    List<User> findAllUser();

    @Select("SELECT ums_user.user_id, ums_user.user_login,ums_user.user_name,ums_user.user_pwd, ums_user.user_mobile, " +
            "ums_user.user_email, ums_user.user_phone, CASE ums_user.user_gender " +
            "WHEN 1 THEN '男' ELSE '女' END AS user_gender, ums_user.user_gender, " +
            "d1.depart_name AS user_depart, d2.depart_name AS user_comp, " +
            "ums_user.user_time, CASE ums_user.user_state WHEN 1 THEN '正常' " +
            "ELSE '异常' END AS user_state FROM ums_user " +
            "LEFT JOIN ums_department d1 ON ums_user.user_depart = d1.depart_id " +
            "LEFT JOIN ums_department d2 ON ums_user.user_comp = d2.depart_id")
    List<User> findPageUser();

    @Select("SELECT ums_user.user_id, ums_user.user_login,ums_user.user_name,ums_user.user_pwd, ums_user.user_mobile, " +
            "ums_user.user_email, ums_user.user_phone, CASE ums_user.user_gender " +
            "WHEN 1 THEN '男' ELSE '女' END AS user_gender, d1.depart_name AS " +
            "user_depart, d2.depart_name AS user_comp, ums_user.user_time, " +
            "CASE ums_user.user_state WHEN 1 THEN '正常' ELSE '异常' END AS user_state " +
            "FROM ums_user " +
            "LEFT JOIN ums_department d1 ON ums_user.user_depart = d1.depart_id " +
            "LEFT JOIN ums_department d2 ON ums_user.user_comp = d2.depart_id " +
            "WHERE ums_user.user_depart = #{belongid} OR ums_user.user_comp = #{belongid}")
    List<User> findBelongUser(@Param("belongid") int belongid);

    @Select("SELECT ums_user.user_id, ums_user.user_login,ums_user.user_name,ums_user.user_pwd, ums_user.user_mobile, " +
            "ums_user.user_email, ums_user.user_phone, CASE ums_user.user_gender " +
            "WHEN 1 THEN '男' ELSE '女' END AS user_gender, d1.depart_name AS " +
            "user_depart, d2.depart_name AS user_comp, ums_user.user_time, " +
            "CASE ums_user.user_state WHEN 1 THEN '正常' ELSE '异常' END AS user_state " +
            "FROM ums_user " +
            "LEFT JOIN ums_department d1 ON ums_user.user_depart = d1.depart_id " +
            "LEFT JOIN ums_department d2 ON ums_user.user_comp = d2.depart_id " +
            "WHERE ums_user.user_login LIKE CONCAT('%',#{user_login},'%') AND ums_user.user_name LIKE CONCAT('%',#{user_name},'%') " +
            "AND  ums_user.user_email LIKE CONCAT('%',#{user_email},'%') AND  ums_user.user_mobile LIKE CONCAT('%',#{user_mobile},'%') " +
            "AND ums_user.user_phone LIKE CONCAT('%',#{user_phone},'%') AND ums_user.user_depart LIKE CONCAT('%',#{user_depart},'%') " +
            "AND ums_user.user_comp LIKE CONCAT('%',#{user_comp},'%')")
    List<User> findMeetUser(@Param("user_login") String user_login, @Param("user_name") String user_name,
                            @Param("user_email") String user_email, @Param("user_mobile") String user_mobile,
                            @Param("user_phone") String user_phone, @Param("user_depart") String user_depart,
                            @Param("user_comp") String user_comp);


    @Insert("INSERT INTO ums_user(user_login,user_name, user_pwd, user_mobile,user_email,user_phone,user_gender,user_depart, user_comp,user_state) " +
            "VALUES(#{user_login},#{user_name},#{user_pwd},#{user_mobile},#{user_email},#{user_phone},#{user_gender},#{user_depart}, #{user_comp},#{user_state})")
    void insertUser(@Param("user_name") String user_name, @Param("user_login") String user_login,
                    @Param("user_pwd") String user_pwd, @Param("user_gender") int user_gender,
                    @Param("user_email") String user_email, @Param("user_mobile") String user_mobile,
                    @Param("user_phone") String user_phone, @Param("user_comp") int user_comp,
                    @Param("user_depart") int user_depart, @Param("user_state") int user_state);

    @Delete("DELETE FROM ums_user WHERE ums_user.user_id = #{user_id}")
    void deleteThisUser(@Param("user_id") int user_id);

    @Select("SELECT * FROM ums_user WHERE ums_user.user_id = #{user_id}")
    User findUserById(@Param("user_id") int user_id);

    @Update("UPDATE ums_user SET user_name = #{user_name}, user_login=#{user_login}," +
            "user_pwd=#{user_pwd}, user_gender=#{user_gender},user_email=#{user_email}," +
            "user_mobile=#{user_mobile},user_phone=#{user_phone},user_comp=#{user_comp}," +
            "user_depart=#{user_depart},user_state=#{user_state} WHERE user_id = #{user_id}")
    void updateUser(@Param("user_name") String user_name, @Param("user_login") String user_login,
                    @Param("user_pwd") String user_pwd, @Param("user_gender") int user_gender,
                    @Param("user_email") String user_email, @Param("user_mobile") String user_mobile,
                    @Param("user_phone") String user_phone, @Param("user_comp") int user_comp,
                    @Param("user_depart") int user_depart, @Param("user_state") int user_state,
                    @Param("user_id") int user_id);
}
