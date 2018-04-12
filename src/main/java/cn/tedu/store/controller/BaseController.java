package cn.tedu.store.controller;

import cn.tedu.store.bean.User;

import javax.servlet.http.HttpSession;

public class BaseController {

    public Integer getId(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return null;
        } else {
            return user.getId();
        }
    }
}
