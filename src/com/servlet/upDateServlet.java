package com.servlet;

import com.tools.ConnDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by warkey on 2018-05-06.
 * 更新的操作
 */
@WebServlet("/upDateServlet")
public class upDateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sID= (String)req.getParameter("ID");
        System.out.println(sID);
        req.setAttribute("ID",sID);
        int ID=Integer.parseInt(sID);
        ConnDB conn=new ConnDB();
        ResultSet rs=conn.executeQuery("select * from v_goods where ID="+ID);
        try {
            if(!rs.next()){
               // out.println("<script lanuage='javascript'>alert('您的操作有误!');window.location.href='index.jsp';</script>");
            }else{
                int superID1 = rs.getInt("superID");
                int subID1 = rs.getInt("subID");
                String goodsname = rs.getString("goodsname");
                String introduce=rs.getString("introduce");
                float price = rs.getFloat("Price");
                float nowprice=rs.getFloat("nowPrice");
                String picture=rs.getString("picture");
                int newgoods=rs.getInt("newgoods");
                int sale=rs.getInt("sale");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs_super=conn.executeQuery("select ID,superType from V_type group by ID,superType");
        int superID=-1;
        String superName="";
        try {
            if(!rs_super.next()){
               // out.println("<script language='javascript'>alert('请先录入类别信息!');window.location.href='index.jsp';</script>");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/manage/goods_modify.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
        System.out.println(1);
    }
}
