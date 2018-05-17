package com.servlet;

import com.model.Goods;
import com.model.SubType;
import com.tools.ConnDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by warkey on 2018-05-01.
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //循环显示最新上架商品 ：添加12条商品信息-

        ConnDB conn=new ConnDB();
        ResultSet rs_new = conn.executeQuery("select t1.ID, t1.GoodsName,t1.price,t1.picture,t2.TypeName "
                + "from tb_goods t1,tb_subType t2 where t1.typeID=t2.ID and "
                + "t1.newGoods=1 order by t1.INTime desc "+"limit 12");//查询最新上架商品信息
       //最新商品
        List<Goods> newgoods=new ArrayList<Goods>();
        //最热商品
        List<Goods> hotgoods=new ArrayList<Goods>();
        //最新打折商品
        List<Goods> pricegoods=new ArrayList<Goods>();
        try{
        while(rs_new.next())
        {
            Goods good=new Goods();
            good.setID(rs_new.getInt(1));
            good.setGoodsName(rs_new.getString(2));
            good.setNowPrice(rs_new.getFloat(3));
            good.setPicture(rs_new.getString(4));//获取最新上架商品的图片
            //获取商品的类别
            String goodsType=rs_new.getString(5);
            newgoods.add(good);
            req.setAttribute("newgoodlist",newgoods);
        }}
        catch ( Exception e)
        {
            e.printStackTrace();

        }

        /* 打折商品信息 */
        ResultSet rs_sale = conn
                .executeQuery("select t1.ID,t1.GoodsName,t1.price,t1.nowPrice,t1.picture,t2.TypeName "
                        + "from tb_goods t1,tb_subType t2 where t1.typeID=t2.ID and t1.sale=1 "
                        + "order by t1.INTime desc"+" limit 5");//查询打折商品信息
        List<SubType> subTypes=new ArrayList<>();
        try{
        while(rs_sale.next())
        {
            SubType subType=new SubType();
            Goods price=new Goods();
            price.setID( rs_sale.getInt(1));  //获取打折商品的ID
            price.setGoodsName(rs_sale.getString(2));//获取打折商品的商品名称
            price.setPrice(rs_sale.getFloat(3));//获取打折商品的原价price.setNowPrice(rs_sale.getFloat(4)); //获取打折商品的现价
            price.setPicture(rs_sale.getString(5));//获取打折商品的图片
            subType.settypename(rs_sale.getString(6));//获取打折商品的类别
            pricegoods.add(price);
            subTypes.add(subType);
            req.setAttribute("pricelist",pricegoods);
            //req.setAttribute("subType",subTypes);

        }}catch(SQLException e)
        {
            e.printStackTrace();
            }


        /* 热门商品信息 */
        ResultSet rs_hot = conn
                .executeQuery("select  ID,GoodsName,nowprice,picture " + "from tb_goods order by hit desc "+"limit 5");//查询热门商品信息

       try
       {
           while(rs_hot.next())
           {
               int hot_ID = rs_hot.getInt(1); //获取商品ID
               String  hot_goodsName = rs_hot.getString(2); //获取商品名称
               float hot_nowprice = rs_hot.getFloat(3); //获取商品价格
               String hot_picture = rs_hot.getString(4); //获取商品图片
               Goods goods=new Goods();
               goods.setTypeID(hot_ID);
               goods.setGoodsName(hot_goodsName);
              goods.setNowPrice(hot_nowprice);
              goods.setPicture(hot_picture);
              hotgoods.add(goods);
              req.setAttribute("hotlist",hotgoods);
           }
       }catch (SQLException e)
       {
           e.printStackTrace();
       }
        //跳回页面带值
        req.getRequestDispatcher("/front/index.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
