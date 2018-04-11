package cn.tedu.store.controller;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IUserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private IUserService UserService;

    @RequestMapping("showRegister.do")
    public ModelAndView showRegister(ModelAndView modelAndView) {
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping("checkUn.do")
    public String checkUsername(String username) {
        ResponseResult<Void> result = new ResponseResult<>();
        String resultString;
        boolean b = UserService.checkUsername(username);
        if (b) {
            //用户名不存在,表示可以使用该用户名注册
            result.setStatus(1);
            result.setMessage("可以使用该用户名注册");
            resultString = JSONObject.toJSONString(result);
            return resultString;
        } else {
            //用户名存在,不可以使用该用户注册
            result.setStatus(0);
            result.setMessage("用户名已存在");
            resultString = JSONObject.toJSONString(result);
            return resultString;
        }
    }

    @RequestMapping("checkEmail.do")
    public String checkEmail(String email) {
        ResponseResult<Void> result = new ResponseResult<>();
        String resultString;
        boolean b = UserService.checkEmail(email);
        if (b) {
            //用户名不存在,表示可以使用该用户名注册
            result.setStatus(1);
            result.setMessage("可以使用该邮箱注册");
            resultString = JSONObject.toJSONString(result);
            return resultString;
        } else {
            //用户名存在,不可以使用该用户注册
            result.setStatus(0);
            result.setMessage("邮箱已存在");
            resultString = JSONObject.toJSONString(result);
            return resultString;
        }
    }

    @RequestMapping("checkPhone.do")
    public String checkPhone(String phone) {
        ResponseResult<Void> result = new ResponseResult<>();
        String resultString;
        boolean b = UserService.checkPhone(phone);
        if (b) {
            //用户名不存在,表示可以使用该用户名注册
            result.setStatus(1);
            result.setMessage("可以使用该手机注册");
            resultString = JSONObject.toJSONString(result);
            return resultString;
        } else {
            //用户名存在,不可以使用该用户注册
            result.setStatus(0);
            result.setMessage("该手机号已存在");
            resultString = JSONObject.toJSONString(result);
            return resultString;
        }
    }




}
