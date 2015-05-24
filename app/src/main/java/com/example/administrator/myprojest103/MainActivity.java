package com.example.administrator.myprojest103;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;

import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.app.ActionBarActivity;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    //设原始的url
    public static String BASE_URL = "http://192.168.199.246:3000";
    public String food_url;
    //弹出菜单设置
    PopupMenu clasify = null;
    PopupMenu clasify_sort = null;
    PopupMenu sort = null;

    //定义actionBar
    ActionBar actionBar;

    //可展开菜单
    ExpandableListView expandlv;

    //处理UI的handler定义
    Handler handler;

    //处理get的handler
    class webgethandler implements Runnable{
        @Override
        public void run(){
            String result = "";
            try{
                result = new HttpUtil().getRequest(food_url);
            }catch (ClientProtocolException e){
                result = e.getMessage().toString();
                e.printStackTrace();
            }catch (IOException e){
                result = e.getMessage().toString();
                e.printStackTrace();
            } catch(Exception e){
                result = e.getMessage().toString();
                e.printStackTrace();
            }
            Message mm = new Message();
            Bundle bb = new Bundle();
            bb.putString("result", result);
            mm.what = 0x123;
            mm.setData(bb);
            handler.sendMessage(mm);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //隐藏actionbar
        //actionBar = getActionBar();
       // actionBar.hide();

        expandlv = (ExpandableListView)findViewById(R.id.explv);

        //处理ui的handler
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg){
                if(msg.what == 0x123){
                    List<Food> l;
                    ArrayList<String> group;
                    ArrayList<ArrayList<String>> child;
                    String result = (String)msg.getData().get("result");
                    getfoodjsonUtil g = new getfoodjsonUtil();
                    l = g.getcategoryjsonUtil(result);
                    group = new listtosublist().toArryListParent(l);
                    child = new listtosublist().toArryListChild(l);
                    //Activity a;
                    expandlv.setAdapter(new Expandableadapte(group, child, MainActivity.this));
                }
            }
        };



        //处理post的handler
        class webposthandler implements Runnable{
            @Override
            public void run(){
                String result = "";
                Map<String, String> map = new HashMap<String, String>();
                map.put("no", "001");
                map.put("student", "cry");
                ArrayList<String> l;
                try{
                    result = new HttpUtil().postRequest(BASE_URL, map);
                    //l =
                }catch (ClientProtocolException e){
                    result = e.getMessage().toString();
                    e.printStackTrace();
                }catch (IOException e){
                    result = e.getMessage().toString();
                    e.printStackTrace();
                } catch(Exception e){
                    result = e.getMessage().toString();
                    e.printStackTrace();
                }
                Message mm = new Message();
                Bundle bb = new Bundle();
                bb.putString("result", result);
                mm.what = 0x123;
                mm.setData(bb);
                handler.sendMessage(mm);

            }
        }


        //设get的单击事件
        /*
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread gt = new Thread(new webgethandler());
                gt.start();
            }
        });
        //设post的单击事件
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread pt = new Thread(new webposthandler());
                pt.start();
            }
        });
        */
    }

    //分类弹出菜单的点击事件
    public void classify_onPopupbuttonClick(View button){
        clasify = new PopupMenu(this, button);
        getMenuInflater().inflate(R.menu.classify_menu, clasify.getMenu());
        clasify.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item){
                        //设地址字符串
                        String categoryID;
                        String elementID = null;
                        String rankID = null;
                        String pageNum = "1";
                        Thread gt = new Thread(new webgethandler());
                        switch (item.getItemId()){
                            case R.id.all:
                                clasify.dismiss();
                                categoryID = "0";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.gulei:
                                clasify.dismiss();
                                categoryID = "1";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.shulei:
                                clasify.dismiss();
                                categoryID = "2";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.gandou:
                                clasify.dismiss();
                                categoryID = "3";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.shucai:
                                clasify.dismiss();
                                categoryID = "4";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.junzao:
                                clasify.dismiss();
                                categoryID = "5";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.shuiguo:
                                clasify.dismiss();
                                categoryID = "6";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.jianguo:
                                clasify.dismiss();
                                categoryID = "7";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.churou:
                                clasify.dismiss();
                                categoryID = "8";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.qinrou:
                                clasify.dismiss();
                                categoryID = "9";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.rulei:
                                clasify.dismiss();
                                categoryID = "10";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.danlei:
                                clasify.dismiss();
                                categoryID = "11";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.haixianlei:
                                clasify.dismiss();
                                categoryID = "12";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                            case R.id.yingyouershipin:
                                clasify.dismiss();
                                categoryID = "13";
                                food_url = BASE_URL + "/getfood?category=" + categoryID + "&&element=" + elementID + "&&rank=" + rankID + "&&page=" + pageNum;
                                gt.start();
                                break;
                        }
                        return true;
                    }
                });
        clasify.show();
    }

    //按元素排序弹出菜单的点击事件
    public void classify_sort_onPopupbuttonClick(View button){
        clasify_sort = new PopupMenu(this, button);
        getMenuInflater().inflate(R.menu.classify_sort, clasify_sort.getMenu());
        clasify_sort.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item){
                        switch (item.getItemId()){
                            case R.id.heat:
                                clasify_sort.dismiss();
                                break;
                            case R.id.protein:
                                clasify_sort.dismiss();
                                break;
                            case R.id.fat:
                                clasify_sort.dismiss();
                                break;
                            case R.id.vitaminC:
                                clasify_sort.dismiss();
                                break;
                            case R.id.vitaminE:
                                clasify_sort.dismiss();
                                break;
                            case R.id.vitaminB1:
                                clasify_sort.dismiss();
                                break;
                            case R.id.vitaminB2:
                                clasify_sort.dismiss();
                                break;
                            case R.id.Fe:
                                clasify_sort.dismiss();
                                break;
                            case R.id.Zn:
                                clasify_sort.dismiss();
                                break;
                            case R.id.Se:
                                clasify_sort.dismiss();
                                break;

                        }
                        return true;
                    }
                });
        clasify_sort.show();
    }

    //升降弹出菜单的点击事件
    public void sort_onPopupbuttonClick(View button){
        sort = new PopupMenu(this, button);
        getMenuInflater().inflate(R.menu.sort, sort.getMenu());
        sort.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item){
                        switch (item.getItemId()){
                            case R.id.increase:
                                sort.dismiss();
                                break;
                            case R.id.decrease:
                                sort.dismiss();
                                break;
                        }
                        return true;
                    }
                });
        sort.show();
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
