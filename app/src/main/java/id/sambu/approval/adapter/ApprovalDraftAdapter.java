package id.sambu.approval.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

import id.sambu.approval.DetailDraft;
import id.sambu.approval.R;
import id.sambu.approval.models.ApprovalDraft;
import id.sambu.approval.utils.Loading;
import id.sambu.approval.utils.LoadingDialogBar;
import id.sambu.approval.utils.RejectDialog;
import id.sambu.approval.utils.SuccessDialog;

public class ApprovalDraftAdapter extends RecyclerView.Adapter<ApprovalDraftAdapter.ApprovalDraftViewHolder> {
    ArrayList<ApprovalDraft> dataList;
    private Context mContext;
    LoadingDialogBar loading;
    SuccessDialog approved;
    RejectDialog rejected;
    Loading tunggu;

    public ApprovalDraftAdapter(Context mContext,ArrayList<ApprovalDraft>dataList){
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ApprovalDraftAdapter.ApprovalDraftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_approval,parent,false);
        return new ApprovalDraftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ApprovalDraftViewHolder holder, int position) {
        Integer kategori = dataList.get(position).getKategori();
        if (kategori==1){
            holder.linear1.setBackgroundResource(R.drawable.bg_2);
            holder.jenisDraft.setText(dataList.get(position).getJenisDraft());
            holder.nama.setText(dataList.get(position).getNama());
            holder.alasan.setText(dataList.get(position).getAlasan());
            holder.deskripsiImage.setBackgroundResource(R.drawable.ic_medical_services);
            holder.infoImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent detailDraft = new Intent(mContext, DetailDraft.class);
                    detailDraft.putExtra("Kategori",dataList.get(position).getKategori());
                    detailDraft.putExtra("JenisDraft",dataList.get(position).getJenisDraft());
                    detailDraft.putExtra("Nama",dataList.get(position).getNama());
                    detailDraft.putExtra("Jabatan",dataList.get(position).getJabatan());
                    detailDraft.putExtra("Bagian",dataList.get(position).getBagian());
                    detailDraft.putExtra("TglIzin",dataList.get(position).getTglIzin());
                    detailDraft.putExtra("TglIzinSelesai",dataList.get(position).getTglSelesaiIzin());
                    detailDraft.putExtra("Alasan",dataList.get(position).getAlasan());
                    detailDraft.putExtra("PIC",dataList.get(position).getPIC());
                    mContext.startActivity(detailDraft);
                }
            });
        }else if (kategori==2){
            holder.jenisDraft.setText("Form Izin Cuti");
            holder.linear1.setBackgroundResource(R.drawable.bg_1);
            holder.nama.setText(dataList.get(position).getNama());
            holder.deskripsiImage.setImageResource(R.drawable.vacation);
            holder.alasan.setText(dataList.get(position).getAlasan());
            holder.infoImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detailDraft = new Intent(mContext, DetailDraft.class);
                    detailDraft.putExtra("Kategori",dataList.get(position).getKategori());
                    detailDraft.putExtra("JenisDraft",dataList.get(position).getJenisDraft());
                    detailDraft.putExtra("Nama",dataList.get(position).getNama());
                    detailDraft.putExtra("Jabatan",dataList.get(position).getJabatan());
                    detailDraft.putExtra("Bagian",dataList.get(position).getBagian());
                    detailDraft.putExtra("TglIzin",dataList.get(position).getTglIzin());
                    detailDraft.putExtra("TglIzinSelesai",dataList.get(position).getTglSelesaiIzin());
                    detailDraft.putExtra("Alasan",dataList.get(position).getAlasan());
                    detailDraft.putExtra("PIC",dataList.get(position).getPIC());
                    mContext.startActivity(detailDraft);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return (dataList != null)?dataList.size():0;
    }

    public class ApprovalDraftViewHolder extends RecyclerView.ViewHolder{
        private TextView jenisDraft,nama,jabatan,bagian,tglIzin,tglSelesaiIzin,alasan;
        private MaterialCardView layoutCard;
        private LinearLayout linear1;
        private ImageView infoImage,deskripsiImage;
        public ApprovalDraftViewHolder(View view){
            super(view);
            jenisDraft = view.findViewById(R.id.txtJenisDraft);
            nama = view.findViewById(R.id.txtNama);
            infoImage = view.findViewById(R.id.imgInfo);
            deskripsiImage = view.findViewById(R.id.deskripsiImg);
//            jabatan = view.findViewById(R.id.txtJabatan);
//            bagian = view.findViewById(R.id.txtBagian);
//            tglIzin = view.findViewById(R.id.txtTglMulai);
//            tglSelesaiIzin = view.findViewById(R.id.txtTglSelesai);
            alasan = view.findViewById(R.id.txtAlasan);
            layoutCard = view.findViewById(R.id.layoutCard);
            linear1 = view.findViewById(R.id.linear1);
        }
    }
}
