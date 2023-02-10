package id.sambu.approval;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import id.sambu.approval.utils.EditRevisiDialog;
import id.sambu.approval.utils.LoadingDialogBar;
import id.sambu.approval.utils.RevisiDialog;

public class EditRevisi extends AppCompatActivity {
    Toolbar toolbar;
    TextInputEditText tiNama,tiJabatan,tiBagian,tiTglIzin,tiTglSelesaiIzin,tiDeskripsi,tiPemeriksa,tiJenis;
    MaterialButton submitRevisi;
    LoadingDialogBar loading;
    EditRevisiDialog revisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_revisi);

        toolbar = findViewById(R.id.toolbarEditRevisi);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        loading = new LoadingDialogBar(this);
        revisi = new EditRevisiDialog(this);
        tiNama = findViewById(R.id.etNama);
        tiJabatan = findViewById(R.id.etJabatan);
        tiBagian = findViewById(R.id.etBagian);
        tiTglIzin = findViewById(R.id.etTglPengajuan);
        tiTglSelesaiIzin = findViewById(R.id.etTglSelesai);
        tiDeskripsi = findViewById(R.id.etDeskripsi);
        tiPemeriksa = findViewById(R.id.etPIC);
        tiJenis = findViewById(R.id.etJenis);
        submitRevisi = findViewById(R.id.submitRevisi);

        Intent intent = getIntent();
        Integer kategori = intent.getIntExtra("Kategori",0);
        String jenisDraft = intent.getStringExtra("JenisDraft");
        String nama = intent.getStringExtra("Nama");
        String jabatan = intent.getStringExtra("Jabatan");
        String bagian = intent.getStringExtra("Bagian");
        String tglIzin = intent.getStringExtra("TglIzin");
        String tglSelesaiIzin = intent.getStringExtra("TglIzinSelesai");
        String alasan = intent.getStringExtra("Alasan");
        String pemeriksa = intent.getStringExtra("PIC");
        Integer status = intent.getIntExtra("Status",0);

        tiJenis.setText(jenisDraft);
        tiNama.setText(nama);
        tiJabatan.setText(jabatan);
        tiBagian.setText(bagian);
        tiTglIzin.setText(tglIzin);
        tiTglSelesaiIzin.setText(tglSelesaiIzin);
        tiDeskripsi.setText(alasan);
        tiPemeriksa.setText(pemeriksa);

        submitRevisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    }
}