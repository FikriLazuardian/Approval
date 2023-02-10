package id.sambu.approval.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.button.MaterialButton;

import id.sambu.approval.R;

public class RevisiDialog {
    Context mContext;
    AlertDialog dialog;
    MaterialButton btnOk;

    public RevisiDialog(Context mContext){
        this.mContext = mContext;
    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.from(mContext).inflate(R.layout.revisi_dialog,null);
        builder.setView(view);
        builder.setCancelable(false);
        dialog = builder.create();
        btnOk =  view.findViewById(R.id.buttonRevisi);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideDialog();
                ((Activity) mContext).finish();
            }
        });
        dialog.show();

    }
    public void hideDialog(){
        dialog.dismiss();
    }
}
