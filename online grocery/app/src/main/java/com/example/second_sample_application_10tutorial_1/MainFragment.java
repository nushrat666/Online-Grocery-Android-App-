package com.example.second_sample_application_10tutorial_1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.second_sample_application_10tutorial_1.Models.GroceryItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";
    private RecyclerView newItemRecView, popularItemsRecView, suggestedItemRecView;
    private BottomNavigationView bottomNavigationView;

    private GroceryItemAdapter newItemAdapter, popularItemsAdapter, suggestedItemAdapter;

    private Utils utils;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        initViews(view);

        initBottomNavigation();

         utils = new Utils();
        utils.initDatabase(getActivity());

        initRecViews();


        return view;
    }

    private void initRecViews() {
        Log.d(TAG, "initRecViews: started");

       newItemAdapter=new GroceryItemAdapter(getActivity());
       popularItemsAdapter=new GroceryItemAdapter(getActivity());
       suggestedItemAdapter=new GroceryItemAdapter(getActivity());

       newItemRecView.setAdapter(newItemAdapter);
       popularItemsRecView.setAdapter(newItemAdapter);
       suggestedItemRecView.setAdapter(newItemAdapter);

       newItemRecView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
       popularItemsRecView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
       suggestedItemRecView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));

        ArrayList<GroceryItem> allItems =utils.getAllItems(getActivity());

    if(null !=allItems){
        newItemAdapter.setItems(allItems);
    }
        Comparator<GroceryItem> popularityComparator=new Comparator<GroceryItem>() {
            @Override
            public int compare(GroceryItem o1, GroceryItem o2) {
                return compareByPopularity(o1,o2);
            }
        };

        Collections.sort(allItems,popularityComparator);
    }
private int compareByPopularity (GroceryItem item1, GroceryItem item2){
    Log.d(TAG, "compareByPopularity: started");

    if(item1.getPopularityPoint()>item2.getPopularityPoint()){
        return 1;
    }else if(item1.getPopularityPoint()>item2.getPopularityPoint()){
        return -1;
    }else{
        return 0;
    }
}
    private void initBottomNavigation() {
        Log.d(TAG, "initBottomNavigation: started");

        bottomNavigationView.setSelectedItemId(R.id.homeActivity);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.search:
                        //TODO: fix this
                        break;

                    case R.id.homeActivity:

                        break;

                    case R.id.cart:
                        Toast.makeText(getActivity(), "Cart Selected", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }


                return true;
            }
        });
    }

    private void initViews(View view) {
        Log.d(TAG, "initViews: started");

        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.bottomNavigationView);
        newItemRecView = (RecyclerView) view.findViewById(R.id.newItemsRecView);
        popularItemsRecView = (RecyclerView) view.findViewById(R.id.PopularItems);
        suggestedItemRecView = (RecyclerView) view.findViewById(R.id.SugestedItems);
    }
}
