package com.example.administrator.myprojest103;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-5-19.
 */
public class getcategoryjosnUtil {
    // @param     从服务器端得到的JSON字符串数据
    //@return    解析JSON字符串数据，放入List当中

    public static List<Category> getcategoryjsonUtil(String category)
    {
        //创建category类型的list
        List<Category> categorys = new ArrayList<Category>();
        try
        {
            JSONArray jsonArray = new JSONArray(category);
            for(int i =0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String isDel = jsonObject.getString("isDel");
                Category category1 = new Category(id, name, isDel);
                categorys.add(category1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return categorys;
    }
}
