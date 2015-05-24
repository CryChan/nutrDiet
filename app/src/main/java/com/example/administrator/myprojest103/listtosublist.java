package com.example.administrator.myprojest103;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-5-23.
 */
public class listtosublist {

    public ArrayList<String> toArryListParent(List<Food> food){
        ArrayList<String> l = new ArrayList<String>();
        for (int i = 0; i < food.size(); i++){
            l.add(food.get(i).getName());
        }
        return l;
    }


    public ArrayList<ArrayList<String>> toArryListChild(List<Food> food){
        ArrayList<ArrayList<String>> l = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < food.size(); i++){
            ArrayList<String> ll = new ArrayList<String>();
            ll.add(food.get(i).getHeat());
            ll.add(food.get(i).getProtein());
            ll.add(food.get(i).getFat());
            ll.add(food.get(i).getVitaminC());
            ll.add(food.get(i).getVitaminE());
            ll.add(food.get(i).getVitaminB1());
            ll.add(food.get(i).getVitaminB2());
            ll.add(food.get(i).getFe());
            ll.add(food.get(i).getZn());
            ll.add(food.get(i).getSe());
            l.add(ll);
        }
        return l;
    }
}
