package com.model;

public class Goods {//定义一个实体对象
  private Integer ID=Integer.getInteger("-1");//定义一个数字型变量
  private int typeID=-1;//定义一个数字型变量，下同
  private String goodsName="";//定义一个字符型变量，下同
  private String introduce="";
  private float price=0f;//定义一个浮点型变量，下同
  private float nowPrice=0f;
  private String  picture="";
  private int newGoods=-1;
  private int sale=-1;
  //父类名
  private String superName;
  //子类名
  private String subName;
  //
  private Integer superId;
  private Integer subID;

  public String getSuperName() {
    return superName;
  }

  public void setSuperName(String superName) {
    this.superName = superName;
  }

  public String getSubName() {
    return subName;
  }

  public void setSubName(String subName) {
    this.subName = subName;
  }

  public Integer getSuperId() {
    return superId;
  }

  public void setSuperId(Integer superId) {
    this.superId = superId;
  }

  public Integer getSubID() {
    return subID;
  }

  public void setSubID(Integer subID) {
    this.subID = subID;
  }

  public void goods(){
  }

  public Integer getID(){
 return ID;
}
public void setID(Integer ID){
 this.ID=ID;
}

  public int getTypeID() {
    return typeID;
  }
public void setTypeID(int typeID) {
  this.typeID = typeID;
}

public String getGoodsName(){
  return goodsName;
}
public void setGoodsName(String goodsName){
  this.goodsName=goodsName;
}

public String getIntroduce(){
  return introduce;
}
public void setIntroduce(String introduce){
  this.introduce=introduce;
}
public float getPrice(){
  return price;
}
public void setPrice(float price){
  this.price=price;
}
public float getNowPrice(){
  return nowPrice;
}
public void setNowPrice(float nowPrice){
  this.nowPrice=nowPrice;
}
public String getPicture(){
  return picture;
}
public void setPicture(String picture){
  this.picture=picture;
}
public int getNewGoods() {
  return newGoods;
}
public void setNewGoods(int newGoods) {
this.newGoods = newGoods;
}
public int getSale() {
  return sale;
}
public void setSale(int sale) {
this.sale = sale;
}
}

