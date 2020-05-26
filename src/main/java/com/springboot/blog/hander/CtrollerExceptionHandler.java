package com.springboot.blog.hander;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CtrollerExceptionHandler {
    private final Logger logger=LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(Exception.class)
    public ModelAndView excepttionHandler(HttpServletRequest request,Exception e)
    {
        logger.error("Request URL : {}, Exception : {}",request.getRequestURI(),e);
        ModelAndView mv=new ModelAndView();
        mv.addObject("url",request.getRequestURL());
        mv.addObject("exception",e);
        mv.setViewName("error/error");
        return mv;
    }
}
