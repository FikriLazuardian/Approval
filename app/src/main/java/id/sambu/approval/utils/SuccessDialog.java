package id.sambu.approval.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.button.MaterialButton;

import id.sambu.approval.R;

public class SuccessDialog {
    Context mContext;
    AlertDialog dialog;
    MaterialButton btnOk;

    public SuccessDialog(Context mContext){
        this.mContext = mContext;
    }

    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.from(mContext).inflate(R.layout.success_dialog,null);
        builder.setView(view);
        builder.setCancelable(false);
        dialog = builder.create();
        btnOk =  view.findViewById(R.id.buttonOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideDialog();
            }
        });
        dialog.show();

    }
    public void hideDialog(){
        dialog.dismiss();
    }
}
