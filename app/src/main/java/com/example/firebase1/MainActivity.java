package com.example.firebase1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LoginButton logbut;
    String rt;
    public static final String rt1="9999";
    public static final String rt2="9999";
    public static final String rt3="9998";
    public static final String key="10001";
    public static final String key1="10002";
    public static final String key2="10003";
    public static final String key3="10004";
    CallbackManager callbackManager;
    GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;
    private static final String TAG = "myApp";
    private static final int RC_SIGN_IN = 9001;
    TextView t1;
    TextView t2;
    String email;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //next 2 lines for creating this activity a fullScreen Activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        FirebaseApp.initializeApp(this);
       findViewById(R.id.login_button1).setOnClickListener(this);

        //findViewById(R.id.login_button1).setOnClickListener((View.OnClickListener) this);

// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        logbut=(LoginButton)findViewById(R.id.login_button);
        callbackManager=CallbackManager.Factory.create();

        logbut.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                rt=loginResult.getAccessToken().getUserId().toString();
                kush();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }

        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI1(currentUser);
        // Check for existing Google Sign In account, if the user is already signed in
// the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
    }

    private void updateUI1(FirebaseUser currentUser) {
        if (currentUser!=null)

         {
            Intent intent = new Intent(MainActivity.this, Firstpage.class);
            startActivity(intent);
            intent.putExtra(key2, rt2);
        }
    }

    public void updateUI(GoogleSignInAccount account){
        GoogleSignInAccount account1=account;

        if (account1!=null)

        {
            Intent intent = new Intent(MainActivity.this, Firstpage.class);
            startActivity(intent);
            intent.putExtra(key2, rt2);
        }
    }
    public void kush()
    { Intent intent=new Intent(MainActivity.this,Facebookpage.class);
        startActivity(intent);
        intent.putExtra(key,rt);
    }
    public void k1(View view){
     t1=(TextView)findViewById(R.id.editText);
     t2=(TextView)findViewById(R.id.editText2);
     email=t1.getText().toString();
     pass=t2.getText().toString();
    if (email.equals("") || pass.equals(""))
    {   Toast.makeText(MainActivity.this, "You cannot leave any field empty .",
            Toast.LENGTH_LONG).show(); }
    else {
        mAuth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this, "Welcome Back !!",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, Firstpage.class);
                startActivity(intent);
                intent.putExtra(key2, rt2);
            }

        });
    }
    }

    public void registeration (View view){
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
        intent.putExtra(key3, rt3);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);

        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
  /* public void signIn(View view)
   {
       Intent intent=new Intent(MainActivity.this,SignIn.class);
       startActivity(intent);
       intent.putExtra(key1,rt1);
   }*/
  /* public void signgoogle(View view) {

       switch (view.getId()) {
           case R.id.login_button1:
               signIn();
               break;
       }
   }*/
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI1(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                           // Snackbar.make(findViewById(R.id.main), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                            updateUI1(null);
                        }

                        // ...
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button1:
                signIn();
                break;
        }
    }
}
