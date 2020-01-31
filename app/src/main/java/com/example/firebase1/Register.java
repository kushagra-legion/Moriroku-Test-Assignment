package com.example.firebase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
private FirebaseAuth auth;
    TextView t1;
    TextView t2;
    String email;
    String pass;
    public static final String rt="99";
    public static final String key="11";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        auth=FirebaseAuth.getInstance();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }
    public void k2 (View view)
    {  t1=(TextView)findViewById(R.id.editText);
        t2=(TextView)findViewById(R.id.editText2);
        email=t1.getText().toString();
        pass=t2.getText().toString();
        if (email.equals("") || pass.equals(""))
        {   Toast.makeText(Register.this, "You cannot leave any field empty .",
                Toast.LENGTH_LONG).show(); }
        else {
            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(Register.this,new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isComplete()) {
                        Intent intent = new Intent(Register.this, MainActivity.class);
                        startActivity(intent);
                        intent.putExtra(key, rt);
                        Toast.makeText(Register.this, "Registration is succesful",
                                Toast.LENGTH_LONG).show();
                    }
                   else {    Toast.makeText(Register.this, "Registration is Failed.",
                            Toast.LENGTH_LONG).show();

                    }
                }
            });

        }


    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
