package com.example.a1893068.classactivity1;

implementation 'com.android.support:design:28.0.0'

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class classactivity1 extends AppCompatActivity {

    EditText edt_Fname,edt_Lname,edt_email,edt_pass ;
    Button btn_sub;
    String TAG="click submiti";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classactivity1);

        edt_Fname=findViewById(R.id.fname);
        edt_Lname=findViewById(R.id.lname);
        edt_email=findViewById(R.id.iemail);
        edt_pass=findViewById(R.id.passi);

        btn_sub=findViewById(R.id.submiti);

        final Toast mytoast=Toast.makeText(getApplicationContext(),edt_Fname.getText().toString(),Toast.LENGTH_SHORT);

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edt_Fname.getText().toString();
                String lname=edt_Lname.getText().toString();
                String email=edt_email.getText().toString();
                String password=edt_pass.getText().toString();



                Log.v(TAG,name);
                Log.v(TAG,lname);
                Log.v(TAG,email);
                Log.v(TAG,edt_pass.getText().toString());


                // Toast.makeText(getApplicationContext(),edt_name.getText().toString(),Toast.LENGTH_LONG).show();
                mytoast.setText("Karan verma Thank You");
                mytoast.setDuration(Toast.LENGTH_LONG);

                mytoast.show();
                Snackbar.make(v, "Registrationn Done", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }

        });


    }

}