package id.sambu.approval;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class DetailRekap extends AppCompatActivity {
    Toolbar toolbar;
    private MaterialButton editRevisi;
    TextView rekapJenisDraft,rekapNama,rekapJabatan,rekapBagian,rekapTglIzin,rekapTglSelesai,rekapAlasan,rekapPemeriksa,rekapStatus,perbaikan,rekapPerbaikan;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rekap);
        editRevisi = findViewById(R.id.editRevisi);
        rekapJenisDraft = findViewById(R.id.jenisDraft);
        rekapNama = findViewById(R.id.nama);
        rekapJabatan = findViewById(R.id.jabatan);
        rekapBagian = findViewById(R.id.bagian);
        rekapTglIzin = findViewById(R.id.tglIzin);
        rekapTglSelesai = findViewById(R.id.tglSelesaiIzin);
        rekapAlasan = findViewById(R.id.alasan);
        rekapPemeriksa = findViewById(R.id.pemeriksa);
        rekapStatus = findViewById(R.id.status);
        perbaikan = findViewById(R.id.perbaikan);
        rekapPerbaikan = findViewById(R.id.tvPerbaikan);
        layout = findViewById(R.id.layout);
        toolbar = findViewById(R.id.toolbarDetailRekap);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        perbaikan.setVisibility(View.GONE);
        rekapPerbaikan.setVisibility(View.GONE);
        editRevisi.setVisibility(View.GONE);
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

        if (kategori==1){
           if (status==1){
               rekapJenisDraft.setText(jenisDraft);
               rekapNama.setText(nama);
               rekapJabatan.setText(jabatan);
               rekapBagian.setText(bagian);
               rekapTglIzin.setText(tglIzin);
               rekapTglSelesai.setText(tglSelesaiIzin);
               rekapAlasan.setText(alasan);
               rekapPemeriksa.setText(pemeriksa);
               rekapStatus.setText("Disetujui");
               layout.setBackgroundResource(R.color.approve);
           }else if (status==2){
               rekapJenisDraft.setText(jenisDraft);
               rekapNama.setText(nama);
               rekapJabatan.setText(jabatan);
               rekapBagian.setText(bagian);
               rekapTglIzin.setText(tglIzin);
               rekapTglSelesai.setText(tglSelesaiIzin);
               rekapAlasan.setText(alasan);
               rekapPemeriksa.setText(pemeriksa);
               rekapStatus.setText("Ditolak");
               layout.setBackgroundResource(R.color.reject);
           }else{
               rekapJenisDraft.setText(jenisDraft);
               rekapNama.setText(nama);
               rekapJabatan.setText(jabatan);
               rekapBagian.setText(bagian);
               rekapTglIzin.setText(tglIzin);
               rekapTglSelesai.setText(tglSelesaiIzin);
               rekapAlasan.setText(alasan);
               rekapPemeriksa.setText(pemeriksa);
               rekapStatus.setText("Direvisi");
               layout.setBackgroundResource(R.color.revisi);
               perbaikan.setVisibility(View.VISIBLE);
               rekapPerbaikan.setVisibility(View.VISIBLE);
               editRevisi.setVisibility(View.VISIBLE);
               editRevisi.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent edit = new Intent(DetailRekap.this, EditRevisi.class);
                       edit.putExtra("Kategori",kategori);
                       edit.putExtra("JenisDraft",jenisDraft);
                       edit.putExtra("Nama",nama);
                       edit.putExtra("Jabatan",jabatan);
                       edit.putExtra("Bagian",bagian);
                       edit.putExtra("TglIzin",tglIzin);
                       edit.putExtra("TglIzinSelesai",tglSelesaiIzin);
                       edit.putExtra("Alasan",alasan);
                       edit.putExtra("PIC",pemeriksa);
                       edit.putExtra("Status",status);
                       startActivity(edit);
                   }
               });
           }
        }else{
            if (status==1){
                rekapJenisDraft.setText(jenisDraft);
                rekapNama.setText(nama);
                rekapJabatan.setText(jabatan);
                rekapBagian.setText(bagian);
                rekapTglIzin.setText(tglIzin);
                rekapTglSelesai.setText(tglSelesaiIzin);
                rekapAlasan.setText(alasan);
                rekapPemeriksa.setText(pemeriksa);
                rekapStatus.setText("Disetujui");
                layout.setBackgroundResource(R.color.approve);
            }else if (status==2){
                rekapJenisDraft.setText(jenisDraft);
                rekapNama.setText(nama);
                rekapJabatan.setText(jabatan);
                rekapBagian.setText(bagian);
                rekapTglIzin.setText(tglIzin);
                rekapTglSelesai.setText(tglSelesaiIzin);
                rekapAlasan.setText(alasan);
                rekapPemeriksa.setText(pemeriksa);
                rekapStatus.setText("Ditolak");
                layout.setBackgroundResource(R.color.reject);
            }else{
                rekapJenisDraft.setText(jenisDraft);
                rekapNama.setText(nama);
                rekapJabatan.setText(jabatan);
                rekapBagian.setText(bagian);
                rekapTglIzin.setText(tglIzin);
                rekapTglSelesai.setText(tglSelesaiIzin);
                rekapAlasan.setText(alasan);
                rekapPemeriksa.setText(pemeriksa);
                rekapStatus.setText("Direvisi");
                perbaikan.setVisibility(View.VISIBLE);
                rekapPerbaikan.setVisibility(View.VISIBLE);
                rekapPerbaikan.setText("Sudah pernah mengajukan di tanggal tersebut");
                layout.setBackgroundResource(R.color.revisi);
                editRevisi.setVisibility(View.VISIBLE);
                editRevisi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent edit = new Intent(DetailRekap.this, EditRevisi.class);
                        edit.putExtra("Kategori",kategori);
                        edit.putExtra("JenisDraft",jenisDraft);
                        edit.putExtra("Nama",nama);
                        edit.putExtra("Jabatan",jabatan);
                        edit.putExtra("Bagian",bagian);
                        edit.putExtra("TglIzin",tglIzin);
                        edit.putExtra("TglIzinSelesai",tglSelesaiIzin);
                        edit.putExtra("Alasan",alasan);
                        edit.putExtra("PIC",pemeriksa);
                        edit.putExtra("Status",status);
                        startActivity(edit);
                    }
                });
            }
        }
    }
}