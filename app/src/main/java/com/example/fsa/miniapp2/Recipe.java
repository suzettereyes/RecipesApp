package com.example.fsa.miniapp2;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;

    public class Recipe {
        //instance variable or fields
        public String title;
        public String imageUrl;
        public String url;
        public String description;
        public int servings;
        public String prepTime;
        public String dietLabel;

        //constructor
        //use default

        //method
        //static methods that read the json file in and load into Recipe

        //static method that loads our recipes.json using the helper method
        //this method will return an array list of recipes constructed from the JSON file
        public static ArrayList<Recipe> getRecipesFromFile(String filename, Context context) {
            ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

            //try to read from JSON file
            //get info by using the tags
            //construct a Recipe Object for each recipe in JSON
            //add the object to arraylist
            //return arraylist
            try {
                String jsonString = LoadJsonFromAsset("recipes.json", context);
                JSONObject json = new JSONObject(jsonString);
                JSONArray recipes = json.getJSONArray("recipes");

                //for loop to go through each recipe in your recipes array

                for (int i = 0; i < recipes.length(); i++) {
                    Recipe recipe = new Recipe();
                    recipe.title = recipes.getJSONObject(i).getString("title");
                    recipe.imageUrl = recipes.getJSONObject(i).getString("image");
                    recipe.url = recipes.getJSONObject(i).getString("url");
                    recipe.description = recipes.getJSONObject(i).getString("description");
                    recipe.servings = recipes.getJSONObject(i).getInt("servings");
                    recipe.prepTime = recipes.getJSONObject(i).getString("prepTime");
                    recipe.dietLabel = recipes.getJSONObject(i).getString("dietLabel");


                    //add to arraylist
                    recipeList.add(recipe);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return recipeList;
        }

        //helper method that loads from JSON
        private static String loadJsonFromAsset(String filename, Context context) {
            String json = null;

            try {
                InputStream is = context.getAssets().open(filename);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (java.io.IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return json;
        }
    }
}
}
