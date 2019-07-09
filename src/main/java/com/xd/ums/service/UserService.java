package com.xd.ums.service;

import com.xd.ums.dao.UserMapper;
import com.xd.ums.domain.ResultBean;
import com.xd.ums.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    private List<User> userList;
    private ResultBean resultBean;
    private int start;
    private int end;

    //查询所有用户
    public List<User> selectAllUser() {
        return userMapper.findAllUser();
    }

    //查询分页信息

    public ResultBean selectPageUser(int page, int limit) {
        userList = userMapper.findPageUser();
        return getUser(page, limit, userList);

    }

    public ResultBean selectPageUser(int page, int limit, int belongid) {
        if (belongid == 1) {
            userList = userMapper.findPageUser();
        } else {
            userList = userMapper.findBelongUser(belongid);
        }
        return getUser(page, limit, userList);

    }

    public ResultBean selectPageUser(int page, int limit, String user_login, String user_name, String user_email, String user_mobile, String user_phone, String user_depart, String user_comp) {
        userList = userMapper.findMeetUser(user_login, user_name, user_email, user_mobile, user_phone, user_depart, user_comp);
        return getUser(page, limit, userList);
    }

    //查询用户
    public User selectUserById(int id) {
        return userMapper.findUserById(id);
    }

    //处理打包
    private ResultBean getUser(int page, int limit, List<User> userList) {
        resultBean = new ResultBean();
        resultBean.setCode(0);
        resultBean.setMsg("");
        resultBean.setCount(userList.size());
        start = (page - 1) * limit;
        if (page * limit > (userList.size() - 1)) {
            end = userList.size();
        } else {
            end = page * limit;
        }
        resultBean.setData(userList.subList(start, end));

        return resultBean;
    }

    //新增用户
    public void addNewUser(String user_name, String user_login, String user_pwd,
                           int user_gender,String user_email, String user_mobile,
                           String user_phone, int user_comp, int user_depart,
                           int user_state) {
        userMapper.insertUser(user_name, user_login, user_pwd, user_gender,user_email,
                user_mobile,user_phone,user_comp,user_depart,user_state);

    }

    public void changeUser(String user_name, String user_login, String user_pwd,
                           int user_gender,String user_email, String user_mobile,
                           String user_phone, int user_comp, int user_depart,
                           int user_state, int user_id) {
        userMapper.updateUser(user_name, user_login, user_pwd, user_gender,user_email,
                user_mobile,user_phone,user_comp,user_depart,user_state,user_id);
    }

    //删除用户
    public void deleteUser(int user_id) {
        userMapper.deleteThisUser(user_id);
    }



}
