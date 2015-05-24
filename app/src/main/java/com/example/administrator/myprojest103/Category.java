package com.example.administrator.myprojest103;

/**
 * Created by Administrator on 15-5-19.
 */
//需解析的category类
public class Category {
    String id;
    String name;
    String isDel;
    public  Category(){
        super();
    }
    public  Category(String id, String name, String isDel){
        super();
        this.id = id;
        this.name = name;
        this.isDel = isDel;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getIsDel(){
        return isDel;
    }
}

