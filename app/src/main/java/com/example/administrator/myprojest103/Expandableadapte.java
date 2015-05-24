package com.example.administrator.myprojest103;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 15-5-23.
 */
public class Expandableadapte extends BaseExpandableListAdapter {
    private ArrayList<String> groupList;
    private ArrayList<ArrayList<String>> childList;
    private ArrayList<String> shuxing = new ArrayList<String>(){
        {
            add("热量");
            add("蛋白质");
            add("脂肪");
            add("维他命C");
            add("维他命E");
            add("维他命B1");
            add("维他命B2");
            add("铁");
            add("锌");
            add("硒");
        }
    };
    Activity activity;

    Expandableadapte(ArrayList<String> groupList, ArrayList<ArrayList<String>> childList, Activity a) {
        this.groupList = groupList;
        this.childList = childList;
        activity = a;
    }

    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    private int selectedGroupPosition = -1;
    private int selectedChildPosition = -1;

    public void setSelectedPosition(int selectedGroupPosition, int selectedChildPosition) {
        this.selectedGroupPosition = selectedGroupPosition;
        this.selectedChildPosition = selectedChildPosition;
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public int getChildrenCount(int groupPosition) {
        return childList.get(groupPosition).size();
    }

    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView = null;
        if(convertView != null){
            textView = (TextView)convertView;
            textView.setText(shuxing.get(childPosition) + ":" + childList.get(groupPosition).get(childPosition));
        }
        else{
            textView = creatView(shuxing.get(childPosition) + ":" + childList.get(groupPosition).get(childPosition));
        }
        return textView;
    }


    private TextView creatView(String content){
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 64);
        TextView textView = new TextView(activity);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(36, 0, 0, 0);
        textView.setTextSize(20);
        textView.setText(content);
        return textView;
    }

    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    public int getGroupCount() {
        return groupList.size();
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView textView = null;
        if(convertView != null){
            textView = (TextView)convertView;
            textView.setText(groupList.get(groupPosition));
        }
        else{
            textView = creatView(groupList.get(groupPosition));
        }
        return textView;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

