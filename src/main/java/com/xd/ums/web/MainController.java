package com.xd.ums.web;

import com.xd.ums.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/main")
    public String mainHtml() {
        return "main";
    }

    @RequestMapping("/page1")
    public String pageHtml() {
        return "page1";
    }

    @RequestMapping("/dashboard")
    public String dashHtml() {
        return "dashboard";
    }

    @RequestMapping("/newuser")
    public String addHtml() {
        return "newuser";
    }

    @RequestMapping("/alteruser")
    public String alterHtml(@RequestParam("id") int id, Model model) {

        model.addAttribute("name", userService.selectUserById(id).getUser_name());
        model.addAttribute("login", userService.selectUserById(id).getUser_login());
        model.addAttribute("pwd", userService.selectUserById(id).getUser_pwd());
        model.addAttribute("email", userService.selectUserById(id).getUser_email());
        model.addAttribute("mobile", userService.selectUserById(id).getUser_mobile());
        model.addAttribute("phone", userService.selectUserById(id).getUser_phone());
        model.addAttribute("sex", userService.selectUserById(id).getUser_gender());
        model.addAttribute("comp", userService.selectUserById(id).getUser_comp());
        model.addAttribute("dep", userService.selectUserById(id).getUser_depart());
        model.addAttribute("state", userService.selectUserById(id).getUser_state());
        model.addAttribute("id", id);

        return "alteruser";
    }

    @RequestMapping("/usermag")
    public String userMagHtml() {
        return "usermag";
    }

}
