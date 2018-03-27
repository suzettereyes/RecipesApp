package com.example.fsa.miniapp2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

//after search button has been clicked
//textview on top of list showing no. of recipes found
//no recipes found = shows 0 recipes
//each row has image, recipe title, serving no., diet label, prep time, and want to make
//when user clicks on button = notification with instruction URL

public class ResultActivity extends AppCompatActivity {
    private ListView mListView;
    private Context mContext;
    private TextView recipeNumber;
    private Button CookButton;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mContext = this;

        String diet = this.getIntent().getStringExtra("diet");
        String serving = this.getIntent().getStringExtra("serving");
        String time = this.getIntent().getStringExtra("time");

        final ArrayList<Recipe> recipeList = Recipe.getRecipesFromFile("recipes.json", this);
    }

}
