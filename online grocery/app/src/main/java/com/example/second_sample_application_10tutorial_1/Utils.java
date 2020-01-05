package com.example.second_sample_application_10tutorial_1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.second_sample_application_10tutorial_1.Models.GroceryItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {
    private static final String TAG = "Utils";

    public static final String DATABASE_NAME = "fake_database";

    private static int ID = 0;

    public Utils() {
    }

    public static int getID() {
        ID++;
        return ID;
    }

    public void initDatabase(Context context) {
        Log.d(TAG, "initDatabase: started");

        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);


        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<GroceryItem>>() {
        }.getType();
        ArrayList<GroceryItem> possibleItems = gson.fromJson(sharedPreferences.getString("allItems", ""), type);

        if (null == possibleItems) {
            initAllItems(context);
        }
initAllItems(context);

    }

    public ArrayList<GroceryItem> getAllItems (Context context){
        Log.d(TAG, "getAllItems: started");
        Gson gson = new Gson();
        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME,Context.MODE_PRIVATE);
        Type type= new TypeToken<ArrayList<GroceryItem>>(){}.getType();
        ArrayList<GroceryItem> allItems=gson.fromJson(sharedPreferences.getString("allItems",null),type);
        return allItems;
    }



    private void initAllItems(Context context) {
        Log.d(TAG, "initAllItems: started");


        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();

        sharedPreferences = context.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        gson = new Gson();

        ArrayList<GroceryItem> allItems = new ArrayList<>();

        GroceryItem IceCream=new GroceryItem("ice cream","produced of fresh milk",
                "https://cms-static.wehaacdn.com/hoards-com/images/milk.16566.jpg",
                "food", 15, 2.5);

        IceCream.setPopularityPoint(10);


        allItems.add(new GroceryItem("cheese","Best cheese possible",
                "https://cdn1.harryanddavid.com/wcsstore/HarryAndDavid/images/catalog/19_27281_30GM_01ex.jpg",
                "food", 3, 4.45));
        allItems.add(new GroceryItem("Cucumber","Best Cucumber possible",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTapdZPL-NqqJaAr_wvW6LueDwcGZhoCHmG8dmiLZffhIcsUyFN&s",
                "food", 7, 9.4));
        allItems.add(new GroceryItem("Coca Cola","Tasty",
                "https://img.etimg.com/thumb/width-640,height-480,imgsize-412854,resizemode-1,msid-71812767/coca-cola-set-to-sell-some-bottling-units-to-partners.jpg",
                "food", 8, 7.56));
        allItems.add(new GroceryItem("Spaghetti","Best Spaghetti possible",
                "https://www.fivehearthome.com/wp-content/uploads/2019/03/One-Pot-Spaghetti-Recipe-by-Five-Heart-Home_700pxPlate.jpg",
                "food", 30, 4.95));
        allItems.add(new GroceryItem("Chiken Nugget","Best Chiken Nugget possible",
                "https://media.npr.org/assets/img/2017/05/09/10-piece-chicken-nuggets-ss_0_custom-db31f599b4b36050d9a26986abaf75c76c655f37-s800-c85.jpg",
                "food", 56, 43.45));
        allItems.add(new GroceryItem("Clear Shampoo","Good Product",
                "https://domreii.com/pub/media/catalog/product/cache/c687aa7517cf01e65c009f6943c2b1e9/5/a/5ae29e21nd298d8d9.jpg",
                "Usable Product", 300, 79));
        allItems.add(new GroceryItem("Axe Body Spray","Good Product",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVeix3yPPYull7SYmkASN3wmHhCsbLdKec61eGXdrLTmDHS_dO&s",
                "Usable Product", 98, 90));
        allItems.add(new GroceryItem("Kleenex","Good Product",
                "https://www.kleenex.com.gwstest.net/-/media/images/kleenex/products-new/anti-viral/boxes-upright/antiviralgreen.png?h=365&w=424&la=en-US&hash=BFC4457B88C931E5A91BEE678ECE900A36796C0E",
                "Usable Product", 89, 43));
        allItems.add(new GroceryItem("Face Wash","Good Product",
                "https://ntg-catalog.imgix.net/products/NTG_70501028209_30034003_Oil_Free_Acne_Wash_Daily_Scrub_4.2oz_00000.jpg?w=1200&h=1443&sfrm=jpg&fit=crop",
                "Usable Product", 92, 9.45));

allItems.add(IceCream);
        String finalString =gson.toJson(allItems);
        editor.putString("allItems",finalString);
        editor.commit();

    }
}
