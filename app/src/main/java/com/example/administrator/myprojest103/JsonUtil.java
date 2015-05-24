package com.example.administrator.myprojest103;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-5-14.
 */
public class JsonUtil
{

     // @param     从服务器端得到的JSON字符串数据
     //@return    解析JSON字符串数据，放入List当中

    public static List<String> jsondecode(String studentStirng)
    {
        List<String> student = new ArrayList<String>();

        try
        {
            JSONObject jsonObject = new JSONObject(studentStirng);
            JSONArray jsonArray = jsonObject.getJSONArray("");
            for(int i = 0; i < jsonArray.length(); i++)
            {
                student.add(jsonArray.getString(i));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return student;
    }
}
