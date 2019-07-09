package com.xd.ums.domain;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class User {

    private int user_id;
    private String user_name;
    private String user_login;
    private String user_pwd;
    private String user_email;
    private String user_gender;
    private String user_mobile;
    private String user_phone;
    private String user_depart;
    private String user_comp;
    private String user_time;
    private String user_state;


    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_state() {
        return user_state;
    }

    public void setUser_state(String user_state) {
        this.user_state = user_state;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_depart() {
        return user_depart;
    }

    public void setUser_depart(String user_depart) {
        this.user_depart = user_depart;
    }

    public String getUser_comp() {
        return user_comp;
    }

    public void setUser_comp(String user_comp) {
        this.user_comp = user_comp;
    }

    public String getUser_time() {
        return user_time.toString();
    }

    public void setUser_time(Timestamp user_time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //从前端或者自己模拟一个日期格式，转为String即可
        String dateStr = format.format(user_time);
        this.user_time = dateStr;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

//    public String getUser_pwd() {
//        return user_pwd;
//    }

//    public void setUser_pwd(String user_pwd) {
//        this.user_pwd = user_pwd;
//    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }
}
