package cn.tedu.store.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        AuthUser authUser = ((HandlerMethod) handler).getMethodAnnotation(AuthUser.class);
        //controller没有添加AuthUser注解
        if (authUser == null) {
            return true;
        }
        if (request.getSession().getAttribute("user") != null) {
            return true;
        }
        try {
            response.sendRedirect(request.getContextPath() + "/user/showLogin.do");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
