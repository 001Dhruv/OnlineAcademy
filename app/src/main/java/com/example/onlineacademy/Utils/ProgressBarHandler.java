package com.example.onlineacademy.Utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ProgressBar;

public class ProgressBarHandler {
    public static void showProgressDialog(ProgressDialog progressDialog, String msg){
        progressDialog.setMessage(msg);
        progressDialog.show();
    }
    public static void hideProgressDialog(ProgressDialog progressDialog){
        if (progressDialog != null&&progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
