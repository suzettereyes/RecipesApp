package com.example.fsa.miniapp2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

//displays front page of app
//background image
//start button
//Brings search once start button is clicked

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    Button start_button;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        start_button = findViewById(R.id.start_button);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SearchIntent = new Intent(mContext, SearchActivity.class);
                startActivity(SearchIntent);
            }
        });
    }
}
