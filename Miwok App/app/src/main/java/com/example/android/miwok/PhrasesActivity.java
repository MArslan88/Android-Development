package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListenre =new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Create an array of words
        final ArrayList<Word> words=new ArrayList<Word>();
        //words.add("One");
        words.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is yourname?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you comming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, i'm coming...","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming.","әәnәm",R.raw.phrase_im_coming));
        words.add(new Word("Let's go..","yoowutis",R.raw.phrase_lets_go));
        words.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));
        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the

        WordAdapter adapter =
                new WordAdapter(this, words,R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {alink Word} object at the given posion the user clicked on
                Word word = words.get(position);

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();


                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sound.
        releaseMediaPlayer();
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
