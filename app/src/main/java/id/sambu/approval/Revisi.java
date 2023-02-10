package id.sambu.approval;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import id.sambu.approval.utils.LoadingDialogBar;
import id.sambu.approval.utils.RevisiDialog;

public class Revisi extends AppCompatActivity {
    TextView tvJenisDraft,tvNama,tvJabatan,tvBagian,tvTglIzin,tvTglSelesaiIzin,tvAlasan,tvPIC;
    Toolbar toolbar;
    MaterialButton btnSubmit;
    LoadingDialogBar loading;
    RevisiDialog revisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisi);
        tvJenisDraft = findViewById(R.id.tvJenisDraft);
        tvNama = findViewById(R.id.tvNama);
        tvJabatan = findViewById(R.id.tvJabatan);
        tvBagian = findViewById(R.id.tvBagian);
        tvTglIzin = findViewById(R.id.tvTglIzin);
        tvTglSelesaiIzin = findViewById(R.id.tvTglIzinSelesai);
        tvAlasan = findViewById(R.id.tvAlasan);
        tvPIC = findViewById(R.id.tvPic);
        btnSubmit = findViewById(R.id.btnSubmitRev);
        loading = new LoadingDialogBar(this);
        toolbar = findViewById(R.id.toolbarRevisiDraft);
        revisi = new RevisiDialog(this);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading.showDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.hideDialog();
                        revisi.showDialog();
                    }
                },1000);
            }
        });

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

            tvJenisDraft.setText(jenisDraft);
            tvNama.setText(nama);
            tvJabatan.setText(jabatan);
            tvBagian.setText(bagian);
            tvTglIzin.setText(tglIzin);
            tvTglSelesaiIzin.setText(tglSelesaiIzin);
            tvAlasan.setText(alasan);
            tvPIC.setVisibility(View.VISIBLE);
            tvPIC.setText(pic);
        }else if (kategori==2){
            tvJenisDraft.setText(jenisDraft);
            tvNama.setText(nama);
            tvJabatan.setText(jabatan);
            tvBagian.setText(bagian);
            tvTglIzin.setText(tglIzin);
            tvTglSelesaiIzin.setText(tglSelesaiIzin);
            tvAlasan.setText(alasan);
            tvPIC.setVisibility(View.VISIBLE);
            tvPIC.setText(pic);
        }
    }
}