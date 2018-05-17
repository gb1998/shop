package com.dao;

import com.model.Goods;

public interface GoodsDao {//设定事物接口信息
	public int insert(Goods g);//定义insert的方法，处理完毕后返回数据类型，传入参数为Goods对象，g为别名

	public int update(Goods g);//定义update的方法，处理完毕后返回数据类型，传入参数为Goods对象，g为别名

	public int delete(Goods g);//定义delete的方法，处理完毕后返回数据类型，传入参数为Goods对象，g为别名
}
