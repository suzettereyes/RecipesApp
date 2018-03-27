package com.example.fsa.miniapp2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private Context mContext;
    private Spinner servingSpinner;
    private Spinner prepSpinner;
    private Spinner dietSpinner;
    private Button search_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mContext = this;

        //get the spinner from the xml
        Spinner dietDropdown = findViewById(R.id.diet_restriction_dropdown);
        Spinner servingDropdown = findViewById(R.id.serving_restriction_dropdown);
        Spinner prepDropdown = findViewById(R.id.prep_time_restriction_dropdown);
        Button search_button = findViewById(R.id.search_button);

        final ArrayList<Recipe> recipeList = Recipe.getRecipesFromFile("recipes.json", this);
        ArrayList<String> dietChoices = new ArrayList<String>();
        dietChoices.add("None");
        //?????????????????
        for (int i=0; i < recipeList.size(); i++) {
            if(!dietChoices.contains(recipeList.get(i).label)){
                dietChoices.add(recipeList.get(i).label);
            }
        }

        ArrayAdapter<String> dietAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, dietChoices);
        dietSpinner.setAdapter(dietAdapter);
        String[] servingChoice = new String[] {"None", "Less than 4", "4-6", "7-9", "More than 10"};

        ArrayAdapter<String> servingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, servingChoice);
        servingSpinner.setAdapter(servingAdapter);
        String[] prepChoice = new String[]{"None", "30 mins or less", "Less than 1 hour", "More than 1 hour"};

        ArrayAdapter<String> prepAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, prepChoice);
        prepSpinner.setAdapter(prepAdapter);

        //didn't get to finish 
    }
}