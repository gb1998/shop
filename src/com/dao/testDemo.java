package com.dao;

/**
 * Created by warkey on 2018-05-04.
 */
import com.tools.ConnDB;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class testDemo {
    ConnDB conn = new ConnDB();//加载tools包下的方法类
    @Test
    public void test()
    {
        String sql="select * from tb_goods";
        ResultSet resultSet = conn.executeQuery(sql);
        System.out.println(sql);
        try {
            while(resultSet.next())
            {

                //查找大小分类
               Integer subId=resultSet.getInt(2);
               //查找小分类的名字
                String sqllist="select  * from tb_subtype where ID = "+subId;
               ResultSet sub=conn.executeQuery(sqllist);
               String subName=null;
              Integer superID=null;
                String superName=null;
               while(sub.next())
               {
                     subName=sub.getString(2);
                    superID=sub.getInt(3);
               }

               //根据大id 的到名字
                String superL="select * from tb_supertype where ID="+superID;
                ResultSet supers=conn.executeQuery(superL);
                while(supers.next())
               superName=supers.getString(2);
                //插入到数据库
                String add="insert into v_goods values( "+resultSet.getInt(1)+ ",'"+superName+"','"+resultSet.getString(3)+"','"+resultSet.getString(4)+"','"+subName+"','"+resultSet.getString(5)+"','"+resultSet.getString(6)+"','"+resultSet.getString(8)+"','"+resultSet.getString(9)+"','"+resultSet.getString(11)+"',"+superID+","+subId+")";
                System.out.println(add);
                int i = conn.executeUpdate(add);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
