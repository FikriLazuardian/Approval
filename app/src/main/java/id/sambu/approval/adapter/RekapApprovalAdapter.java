package id.sambu.approval.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.sambu.approval.DetailRekap;
import id.sambu.approval.R;
import id.sambu.approval.models.RekapApprovals;

public class RekapApprovalAdapter extends RecyclerView.Adapter<RekapApprovalAdapter.RekapApprovalViewHolder> {
    ArrayList<RekapApprovals> dataList;
    Context mContext;

    public RekapApprovalAdapter(ArrayList<RekapApprovals>dataList,Context context){
        this.dataList = dataList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RekapApprovalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_rekap_approval,parent,false);
        return new RekapApprovalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RekapApprovalViewHolder holder, int position) {
        Integer kategori = dataList.get(position).getKategori();
        if (kategori==1){
            holder.jenisDraft.setText(dataList.get(position).getJenisDraft());
            holder.nama.setText(dataList.get(position).getNama());
            holder.tglIzin.setText(dataList.get(position).getTglIzin());
            holder.bagian.setText(dataList.get(position).getBagian());
            holder.pic.setText(dataList.get(position).getPIC());

            Integer status = dataList.get(position).getStatus();
            if (status==1){
                holder.status.setBackgroundResource(R.drawable.approve);
                holder.card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent detailRekap = new Intent(mContext, DetailRekap.class);
                        detailRekap.putExtra("Kategori",dataList.get(position).getKategori());
                        detailRekap.putExtra("JenisDraft",dataList.get(position).getJenisDraft());
                        detailRekap.putExtra("Nama",dataList.get(position).getNama());
                        detailRekap.putExtra("Jabatan",dataList.get(position).getJabatan());
                        detailRekap.putExtra("Bagian",dataList.get(position).getBagian());
                        detailRekap.putExtra("TglIzin",dataList.get(position).getTglIzin());
                        detailRekap.putExtra("TglIzinSelesai",dataList.get(position).getTglSelesaiIzin());
                        detailRekap.putExtra("Alasan",dataList.get(position).getAlasan());
                        detailRekap.putExtra("PIC",dataList.get(position).getPIC());
                        detailRekap.putExtra("Status",dataList.get(position).getStatus());
                        mContext.startActivity(detailRekap);
                    }
                });
            }else if (status==2){
                holder.status.setBackgroundResource(R.drawable.reject);
                holder.card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent detailRekap = new Intent(mContext,DetailRekap.class);
                        detailRekap.putExtra("Kategori",dataList.get(position).getKategori());
                        detailRekap.putExtra("JenisDraft",dataList.get(position).getJenisDraft());
                        detailRekap.putExtra("Nama",dataList.get(position).getNama());
                        detailRekap.putExtra("Jabatan",dataList.get(position).getJabatan());
                        detailRekap.putExtra("Bagian",dataList.get(position).getBagian());
                        detailRekap.putExtra("TglIzin",dataList.get(position).getTglIzin());
                        detailRekap.putExtra("TglIzinSelesai",dataList.get(position).getTglSelesaiIzin());
                        detailRekap.putExtra("Alasan",dataList.get(position).getAlasan());
                        detailRekap.putExtra("PIC",dataList.get(position).getPIC());
                        detailRekap.putExtra("Status",dataList.get(position).getStatus());
                        mContext.startActivity(detailRekap);
                    }
                });
            }else{
                holder.status.setBackgroundResource(R.drawable.revisi);
                holder.card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent detailRekap = new Intent(mContext,DetailRekap.class);
                        detailRekap.putExtra("Kategori",dataList.get(position).getKategori());
                        detailRekap.putExtra("JenisDraft",dataList.get(position).getJenisDraft());
                        detailRekap.putExtra("Nama",dataList.get(position).getNama());
                        detailRekap.putExtra("Jabatan",dataList.get(position).getJabatan());
                        detailRekap.putExtra("Bagian",dataList.get(position).getBagian());
                        detailRekap.putExtra("TglIzin",dataList.get(position).getTglIzin());
                        detailRekap.putExtra("TglIzinSelesai",dataList.get(position).getTglSelesaiIzin());
                        detailRekap.putExtra("Alasan",dataList.get(position).getAlasan());
                        detailRekap.putExtra("PIC",dataList.get(position).getPIC());
                        detailRekap.putExtra("Status",dataList.get(position).getStatus());
                        mContext.startActivity(detailRekap);
                    }
                });
            }
        }else if (kategori==2){
            holder.jenisDraft.setText(dataList.get(position).getJenisDraft());
            holder.nama.setText(dataList.get(position).getNama());
            holder.tglIzin.setText(dataList.get(position).getTglIzin());
            holder.bagian.setText(dataList.get(position).getBagian());
            holder.pic.setText(dataList.get(position).getPIC());
            Integer status = dataList.get(position).getStatus();
            if (status==1){
                holder.status.setBackgroundResource(R.drawable.approve);
                holder.card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent detailRekap = new Intent(mContext,DetailRekap.class);
                        detailRekap.putExtra("Kategori",dataList.get(position).getKategori());
                        detailRekap.putExtra("JenisDraft",dataList.get(position).getJenisDraft());
                        detailRekap.putExtra("Nama",dataList.get(position).getNama());
                        detailRekap.putExtra("Jabatan",dataList.get(position).getJabatan());
                        detailRekap.putExtra("Bagian",dataList.get(position).getBagian());
                        detailRekap.putExtra("TglIzin",dataList.get(position).getTglIzin());
                        detailRekap.putExtra("TglIzinSelesai",dataList.get(position).getTglSelesaiIzin());
                        detailRekap.putExtra("Alasan",dataList.get(position).getAlasan());
                        detailRekap.putExtra("PIC",dataList.get(position).getPIC());
                        detailRekap.putExtra("Status",dataList.get(position).getStatus());
                        mContext.startActivity(detailRekap);
                    }
                });
            }else if (status==2){
                holder.status.setBackgroundResource(R.drawable.reject);
                holder.card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent detailRekap = new Intent(mContext,DetailRekap.class);
                        detailRekap.putExtra("Kategori",dataList.get(position).getKategori());
                        detailRekap.putExtra("JenisDraft",dataList.get(position).getJenisDraft());
                        detailRekap.putExtra("Nama",dataList.get(position).getNama());
                        detailRekap.putExtra("Jabatan",dataList.get(position).getJabatan());
                        detailRekap.putExtra("Bagian",dataList.get(position).getBagian());
                        detailRekap.putExtra("TglIzin",dataList.get(position).getTglIzin());
                        detailRekap.putExtra("TglIzinSelesai",dataList.get(position).getTglSelesaiIzin());
                        detailRekap.putExtra("Alasan",dataList.get(position).getAlasan());
                        detailRekap.putExtra("PIC",dataList.get(position).getPIC());
                        detailRekap.putExtra("Status",dataList.get(position).getStatus());
                        mContext.startActivity(detailRekap);
                    }
                });
            }else{
                holder.status.setBackgroundResource(R.drawable.revisi);
                holder.card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent detailRekap = new Intent(mContext,DetailRekap.class);
                        detailRekap.putExtra("Kategori",dataList.get(position).getKategori());
                        detailRekap.putExtra("JenisDraft",dataList.get(position).getJenisDraft());
                        detailRekap.putExtra("Nama",dataList.get(position).getNama());
                        detailRekap.putExtra("Jabatan",dataList.get(position).getJabatan());
                        detailRekap.putExtra("Bagian",dataList.get(position).getBagian());
                        detailRekap.putExtra("TglIzin",dataList.get(position).getTglIzin());
                        detailRekap.putExtra("TglIzinSelesai",dataList.get(position).getTglSelesaiIzin());
                        detailRekap.putExtra("Alasan",dataList.get(position).getAlasan());
                        detailRekap.putExtra("PIC",dataList.get(position).getPIC());
                        detailRekap.putExtra("Status",dataList.get(position).getStatus());
                        mContext.startActivity(detailRekap);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return (dataList != null)?dataList.size():0;
    }

    public class RekapApprovalViewHolder extends RecyclerView.ViewHolder{
        private TextView jenisDraft,nama,tglIzin,tglSelesaiIzin,jabatan,bagian,deskripsi,pic,txtStatus;
        private ImageView status;
        private CardView card;
        private LinearLayout linear;
        public RekapApprovalViewHolder(View view){
            super(view);
            jenisDraft = view.findViewById(R.id.txtJenisDraft);
            nama = view.findViewById(R.id.txtNama);
            tglIzin = view.findViewById(R.id.txtTglIzin);
            status = view.findViewById(R.id.ivStatus);
            bagian = view.findViewById(R.id.txtBagian);
            pic = view.findViewById(R.id.txtPIC);
            card = view.findViewById(R.id.layoutCard);
            linear = view.findViewById(R.id.linearRekap);
        }
    }
}
