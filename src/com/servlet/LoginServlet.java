package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by warkey on 2018-05-01.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("GBK");
        PrintWriter out=response.getWriter();
        out.print("<HTML>");
        out.println("<HEAD><TITLE>Servlet实例</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("servlet实例");
        out.println(this.getClass());
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
        response.getWriter().append("Served at: ").append(request.getContextPath());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
