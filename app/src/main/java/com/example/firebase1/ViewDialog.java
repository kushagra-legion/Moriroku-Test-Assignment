package com.example.firebase1;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ViewDialog {





        public void showDialog(Activity activity, String msg){
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.custom_dialogbox_otp);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            TextView text = (TextView) dialog.findViewById(R.id.txt_file_path);
            text.setText(msg);

            Button dialogBtn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
            dialogBtn_cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(getApplicationContext(),"Cancel" ,Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            });

            Button dialogBtn_okay = (Button) dialog.findViewById(R.id.btn_okay);
            dialogBtn_okay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    override the success operation

//                    Toast.makeText(getApplicationContext(),"Okay" ,Toast.LENGTH_SHORT).show();
                    Firstpage.getInstance().permission();
                    dialog.cancel();
                }
            });

            dialog.show();
        }
    }

