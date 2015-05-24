package com.example.administrator.myprojest103;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-5-19.
 */
public class getfoodjsonUtil {
    // @param     从服务器端得到的JSON字符串数据
    //@return    解析JSON字符串数据，放入List当中

    public static List<Food> getcategoryjsonUtil(String food)
    {
        //创建Food类型的list
        List<Food> foods = new ArrayList<Food>();
        try
        {
            JSONArray jsonArray = new JSONArray(food);
            for(int i =0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String heat = jsonObject.getString("heat");
                String protein = jsonObject.getString("protein");
                String fat = jsonObject.getString("fat");
                String vitaminC = jsonObject.getString("vitaminC");
                String vitaminE = jsonObject.getString("vitaminE");
                String vitaminB1 = jsonObject.getString("vitaminB1");
                String vitaminB2 = jsonObject.getString("vitaminB2");
                String Fe = jsonObject.getString("Fe");
                String Zn = jsonObject.getString("Zn");
                String Se = jsonObject.getString("Se");
                String category = jsonObject.getString("category");
                String isDel = jsonObject.getString("isDel");
                Food food1 = new Food(id, name, heat, protein, fat, vitaminC, vitaminE, vitaminB1, vitaminB2, Fe, Zn, Se, category, isDel);
                foods.add(food1);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return foods;
    }
}
