/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Find the View that shows the numbers category
        TextView number = (TextView) findViewById(R.id.numbers);

        //Set a clickListener on that View
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent=new Intent(MainActivity.this,NumbersActivity.class);

                //Start the new activity
                startActivity(numbersIntent);
            }
        });

        //Find the View that shows the family category
        TextView family=(TextView) findViewById(R.id.family);

        //Set a click listener on that View
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyIntent=new Intent(MainActivity.this,FamilyActivity.class);

                //Start the new activity
                startActivity(familyIntent);
            }
        });

        //Find the View that shows the colors category
        TextView colors=(TextView) findViewById(R.id.colors);

        //Set a click listener on that View
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorIntent=new Intent(MainActivity.this,ColorsActivity.class);

                //Start the new activity
                startActivity(colorIntent);
            }
        });

        //Find the View that shows phrases category
        TextView phrases=(TextView) findViewById(R.id.phrases);

        //Set a click listener on that View
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent=new Intent(MainActivity.this,PhrasesActivity.class);

                //Start the new activity
                startActivity(phrasesIntent);
            }
        });

    }



//    public void opensNumbersList(View view){
//        // Executed in an Activity, so 'this' is the Context and 'NumbersActivity.class' is component
//        Intent i = new Intent(this, NumbersActivity.class);
//        startActivity(i);
//    }
}
