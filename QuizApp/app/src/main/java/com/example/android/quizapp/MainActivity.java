package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count=0;
    String name,reportMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void sendReport(View view){
        // To Send the Test report through SMS.
        Uri uri = Uri.parse("smsto:03453235126");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", reportMessage);
        startActivity(it);

    }

    public void submitAnswers(View view){

        EditText nameText= (EditText)findViewById(R.id.name_edit_txt);
        name=nameText.getText().toString();

        // Question 1---------------------------------------------------------
        RadioButton quest1=(RadioButton)findViewById(R.id.question1_choice4);
        if(quest1.isChecked()){
            count++;
        }

        // Question 2---------------------------------------------------------
        RadioButton quest2=(RadioButton)findViewById(R.id.question2_choice2);
        if(quest2.isChecked()){
            count++;
        }

        // Question 3---------------------------------------------------------
        RadioButton quest3=(RadioButton)findViewById(R.id.question3_choice4);
        if(quest3.isChecked()){
            count++;
        }

        // Question 4---------------------------------------------------------
        RadioButton quest4=(RadioButton)findViewById(R.id.question4_choice3);
        if(quest4.isChecked()){
            count++;
        }

        // Question 5---------------------------------------------------------
        RadioButton quest5=(RadioButton)findViewById(R.id.question5_choice1);
        if(quest5.isChecked()){
            count++;
        }

        // Question 6---------------------------------------------------------
        RadioButton quest6=(RadioButton)findViewById(R.id.question6_choice1);
        if(quest6.isChecked()){
            count++;
        }

        // Question 7---------------------------------------------------------
        CheckBox quest7_A=(CheckBox)findViewById(R.id.question7_choice1);
        CheckBox quest7_B=(CheckBox)findViewById(R.id.question7_choice2);
        CheckBox quest7_C=(CheckBox)findViewById(R.id.question7_choice3);
        CheckBox quest7_D=(CheckBox)findViewById(R.id.question7_choice4);
        if(quest7_A.isChecked() && quest7_B.isChecked()&& !quest7_C.isChecked()&& !quest7_D.isChecked()){
            count++;
        }

        // Question 8---------------------------------------------------------
        RadioButton quest8=(RadioButton)findViewById(R.id.question8_choice3);
        if(quest8.isChecked()){
            count++;
        }

        // Question 9---------------------------------------------------------
        RadioButton quest9=(RadioButton)findViewById(R.id.question9_choice2);
        if(quest9.isChecked()){
            count++;
        }

        // Question 10---------------------------------------------------------
        RadioButton quest10=(RadioButton)findViewById(R.id.question10_choice1);
        if(quest10.isChecked()){
            count++;
        }
        String score=Integer.toString(count);
        if(count>=7){
            Toast.makeText(this,name+" congratulation! you have passed the test and your score is "+score,Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this,name+" try again, you are FAIL and your score is "+score,Toast.LENGTH_LONG).show();

        }

        // collecting data for msg report
        reportMessage="Name: "+name;
        reportMessage +="\nTotal Marks: 10";
        reportMessage +="\nGain Marks: "+count;
        count=0;
    }
}
