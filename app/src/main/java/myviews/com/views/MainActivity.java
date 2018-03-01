package myviews.com.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    private static  String TAG="My Message";
    TextView txt_display;
    private ProgressDialog progressDialog;
    private Object object;
    DatabaseReference mRootRef= FirebaseDatabase.getInstance().getReference();
    DatabaseReference conditionRef=mRootRef.child("user");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog =new ProgressDialog(this);
        txt_display=(TextView) findViewById(R.id.txt_Display);

        Log.i(TAG,"In On Create");
    }

  public void onExitApp(View view){
        Toast.makeText(this,"App Exited",Toast.LENGTH_SHORT).show();
        System.exit(0);
    }
    @Override
    public void onClick(View view){


    }
    public void on_Login(View view){
                EditText txt_Username=(EditText) findViewById(R.id.txt_Username);
                String text2=txt_Username.getText().toString();
                conditionRef.setValue(text2);
                startActivity(new Intent(this,SecondActivity.class));
    }
    boolean cond= false;
    public void onStart()
    {
        super.onStart();
        Log.i(TAG,"Paused");
        conditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                text=dataSnapshot.getValue(String.class);
                txt_display.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError.toString());
            }
        });
        if (cond=true){
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }

    }
    String text;
    private void read_User()
    {
        EditText txt_Password=(EditText) findViewById(R.id.txt_Password);
        EditText txt_Username=(EditText) findViewById(R.id.txt_Username);
        if(!TextUtils.isEmpty(txt_Password.getText()) && !TextUtils.isEmpty(txt_Username.getText()) ){
            txt_Username.setText("");
            txt_Username.setText("");
            Toast.makeText(this,"Second Activity",Toast.LENGTH_SHORT).show();
            progressDialog.setMessage("Reading Credentials..");
            progressDialog.show();
            progressDialog.dismiss();


        }
        else{
            Toast.makeText(this,"Input All Details",Toast.LENGTH_SHORT).show();
     }


}
@Override
protected void onPause(){
    super.onPause();
    Log.i(TAG,"Paused");

}
    @Override
    protected void onResume(){
        super.onResume();

        Log.i(TAG,"Resume");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"Restart");
    }
@Override
protected void onStop(){
    super.onStop();
    Log.i(TAG,"Stopped");
}
@Override
protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"Destroyed");
    }


}
