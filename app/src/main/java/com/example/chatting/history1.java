package com.example.chatting;

public class history1 {
    String name;
    String Quantity;
    String orderNo;
    String Price;
     int count;
private history1()
{

}
    public history1(String name,String quantity,String orderno,String prc) {
        this.name = name;
        this.Quantity = quantity;
        this.orderNo=orderno;
        this.Price=prc;
        //count++;
    }
    public String getName() {
        return name;
    }
    public void setName(String nm) {
        this.name = nm;
    }
    public String getQuantity() {
        return Quantity;
    }
    public void setQuantity(String cont)
    {
        this.Quantity = cont;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String ord)
    {
        this.orderNo = ord;
    }
    public String getPrice() {
        return Price;
    }
    public void setPrice(String pr) {
        this.Price = pr;
    }
    public int getCount()
    {
        return count;
    }
    public void setCount(int num)
    {
        count=num;
    }
    @Override
    public String toString()
    { return "Name : "+name+" Contact : "+Quantity;}

}
