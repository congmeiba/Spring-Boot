package cn.gzsxt.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 这是一个处理异常的类
 */
//@ControllerAdvice
public class MyException {


    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView ex(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception",ex.toString());
        mv.setViewName("error");
        System.out.println("expcetion");
        return mv;
    }

}
