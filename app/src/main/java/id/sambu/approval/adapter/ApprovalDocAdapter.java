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

import id.sambu.approval.DetailDoc;
import id.sambu.approval.R;
import id.sambu.approval.models.ApprovalDoc;
import id.sambu.approval.utils.Loading;
import id.sambu.approval.utils.LoadingDialogBar;
import id.sambu.approval.utils.RejectDialog;
import id.sambu.approval.utils.SuccessDialog;

public class ApprovalDocAdapter extends RecyclerView.Adapter<ApprovalDocAdapter.ApprovalDocViewHolder> {
    ArrayList<ApprovalDoc>dataList;
    Context mContext;
    LoadingDialogBar loading;
    SuccessDialog approved;
    RejectDialog rejected;
    Loading tunggu;

    public ApprovalDocAdapter(ArrayList<ApprovalDoc>dataList,Context mContext){
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ApprovalDocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_approval,parent,false);
        return new ApprovalDocViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ApprovalDocViewHolder holder, int position) {
        Integer kategori = dataList.get(position).getKategori();
        if (kategori==1){
            holder.linear2.setBackgroundResource(R.drawable.bg_2);
            holder.detailImg.setImageResource(R.drawable.ic_medical_services);
            holder.jenisDraft.setText(dataList.get(position).getJenisDraft());
            holder.nama.setText(dataList.get(position).getNama());
            holder.alasan.setText(dataList.get(position).getAlasan());
            holder.infoImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detailDoc = new Intent(mContext, DetailDoc.class);
                    detailDoc.putExtra("Kategori",dataList.get(position).getKategori());
                    detailDoc.putExtra("JenisDraft",dataList.get(position).getJenisDraft());
                    detailDoc.putExtra("Nama",dataList.get(position).getNama());
                    detailDoc.putExtra("Jabatan",dataList.get(position).getJabatan());
                    detailDoc.putExtra("Bagian",dataList.get(position).getBagian());
                    detailDoc.putExtra("TglIzin",dataList.get(position).getTglIzin());
                    detailDoc.putExtra("TglIzinSelesai",dataList.get(position).getTglSelesaiIzin());
                    detailDoc.putExtra("Alasan",dataList.get(position).getAlasan());
                    detailDoc.putExtra("PIC",dataList.get(position).getPIC());
                    detailDoc.putExtra("Status",dataList.get(position).getStatus());
                    mContext.startActivity(detailDoc);
                }
            });

        }else if (kategori == 2){
            holder.linear2.setBackgroundResource(R.drawable.bg_1);
            holder.jenisDraft.setText(dataList.get(position).getJenisDraft());
            holder.nama.setText(dataList.get(position).getNama());
            holder.detailImg.setImageResource(R.drawable.vacation);
            holder.alasan.setText(dataList.get(position).getAlasan());
            holder.infoImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detailDoc = new Intent(mContext, DetailDoc.class);
                    detailDoc.putExtra("Kategori",dataList.get(position).getKategori());
                    detailDoc.putExtra("JenisDraft",dataList.get(position).getJenisDraft());
                    detailDoc.putExtra("Nama",dataList.get(position).getNama());
                    detailDoc.putExtra("Jabatan",dataList.get(position).getJabatan());
                    detailDoc.putExtra("Bagian",dataList.get(position).getBagian());
                    detailDoc.putExtra("TglIzin",dataList.get(position).getTglIzin());
                    detailDoc.putExtra("TglIzinSelesai",dataList.get(position).getTglSelesaiIzin());
                    detailDoc.putExtra("PIC",dataList.get(position).getPIC());
                    detailDoc.putExtra("Alasan",dataList.get(position).getAlasan());
                    detailDoc.putExtra("Status",dataList.get(position).getStatus());
                    mContext.startActivity(detailDoc);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return (dataList != null)?dataList.size():0;
    }

    public class ApprovalDocViewHolder extends RecyclerView.ViewHolder{
        private TextView jenisDraft,nama,jabatan,bagian,tglIzin,tglSelesaiIzin,alasan;
        private MaterialCardView layoutCard;
        private LinearLayout linear2;
        private ImageView infoImage,detailImg;
        public ApprovalDocViewHolder(View view){
            super(view);
            jenisDraft = view.findViewById(R.id.txtJenisDraft);
            nama = view.findViewById(R.id.txtNama);
            infoImage = view.findViewById(R.id.imgInfo);
//            jabatan = view.findViewById(R.id.txtJabatan);
//            bagian = view.findViewById(R.id.txtBagian);
//            tglIzin = view.findViewById(R.id.txtTglMulai);
//            tglSelesaiIzin = view.findViewById(R.id.txtTglSelesai);
            alasan = view.findViewById(R.id.txtAlasan);
            layoutCard = view.findViewById(R.id.layoutCard);
            linear2 = view.findViewById(R.id.linear1);
            detailImg = view.findViewById(R.id.deskripsiImg);
        }
    }
}
