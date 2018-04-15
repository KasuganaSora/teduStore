package cn.tedu.store.controller;

import cn.tedu.store.interceptor.AuthUser;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserAlreadyExistException;
import cn.tedu.store.service.ex.UserNotFoundException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/user/")
public class UserController extends BaseController{

    @Autowired
    @Qualifier("userService")
    private IUserService UserService;

    @RequestMapping("showRegister.do")
    public ModelAndView showRegister(ModelAndView modelAndView) {
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping("showLogin.do")
    public ModelAndView showLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @AuthUser
    @RequestMapping("showPersonalInfo.do")
    public ModelAndView showPersonalInfo(ModelAndView modelAndView) {
        modelAndView.setViewName("personage");
        return modelAndView;
    }

    @AuthUser
    @RequestMapping("showPersonPassword.do")
    public ModelAndView showPersonPassword(ModelAndView modelAndView) {
        modelAndView.setViewName("personal_password");
        return modelAndView;
    }

    //注册
    @RequestMapping("register.do")
    public String doRegister(@RequestParam("userInfo") String json) {
        ResponseResult<StackTraceElement[]> result = new ResponseResult<>();
        //将json字符串转换为javaJson对象
        JSONObject jsonObject = JSONObject.parseObject(json);
        //获取json对象中的各个属性
        String username = jsonObject.getString("uname");
        String password = jsonObject.getString("upwd");
        String phone = jsonObject.getString("phone");
        String email = jsonObject.getString("email");
        //封装成实体类;
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        user.setCreateUser(username);
        user.setCreateTime(new Date());
        try {
            UserService.register(user);
            result.setStatus(1);
            result.setMessage("注册成功");
        } catch (UserAlreadyExistException e) {
            result.setStatus(0);
            result.setMessage(e.getMessage());
            //将来写入日志;
            result.setData(e.getStackTrace());
        }
        String returnInfo = JSONObject.toJSONString(result);
        return returnInfo;
    }

    //登录
    @RequestMapping("login.do")
    public String doLogin(String userInfo, HttpSession session) {
        ResponseResult result = new ResponseResult();
        JSONObject jsonObject = JSONObject.parseObject(userInfo);
        String username = jsonObject.getString("lname");
        String password = jsonObject.getString("lpwd");
        try {
            User user = UserService.login(username, password);
            result.setStatus(1);
            result.setMessage("登录成功");
            session.setAttribute("user", user);
        } catch (UserNotFoundException | PasswordNotMatchException e) {
            result.setStatus(0);
            result.setMessage(e.getMessage());
        }
        return JSONObject.toJSONString(result);
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

    @AuthUser
    @RequestMapping("updatePassword.do")
    public String updatePassword(HttpSession session , String pwdInfo) {
        ResponseResult<Void> result = new ResponseResult<>();
        JSONObject jsonObject = JSONObject.parseObject(pwdInfo);
        String oldPwd = jsonObject.getString("oldPwd");
        String newPwd = jsonObject.getString("newPwd");
        try {
            UserService.updatePassword(this.getId(session), oldPwd, newPwd);
            result.setStatus(1);
            result.setMessage("修改密码成功");
            session.invalidate();
        } catch (UserNotFoundException | PasswordNotMatchException e) {
            result.setStatus(0);
            result.setMessage(e.getMessage());
        }
        return JSONObject.toJSONString(result);
    }

    @AuthUser
    @RequestMapping("updateUser.do")
    public String updateUser(HttpSession session, String userInfo) {
        ResponseResult<Void> result = new ResponseResult<>();
        JSONObject jsonObject = JSONObject.parseObject(userInfo);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        String phone = jsonObject.getString("phone");
        String email = jsonObject.getString("email");
        User user = new User();
        user.setId(this.getId(session));
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        user.setModifiedTime(new Date());
        user.setModifiedUser(username);
        try {
            UserService.updateUser(user);
            result.setStatus(1);
            result.setMessage("成功");
            session.setAttribute("user",user);
        } catch (Exception e) {
            result.setStatus(0);
            result.setMessage(e.getMessage());
        }

        return JSONObject.toJSONString(result);
    }


}
