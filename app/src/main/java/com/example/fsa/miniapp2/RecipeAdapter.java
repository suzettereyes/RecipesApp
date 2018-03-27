package com.example.fsa.miniapp2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by fsa on 2/7/2018.
 */
//adapter is needed when you want to do any sort of list or table view
//gets data and decides where to display in the app

public class RecipeAdapter extends BaseAdapter {
    //adapter takes the app itself and a list of data to display
    //instance variables
    private Context mContext;
    private ArrayList<Recipe> mRecipeList;
    private LayoutInflater mInflater;

    //constructor
    public RecipeAdapter (Context mContext, ArrayList<Recipe> mRecipeList) {
        //initialize instance variables
        this.mContext = mContext;
        this.mRecipeList = mRecipeList;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //methods
    //a list of methods we need to override
    //gives you the number of recipes in the data source
    @Override
    public int getCount(){
        return mRecipeList.size();
    }
    //returns the item at specific position in the data source
    @Override
    public Object getItem(int position) {
        return mRecipeList.get(position);
    }

    //returns the row id associated with the specific position in the list
    @Override
    public long getItemId(int position) {
        return position;
    }

    //returns a view
    //gets all the view and decides what info gets put in the view
    @Override
    public View getView(int position, View convertView, ViewGroup parents) {
        ViewHolder holder;

        //check if the view already exists
        //if yes, you don't need to inflate and findViewId again
        if (convertView == null){
            //inflate
            convertView = mInflater.inflate(R.layout.list_item_recipe, parents, false);
            //add the views to the holder
            holder = new ViewHolder();
            //views
            //these are the instance variables created in the class
            holder.titleTextView = convertView.findViewById(R.id.recipe_list_title);
            holder.servingTextView = convertView.findViewById(R.id.recipe_list_serving);
            holder.thumnailImageView = convertView.findViewById(R.id.recipe_list_thumbnail);
            holder.prepTimeTextView = convertView.findViewById(R.id.recipe_prep_time);
            holder.dietLabelTextView = convertView.findViewById(R.id.recipe_diet_time);
            holder.recipeCookButton = convertView.findViewById(R.id.recipe_cook_button);
            //add the holder to the view
            //for future use
            convertView.setTag(holder);
        }
        else{
            //get the view holder from convertview
            holder = (ViewHolder) convertView.getTag();
        }
        //get relevant subview of the row view
        TextView titleTextView = holder.titleTextView;
        TextView servingTextView = holder.servingTextView;
        ImageView thumbnailImageView = holder.thumnailImageView;
        TextView prepTimeTextView = holder.prepTimeTextView;
        TextView dietLabelTextView = holder.dietLabelTextView;
        Button recipeCookButton = holder.recipeCookButton;


        //get corresponfing recipe for each row
        //getitem casts it into an object t
        Recipe recipe = (Recipe)getItem(position);

        //update the row view's textview and imageview to display the iformation

        //title textview
        titleTextView.setText(recipe.title);
        //change it to diff color
        titleTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorAccent));
        titleTextView.setTextSize(18);

        //serving textView
        servingTextView.setText(recipe.servings + "servings");
        servingTextView.setTextSize(14);
        servingTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));

        //imageview
        //use picasso library to load image from the image url that we parsed into recipe object
        Picasso.with(mContext).load(recipe.imageUrl).into(thumbnailImageView);
        return convertView;

    }

    //viewholder is used to customize what you want to put into the view
    //it depends on the layout design of your row
    //this will be a private static class you have to define
    //need to build a viewholder  and then a getview
    private static class ViewHolder {
        public TextView TitleTextView;
        public TextView servingTextView;
        public ImageView thumnailImageView;
    }

    //intent is used to pass informatin between activities
    //intent --> package
    //sender, receiver

}
