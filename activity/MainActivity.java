package com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.activity;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.R;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.adapter.HomeAdapter;




public class MainActivity extends AppCompatActivity  {

    Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        context=this;
        initDefine();


    }


    public int[] arrOfCategory;
    private void initDefine() {
        rvCategory=findViewById(R.id.rvCategory);
        arrOfCategory = new int[]{R.drawable.learn11, R.drawable.choosee, R.drawable.listen};
        setRvAdapter();
    }



    HomeAdapter homeAdapter;
    RecyclerView rvCategory;
    private void setRvAdapter() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rvCategory.setLayoutManager(linearLayoutManager);
        homeAdapter=new HomeAdapter(context,arrOfCategory);
        rvCategory.setAdapter(homeAdapter);
    }




}
