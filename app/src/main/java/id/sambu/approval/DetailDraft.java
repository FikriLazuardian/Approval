package id.sambu.approval;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import id.sambu.approval.utils.Loading;
import id.sambu.approval.utils.LoadingDialogBar;
import id.sambu.approval.utils.RejectDialog;
import id.sambu.approval.utils.SuccessDialog;

public class DetailDraft extends AppCompatActivity {
    TextView tvJenisDraft,tvNama,tvJabatan,tvBagian,tvTglIzin,tvTglSelesaiIzin,headerAlasan,tvAlasan,tvPIC;
    RelativeLayout layout;
    Toolbar toolbar;
    private MaterialButton approval,reject,request;
    LoadingDialogBar loading;
    SuccessDialog approved;
    RejectDialog rejected;
    Loading tunggu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_draft);
        toolbar = findViewById(R.id.toolbarDetailDraft);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvJenisDraft = findViewById(R.id.jenisDraft);
        tvNama=findViewById(R.id.nama);
        tvJabatan = findViewById(R.id.jabatan);
        tvBagian = findViewById(R.id.bagian);
        tvTglIzin = findViewById(R.id.tglIzin);
        tvTglSelesaiIzin = findViewById(R.id.tglSelesaiIzin);
        headerAlasan = findViewById(R.id.headerAlasan);
        tvAlasan = findViewById(R.id.alasan);
        tvPIC = findViewById(R.id.pic);
        layout = findViewById(R.id.relative);
        approval = findViewById(R.id.approv);
        reject = findViewById(R.id.reject);
        request = findViewById(R.id.request);
        loading = new LoadingDialogBar(this);
        approved = new SuccessDialog(this);
        rejected = new RejectDialog(this);
        tunggu = new Loading(this);

        Intent intent = getIntent();
        Integer kategori = intent.getIntExtra("Kategori",0);
        String jenisDraft = intent.getStringExtra("JenisDraft");
        String nama = intent.getStringExtra("Nama");
        String jabatan = intent.getStringExtra("Jabatan");
        String bagian = intent.getStringExtra("Bagian");
        String tglIzin = intent.getStringExtra("TglIzin");
        String tglSelesaiIzin = intent.getStringExtra("TglIzinSelesai");
        String alasan = intent.getStringExtra("Alasan");
        String pic = intent.getStringExtra("PIC");
        if (kategori==1){
            layout.setBackgroundResource(R.drawable.bg_2);
            tvJenisDraft.setText(jenisDraft);
            tvNama.setText(nama);
            tvJabatan.setText(jabatan);
            tvBagian.setText(bagian);
            tvTglIzin.setText(tglIzin);
            tvTglSelesaiIzin.setText(tglSelesaiIzin);
            tvAlasan.setText(alasan);
            tvPIC.setText(pic);
        }else if (kategori==2){
            layout.setBackgroundResource(R.drawable.bg_1);
            tvJenisDraft.setText(jenisDraft);
            tvNama.setText(nama);
            tvJabatan.setText(jabatan);
            tvBagian.setText(bagian);
            tvTglIzin.setText(tglIzin);
            tvTglSelesaiIzin.setText(tglSelesaiIzin);
            tvAlasan.setText(alasan);
            tvPIC.setText(pic);
        }

        approval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loading.showDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.hideDialog();
                        approved.showDialog();
                    }
                },1000);
            }
        });

        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(DetailDraft.this);
                alertDialog.setMessage("Apakah anda yakin untuk menolak draft ini ?");
                alertDialog.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                alertDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tunggu.showDialog();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tunggu.hideDialog();
                                rejected.showDialog();
                            }
                        },1000);
                    }
                });
                AlertDialog alertDialog1 = alertDialog.create();
                alertDialog1.show();
            }
        });

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent revisi = new Intent(DetailDraft.this, Revisi.class);
                revisi.putExtra("Kategori",kategori);
                revisi.putExtra("JenisDraft",jenisDraft);
                revisi.putExtra("Nama",nama);
                revisi.putExtra("Jabatan",jabatan);
                revisi.putExtra("Bagian",bagian);
                revisi.putExtra("TglIzin",tglIzin);
                revisi.putExtra("TglIzinSelesai",tglSelesaiIzin);
                revisi.putExtra("Alasan",alasan);
                startActivity(revisi);
            }
        });
    }
}