package myviews.com.views;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ThridActivity extends AppCompatActivity  {
String text;

    TextView txt_Value;
    Button btn_Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);
        text=getIntent().getExtras().getString("Value");
        txt_Value=(TextView) findViewById(R.id.txt_Value);
        txt_Value.setText(text);

    }
    public  void onClick(View view){
       /* Intent i=new Intent(this,SecondActivity.class);
        startActivity(i);
        finish();*/

      display(view);
    }


    public void display(View view){
        Snackbar.make(view,"Back Button Pressed",Snackbar.LENGTH_LONG)
                .setAction("Action",null).show();
    }


     }


