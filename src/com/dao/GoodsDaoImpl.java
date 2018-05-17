package com.dao;

import com.model.Goods;
import com.tools.ChStr;
import com.tools.ConnDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GoodsDaoImpl implements GoodsDao {
	ConnDB conn = new ConnDB();//加载tools包下的方法类
	ChStr chStr = new ChStr();//加载tools包下的方法类
	
	/**
	 * 新增操作
	 * 
	 */

	public int insert_vgoods(Goods g)
	{
		int ret = -1;//设定返回值变量
		try {
			//设定执行语句
			//在查询之间在查询
			Integer supId=g.getTypeID();
			Integer superId=g.getSuperId();
			String s ="select TypeName from tb_supertype where Id= "+superId;
			String q="select TypeName from tb_subtype where ID= "+supId;
			String superName=null;
			String subName=null;
			ResultSet resultSet = conn.executeQuery(s);
			ResultSet r=conn.executeQuery(q);
			while (r.next())
			{
			  subName=r.getString(1);

			}


			while(resultSet.next())
			{
			    superName=resultSet.getString(1);
				System.out.println(subName);

			}


			String sql = "Insert into v_goods (superType,subID,goodsname,introduce,subType,Price,nowPrice,picture,newgoods,sale,superID) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement p=conn.getConnection().prepareStatement(sql);
			p.setString(1,superName);
			p.setInt(2,g.getTypeID());
			p.setString(3,chStr.chStr(g.getGoodsName()));
			p.setString(4,chStr.chStr(g.getIntroduce()));
			p.setString(5,subName);
			p.setFloat(6,g.getPrice());
			p.setFloat(7,g.getNowPrice());
			p.setString(8,chStr.chStr(g.getPicture()));
			p.setInt(9,g.getNewGoods());
			p.setInt(10,g.getSale());
			p.setInt(11,g.getSuperId());
			ret=p.executeUpdate();
		} catch (Exception e) {
			ret = 0;
		}
		conn.close();//关闭数据库连接
		return ret;

	}
	public int insert(Goods g) {
		int ret = -1;//设定返回值变量
		try {
			//设定执行语句
			String sql = "Insert into tb_goods (TypeID,GoodsName,Introduce,Price,nowPrice,picture,newgoods,sale) values("
					+ g.getTypeID()
					+ ",'"
					+ chStr.chStr(g.getGoodsName())
					+ "','"
					+ chStr.chStr(g.getIntroduce())
					+ "',"
					+ g.getPrice()
					+ ","
					+ g.getPrice()
					+ ",'"
					+ chStr.chStr(g.getPicture())
					+ "',"
					+ g.getNewGoods()
					+ "," + g.getSale() + ")";

			ret = conn.executeUpdate(sql);//执行语句，与数据库相连接
		} catch (Exception e) {
			ret = 0;
		}
		conn.close();//关闭数据库连接
		return ret;
	}

	/**
	 * 更新操作
	 * 
	 */
	public int update(Goods g) {
		int ret = -1;//设定返回值变量
		try {
			//设定执行语句
			String sql = "update tb_Goods set TypeID=" + g.getTypeID()
					+ ",GoodsName='" + chStr.chStr(g.getGoodsName())
					+ "',introduce='" + chStr.chStr(g.getIntroduce())
					+ "',price=" + g.getPrice() + ",nowprice="
					+ g.getNowPrice() + ",picture='"
					+ chStr.chStr(g.getPicture()) + "',newgoods="
					+ g.getNewGoods() + ",sale=" + g.getSale() + " where ID="
					+ g.getID();
			ret = conn.executeUpdate(sql);//执行语句，与数据库相连接
		} catch (Exception e) {
			ret = 0;
		}
		conn.close();//关闭数据库连接
		return ret;
	}
	
	/**
	 * 删除操作
	 * 
	 */
	public int delete(Goods g) {
		int ret = -1;//设定返回值变量
		try {
			//设定执行语句
			String sql = "Delete from tb_goods where ID=" + g.getID();
			ret = conn.executeUpdate(sql);//执行语句，与数据库相连接
		} catch (Exception e) {
			ret = 0;
		}
		conn.close();//关闭数据库连接
		return ret;

	}

}