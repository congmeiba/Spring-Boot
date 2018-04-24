package cn.gzsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

    /**
     * @ExceptionHandler 异常方法注解
     * value : 捕获的异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView ex01(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", ex.toString());
        mv.setViewName("error");
        return mv;
    }


    @RequestMapping("/demo1")
    public ModelAndView demo1() {
        //java.lang.ArithmeticException
        int i = 10 / 0;
        return null;
    }

    @RequestMapping("/demno2")
    public String demo2() {
       String str = null;
       str.toString();
        return "success";
    }


}
