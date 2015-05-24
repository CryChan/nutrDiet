package com.example.administrator.myprojest103;

/**
 * Created by Administrator on 15-5-19.
 */
//需解析的food类
public class Food {
    String id;
    String name;
    String heat;
    String protein;
    String fat;
    String vitaminC;
    String vitaminE;
    String vitaminB1;
    String vitaminB2;
    String Fe;
    String Zn;
    String Se;
    String category;
    String isDel;
    public  Food(String id, String name, String heat, String protein, String fat, String vitaminC,
                 String vitaminE, String vitaminB1, String vitaminB2, String Fe, String Zn, String Se,
                 String category, String isDel)
    {
        super();
        this.id = id;
        this.name = name;
        this.heat = heat;
        this.protein = protein;
        this.fat = fat;
        this.vitaminC = vitaminC;
        this.vitaminE = vitaminE;
        this.vitaminB1 = vitaminB1;
        this.vitaminB2 = vitaminB2;
        this.Fe = Fe;
        this.Zn = Zn;
        this.Se = Se;
        this.category = category;
        this.isDel = isDel;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getHeat(){
        return heat;
    }
    public String getProtein(){
        return protein;
    }
    public String getFat(){
        return fat;
    }
    public String getVitaminC(){
        return vitaminC;
    }
    public String getVitaminE(){
        return vitaminE;
    }
    public String getVitaminB1(){
        return vitaminB1;
    }
    public String getVitaminB2(){
        return vitaminB2;
    }
    public String getFe(){
        return Fe;
    }
    public String getZn(){
        return Zn;
    }
    public String getSe(){
        return Se;
    }
    public String getCategory(){
        return category;
    }
    public String getIsDel(){
        return isDel;
    }
}
