package cn.gzsxt.serlvet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @WebServlet 注解Spring boot支持Servlet 类访问
 */
//@WebServlet(name = "bootServlet", urlPatterns = "/boot.do")
public class BootServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("BootServlet 的方法");
    }


}
