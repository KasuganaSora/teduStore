package cn.tedu.store.controller;

import cn.tedu.store.interceptor.AuthUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user/")
public class AddressController extends BaseController {

    @AuthUser
    @RequestMapping("showAddress.do")
    public ModelAndView showAddress(ModelAndView modelAndView) {
        modelAndView.setViewName("addressAdmin");
        return modelAndView;
    }
}
