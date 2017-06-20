package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad Arslan on 6/17/2017.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceID;

    /**
     * Create a new {@link WordAdapter} object
     * @param context is the current context (i.e Activity) that the adapter is being created
     * @param words is the list of {@link Word}s to be displayed.
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID) {
        super(context, 0, words);
        mColorResourceID=colorResourceID;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link currentWord} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the miwok_text_view.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()){
            // Set the ImageView to the image resource specified in the current Word
            imageView.setImageResource(currentWord.getImageResourcedId());

            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }else{
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        
        // Set the them color for the list item
        View textContainer= listItemView.findViewById(R.id.text_container);
        // Find the color that the resource Id maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceID);
        // Set the beckground color of the text container View
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
