package com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.activity;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.R;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.adapter.HomeCategoriesAdapter;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.utils.Utils;

public class HomeActivity extends AppCompatActivity {

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        context = this;
        initDefine();


    }



    public int[] mainCategoryList;
    String[] homeCategoryTitles;
    TextView txtExamTitle;
    int type=1;
    private void initDefine() {
        rvHomeCategories = findViewById(R.id.rvHomeCategories);
        txtExamTitle = findViewById(R.id.txtTitleSubHome);
        Intent intent=getIntent();
        type=intent.getIntExtra("Type",1);

        if(type==1){
            txtExamTitle.setText("Kids Learn with Fun");
        }else if(type==2){
            txtExamTitle.setText("CHOOSE AND PLAY");
        }else if(type==3){
            txtExamTitle.setText("LISTEN AND CHOOSE");

        }
        homeCategoryTitles = new String[]{"Alphabets", "Numbers", "Colours",  "Swar valak", "Vyanjanas","Konkani Words", "Birds",  "Fruits", "Month", "Vegetable", "Body Parts","Shapes","Animal"};
        mainCategoryList = new int[]{R.drawable.alphabet1, R.drawable.numbers1, R.drawable.colours, R.drawable.barakhadi1, R.drawable.kakha, R.drawable.konk, R.drawable.birds1, R.drawable.fru, R.drawable.months, R.drawable.vegetables1, R.drawable.bodyparts,R.drawable.shapes1,R.drawable.animal1};
        setRvAdapter();

    }

    HomeCategoriesAdapter homeCategoriesAdapter;
    RecyclerView rvHomeCategories;

    private void setRvAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        rvHomeCategories.setLayoutManager(gridLayoutManager);
        homeCategoriesAdapter = new HomeCategoriesAdapter(context, mainCategoryList,homeCategoryTitles,type);
        rvHomeCategories.setAdapter(homeCategoriesAdapter);
    }

    public void onClickBack(View view) {
        finish();
    }
}
