package com.xd.ums.web;

import com.xd.ums.domain.ResultBean;
import com.xd.ums.domain.User;
import com.xd.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String printUserList() {
        return "user show here123";
    }

    @RequestMapping("/all")
    public List<User> getAllUser() {
        return userService.selectAllUser();
    }


    @RequestMapping("/adduser")
    public String addUser(@RequestParam("name") String name, @RequestParam("login") String login,
                              @RequestParam("pwd") String pwd, @RequestParam("sex") int sex,
                              @RequestParam("email") String email, @RequestParam("mobile") String mobile,
                              @RequestParam("phone") String phone, @RequestParam("company") int company,
                              @RequestParam("department") int department, @RequestParam(value = "state", defaultValue = "0") int state) {

//        System.out.println(name + login + pwd + sex + email + mobile + phone + company + department + state);
        userService.addNewUser(name, login, pwd, sex, email, mobile, phone, company, department, state);
        return "<html><body><script>window.parent.app.tabs.close('11');</script></body></html>";
    }

    @RequestMapping("/changeuser")
    public String changeUser(@RequestParam("name") String name, @RequestParam("login") String login,
                             @RequestParam("pwd") String pwd, @RequestParam("sex") int sex,
                             @RequestParam("email") String email, @RequestParam("mobile") String mobile,
                             @RequestParam("phone") String phone, @RequestParam("company") int company,
                             @RequestParam("department") int department, @RequestParam("id") int id,
                             @RequestParam(value = "state", defaultValue = "0") int state) {

        userService.changeUser(name, login, pwd, sex, email, mobile, phone, company, department, state, id);
        return "<html><body><script>window.parent.app.tabs.close('12');</script></body></html>";
    }

    @RequestMapping("/deluser")
    public String testDelete(@RequestParam("id") int user_id) {
        userService.deleteUser(user_id);
        return "OK";
    }

    @RequestMapping("/userapi")
    public ResultBean getPageUser(@RequestParam(value = "page", defaultValue = "1") int page,
                                  @RequestParam(value = "limit", defaultValue = "10") int limit,
                                  @RequestParam(value = "user_login", defaultValue = "") String user_login,
                                  @RequestParam(value = "user_name", defaultValue = "") String user_name,
                                  @RequestParam(value = "user_email", defaultValue = "") String user_email,
                                  @RequestParam(value = "user_mobile", defaultValue = "") String user_mobile,
                                  @RequestParam(value = "user_phone", defaultValue = "") String user_phone,
                                  @RequestParam(value = "user_depart", defaultValue = "") String user_depart,
                                  @RequestParam(value = "user_comp", defaultValue = "") String user_comp,
                                  @RequestParam(value = "belongid", defaultValue = "") String belongid

    ) {
        //使用左侧选择树选择公司部门
        if (!belongid.equals("")) {
            int belongId = Integer.parseInt(belongid);
            return userService.selectPageUser(page, limit, belongId);
        } else if (user_login.equals("") && user_name.equals("") && user_email.equals("") && user_mobile.equals("") && user_phone.equals("") && user_depart.equals("") && user_comp.equals("")) {
            //没有使用搜索功能时,多余，但是对性能有帮助
            return userService.selectPageUser(page, limit);
        } else {
            //使用搜索功能
            return userService.selectPageUser(page, limit, user_login, user_name, user_email, user_mobile, user_phone, user_depart, user_comp);
        }
    }

}
