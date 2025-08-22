package com.jobposting.jobpostingapp.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor{
    // Before the controller executes
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("Incoming request:" + request.getMethod() + " " + request.getRequestURI() + " " + System.currentTimeMillis());
        return true;
    }
    // After controller executes but before view is rendered
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,  ModelAndView modelAndView){
        System.out.println("Request completed"+ "" + request.getRequestURI());
    }
    // After request is fully completed
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Request completed for"+ "" + request.getRequestURI() + " " + response.getStatus());
    }
}
