package id.sambu.approval.utils;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import id.sambu.approval.R;

public class EditRevisiDialog {
    Context mContext;
    AlertDialog dialog;
    Button btnOk;

    public EditRevisiDialog(Context mContext){
        this.mContext = mContext;
    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.from(mContext).inflate(R.layout.edit_revisi_dialog,null);
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
