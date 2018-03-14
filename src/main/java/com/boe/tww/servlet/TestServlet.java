package com.boe.tww.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 测试Servlet
 *
 * @author 唐万万
 * @create 2018-03-14 10:06
 */
@WebServlet(urlPatterns = "/test2")
public class TestServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        //输出对象
        PrintWriter writer = resp.getWriter();
        //输出error消息
        writer.write("执行TestServlet内的doGet方法成功！");
        writer.close();
    }
}
