package id.sambu.approval.utils;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

import id.sambu.approval.R;

public class LoadingDialogBar {
    Context mContext;
    AlertDialog dialog;

    public LoadingDialogBar(Context mContext){
        this.mContext = mContext;
    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        builder.setView(inflater.inflate(R.layout.loading_dialog,null));
        builder.setCancelable(false);
        dialog = builder.create();
        dialog.show();
    }
    public void hideDialog(){
        dialog.dismiss();
    }
}
