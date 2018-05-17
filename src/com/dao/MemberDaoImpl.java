package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Member;
import com.tools.ChStr;
import com.tools.ConnDB;

public class MemberDaoImpl implements MemberDao {
	ConnDB conn = new ConnDB();//加载tools包下的方法类
	ChStr chStr = new ChStr();//加载tools包下的方法类
	@Override
	public int insert(Member m) {
		int ret = -1;// 用于记录更新记录的条数
		try {// 捕捉异常
			String sql = "Insert into tb_Member (UserName,TrueName,PassWord,City,address,postcode,"
					+ "CardNO,CardType,Tel,Email) values('"
					+ chStr.chStr(m.getUsername()) + "','" + chStr.chStr(m.getTruename()) + "','"
					+ chStr.chStr(m.getPwd()) + "','" + chStr.chStr(m.getCity()) + "','" + chStr.chStr(m.getAddress())
					+ "','" + chStr.chStr(m.getPostcode()) + "','" + chStr.chStr(m.getCardno()) + "','"
					+ chStr.chStr(m.getCardtype()) + "','" + chStr.chStr(m.getTel()) + "','"+ chStr.chStr(m.getEmail())
					+ "')";// 用于实现保存会员信息的SQL语句
			ret = conn.executeUpdate(sql);// 执行SQL语句实现保存会员信息到数据库
		} catch (Exception e) {// 处理异常
			e.printStackTrace();// 输出异常信息
			ret = 0;// 设置变量的值为0，表示保存会员信息失败
		}
		conn.close();// 关闭数据库的连接
		return ret;// 返回更新记录的条数
	}

	@Override
	public List select() {
		Member form = null;// 声明会员对象
		List list = new ArrayList();// 创建一个List集合对象，用于保存会员信息
		String sql = "select * from tb_member";// 查询全部会员信息的SQL语句
		ResultSet rs = conn.executeQuery(sql);// 执行查询操作
		try {// 捕捉异常
			while (rs.next()) {
				form = new Member();// 实例化一个会员对象
				form.setID(Integer.valueOf(rs.getString(1)));// 获取会员ID
				list.add(form);// 把会员信息添加到List集合对象中
			}
		} catch (SQLException ex) {// 处理异常
		}
		conn.close();// 关闭数据库的连接
		return list;
	}
	// 执行删除操作
	public int delete(Member m) {
		String sql = "delect from tb_member where ID=" + m.getID();
		int ret = conn.executeUpdate(sql);
		conn.close();
		return 0;
	}


	// 执行修改操作
	public int update(Member m) {
		int ret = -1;
		try {
			String sql = "update tb_member set TrueName='" + chStr.chStr(m.getTruename()) + "',UserName='"
					+ chStr.chStr(m.getUsername()) + "',PassWord='" + chStr.chStr(m.getPwd()) + "',City='"
					+ chStr.chStr(m.getCity()) + "',address='" + chStr.chStr(m.getAddress()) + "',postcode='"
					+ chStr.chStr(m.getPostcode()) + "',CardNO='" + chStr.chStr(m.getCardno()) + "',CardType='"
					+ chStr.chStr(m.getCardtype()) + "',Tel='" + chStr.chStr(m.getTel()) + "',Email='"
					+ chStr.chStr(m.getEmail()) + "' where ID=" + m.getID();
			ret = conn.executeUpdate(sql);
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
			ret = 0;
		}
		conn.close();//关闭数据库连接
		return ret;
	}
	public Member select1() {
		return null;
	}
}
