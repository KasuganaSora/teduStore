package cn.tedu.store.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/main/")
public class MainController {

    @RequestMapping("showIndex.do")
    public ModelAndView showIndex(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("exit.do")
    public ModelAndView exit(ModelAndView modelAndView, HttpSession session) {
        session.invalidate();
        modelAndView.setViewName("redirect:/main/showIndex.do");
        return modelAndView;
    }

}
