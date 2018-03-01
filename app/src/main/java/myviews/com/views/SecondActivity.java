package myviews.com.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity  {
    TextView txt_Updates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
       txt_Updates=(TextView) findViewById(R.id.txt_NumberOfUpdates);
    }
    public void get_Intent(View view,String val){
        Intent i=new Intent(this,ThridActivity.class);
        i.putExtra("Value",val);
        startActivity(i);
        finish();
    }
    int a;
    public void on_Click(View v){
        Button btn_check=new Button(this);

        final Update my_Buttons=new Update();
      //  String text= FirebaseInstanceId.getInstance().getToken();

        a+=1;
        my_Buttons.Set_Int(a);
        Integer num=a;
        txt_Updates.setText(num.toString());
        btn_check.setText("Button " + num.toString());
        my_Buttons.Set_String(btn_check.getText().toString());
        btn_check.setId(my_Buttons.Get_Id());
        btn_check.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            get_Intent(view,my_Buttons.GetInfo());
            }
        });
        LinearLayout root=(LinearLayout) findViewById(R.id.root);
        root.addView(btn_check);
    }
    private void doIncrement(){

    }
    protected void onPause(){
        super.onPause();

        Toast.makeText(this,"done",Toast.LENGTH_SHORT).show();
    }
    }


