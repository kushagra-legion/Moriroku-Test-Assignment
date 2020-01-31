package com.example.firebase1;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class Firstpage extends AppCompatActivity {
    private static Firstpage instance;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_STORAGE_PERMISSION = 1;
    private static final String FILE_PROVIDER_AUTHORITY = "com.example.android.fileprovider";
    private String mTempPhotoPath;
    private Bitmap mResultsBitmap;
    private AppBarConfiguration mAppBarConfiguration;
    private static final String ke2="101";
    private static final String r="999";
    private static final String ke3="102";
    private static final String r1="998";
    private static final String ke4="103";
    private static final String r2="997";
    private static final String ke5="104";
    private static final String r3="996";
    private static final String ke6="105";
    private static final String r4="995";
    private static final String ke7="106";
    private static final String r5="994";
    private static final String ke8="107";
    private static final String r6="993";
    private static final String ke9="108";
    private static final String r7="992";
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        instance = this;

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id= menuItem.getItemId();
                if(id==R.id.admin){
                    Intent intent = new Intent(Firstpage.this, administratoractivity.class);
                    startActivity(intent);
                    intent.putExtra(ke2, r);
                }
              else if(id==R.id.inquiry){
                    Intent intent = new Intent(Firstpage.this, inquiry.class);
                    startActivity(intent);
                    intent.putExtra(ke3, r1);
                }
              else if(id==R.id.products){
                    Intent intent = new Intent(Firstpage.this, products.class);
                    startActivity(intent);
                    intent.putExtra(ke4, r2);
                }
              else if(id==R.id.clients){
                    Intent intent = new Intent(Firstpage.this, clients.class);
                    startActivity(intent);
                    intent.putExtra(ke5, r3);
                }
              else if(id==R.id.learn){
                    Intent intent = new Intent(Firstpage.this, learn.class);
                    startActivity(intent);
                    intent.putExtra(ke6, r4);
                }
              else if(id==R.id.feedback){
                    Intent intent = new Intent(Firstpage.this, feedback.class);
                    startActivity(intent);
                    intent.putExtra(ke7, r5);
                }
                else if(id==R.id.aboutus){
                    Intent intent = new Intent(Firstpage.this, aboutus.class);
                    startActivity(intent);
                    intent.putExtra(ke8, r6);
                }


                DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
       }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.firstpage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
         if(id==R.id.logout){
            Toast.makeText(Firstpage.this, "Logout Successful !!",
                    Toast.LENGTH_LONG).show();
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent = new Intent(Firstpage.this, MainActivity.class);
            startActivity(intent);
            intent.putExtra(ke9, r7);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void imagechange(View view){
        ViewDialog alert = new ViewDialog();
        alert.showDialog(Firstpage.this, "Profile Picture ");


    }
    public static Firstpage getInstance() {
        return instance;
    }
    public  void permission()
    {
        // Check for the external storage permission
        if (ContextCompat.checkSelfPermission(Firstpage.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // If you do not have permission, request it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_STORAGE_PERMISSION);
        } else {
            // Launch the camera if the permission exists
            launchCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // Called when you request permission to read and write to external storage
        switch (requestCode) {
            case REQUEST_STORAGE_PERMISSION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // If you get permission, launch the camera
                    launchCamera();
                } else {
                    // If you do not get permission, show a Toast
                    Toast.makeText(this, "permission is denied..", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }

    }

    /**
     * Creates a temporary image file and captures a picture to store in it.
     */
    private void launchCamera() {

        // Create the capture image intent
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the temporary File where the photo should go
            File photoFile = null;
            try {
                photoFile = BitmapUtils.createTempImageFile(this);
            } catch (IOException ex) {
                // Error occurred while creating the File
                ex.printStackTrace();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {

                // Get the path of the temporary file
                mTempPhotoPath = photoFile.getAbsolutePath();

                // Get the content URI for the image file
                Uri photoURI = FileProvider.getUriForFile(this,
                        FILE_PROVIDER_AUTHORITY,
                        photoFile);

                // Add the URI so the camera can store the image
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);

                // Launch the camera activity
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // If the image capture activity was called and was successful
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Process the image and set it to the TextView
            processAndSetImage();
        } else {

            // Otherwise, delete the temporary image file
            BitmapUtils.deleteImageFile(this, mTempPhotoPath);
        }
    }

    private void processAndSetImage() {

        // Toggle Visibility of the views
     /*   mEmojifyButton.setVisibility(View.GONE);
        mTitleTextView.setVisibility(View.GONE);
        mSaveFab.setVisibility(View.VISIBLE);
        mShareFab.setVisibility(View.VISIBLE);
        mClearFab.setVisibility(View.VISIBLE);
   */
        // Resample the saved image to fit the ImageView
        mResultsBitmap = BitmapUtils.resamplePic(this, mTempPhotoPath);
        imageView1=(ImageView)findViewById(R.id.imageView);

       // Set the new bitmap to the ImageView
        imageView1.setImageBitmap(mResultsBitmap);
    }


    /**
     * OnClick method for the save button.
     *
    // * @param view The save button.
     */
   /* public void saveMe(View view) {
        // Delete the temporary image file
        BitmapUtils.deleteImageFile(this, mTempPhotoPath);

        // Save the image
        BitmapUtils.saveImage(this, mResultsBitmap);
    }
*/






}
