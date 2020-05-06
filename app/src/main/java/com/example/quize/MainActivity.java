package com.example.quize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int rightAns=0;
    private CheckBox checkBox3a,checkBox3b,checkBox3c,checkBox3d,checkBox4a,checkBox4b,checkBox4c,checkBox4d;
    private EditText editText5,editText6,editText8;
    private RadioGroup radioGroup1,radioGroup2;
    private RadioButton radioQ1,radioQ2;
    private ImageButton imageButton7c;
    private TextView textView;
    private ScrollView scroll;
    //AKS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scroll = (ScrollView) findViewById(R.id.Scroll);
        checkBox4a = (CheckBox) findViewById(R.id.checkBox_4a);
        checkBox4b = (CheckBox) findViewById(R.id.checkBox_4b);
        checkBox4c = (CheckBox) findViewById(R.id.checkBox_4c);
        checkBox4d = (CheckBox) findViewById(R.id.checkBox_4d);
        checkBox3a = (CheckBox) findViewById(R.id.checkBox_3a);
        checkBox3b = (CheckBox) findViewById(R.id.checkBox_3b);
        checkBox3c = (CheckBox) findViewById(R.id.checkBox_3c);
        checkBox3d = (CheckBox) findViewById(R.id.checkBox_3d);
        editText5=(EditText)findViewById(R.id.edit5);
        editText6=(EditText)findViewById(R.id.edit6);
        editText8=(EditText)findViewById(R.id.edit8);
        radioGroup1=(RadioGroup)findViewById(R.id.myRadioGroup);
        radioGroup2=(RadioGroup)findViewById(R.id.myRadioGroup2);
        radioQ1=(RadioButton)findViewById(R.id.optionA2);
        radioQ2=(RadioButton)findViewById(R.id.optionB2);
        imageButton7c=(ImageButton)findViewById(R.id.img7c);
        textView=(TextView)findViewById(R.id.answer);
        imageButton7c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightAns+=1;
                imageButton7c.setClickable(false);

            }
        });

    }
//AKS

    public void submitQuiz(View view) {
        Button submit=(Button)findViewById(R.id.submitB);
        int wrongAns;
        checkAnswer();
        wrongAns=8-rightAns;
        if(rightAns==8) {
            Toast.makeText(this, "Congrats, All Answers Correct", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Correct Answers: " + rightAns + " /8\n" + "Wrong Answers: "+wrongAns, Toast.LENGTH_LONG).show();
        }
        rightAns=0;
        display();
    }

    private void display() {
        textView.setText("Answer:\n 1.b \n 2.b \n 3.Except c \n 4.Except c \n 5.bfs \n 6.O(bm) \n 7.c \n 8.con");
    }

    private void checkAnswer() {
        String txt5=editText5.getText().toString();
        String answer5="bfs";
        String txt6=editText6.getText().toString();
        String answer6="O(bm)";
        String txt8=editText8.getText().toString();
        String answer8="con";
        boolean check3a = checkBox3a.isChecked();
        boolean check3b = checkBox3b.isChecked();
        boolean check3c = checkBox3c.isChecked();
        boolean check3d = checkBox3d.isChecked();
        boolean check4a = checkBox4a.isChecked();
        boolean check4b = checkBox4b.isChecked();
        boolean check4c = checkBox4c.isChecked();
        boolean check4d = checkBox4d.isChecked();
        if (check4a == true && check4b == true && check4c == false && check4d == true) {
            rightAns++;
        }
        if (check3a == true && check3b == true && check3c == false && check3d == true) {
            rightAns++;
        }
        if(answer5.equals(txt5)){
            rightAns++;
        }
        if(answer6.equals(txt6)){
            rightAns++;
        }
        if(answer8.equals(txt8)){
            rightAns++;
        }
        if(radioQ1.isChecked()){
            rightAns++;
        }
        if(radioQ2.isChecked()){
            rightAns++;
        }

    }
    public void resetQuiz(View view) {
        checkBox3a.setChecked(false);
        checkBox3b.setChecked(false);
        checkBox3c.setChecked(false);
        checkBox3d.setChecked(false);
        checkBox4a.setChecked(false);
        checkBox4b.setChecked(false);
        checkBox4c.setChecked(false);
        checkBox4d.setChecked(false);
        editText5.setText("");
        editText6.setText("");
        editText8.setText("");
        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        rightAns=0;
        textView.setText(" ");
        imageButton7c.setClickable(true);
        scroll.fullScroll(ScrollView.FOCUS_UP);


    }
}
