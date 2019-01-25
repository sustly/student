package com.sustly.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception ex){
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception",ex);
        return mv;
    }
}
