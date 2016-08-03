package com.origin.ueliton.bulltrail.util;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.origin.ueliton.bulltrail.R;

/**
 * Created by ueliton on 7/31/16.
 */
public class AlertDialogUtilBuilder {

    private final Context context;
    private final AlertDialog.Builder alertDialog;

    public AlertDialogUtilBuilder(Context context) {
        this.context = context;
        this.alertDialog = new AlertDialog.Builder(context);
    }

    public  AlertDialog.Builder setTittle(String tittle){
        return alertDialog.setTitle(tittle);
    }

    public  AlertDialog.Builder setMessage(String message){
        return alertDialog.setMessage(message);
    }

    public  AlertDialog.Builder error(){
        return alertDialog.setIcon(R.drawable.ic_tree_white_36dp);
    }

    public  AlertDialog.Builder alert(){
        return alertDialog.setIcon(R.drawable.ic_cow_white_36dp);
    }

}
