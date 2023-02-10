package id.sambu.approval.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sambu.approval.R;
import id.sambu.approval.RekapApproval;
import id.sambu.approval.adapter.RekapApprovalAdapter;
import id.sambu.approval.models.RekapApprovals;

public class RekapDraftApproval extends Fragment {
    RecyclerView daftarDraftApproval;
    RekapApprovalAdapter adapter;
    ArrayList<RekapApprovals> rekapApprovalList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_rekap_draft_approval,container,false);
        daftarDraftApproval = myView.findViewById(R.id.rekapDraft);
        addData();
        return myView;
    }
    private void addData(){
        rekapApprovalList = new ArrayList<RekapApprovals>();
        rekapApprovalList.add(new RekapApprovals(1,"Form Izin Sakit","Muhamad Fikri Lazuardian",1,"Android Programmer","Dept.IT","19-08-2022","22-08-2022","Sakit Hati","Budiman"));
        rekapApprovalList.add(new RekapApprovals(2,"Form Izin Cuti","Muhamad Fikri Lazuardian",2,"Android Programmer","Dept.IT","24-08-2022","30-08-2022","Healing","Budiman"));
        rekapApprovalList.add(new RekapApprovals(2,"Form Izin Cuti","Ali Mustofa",1,"IT Support","Dept.IT","24-08-2022","30-08-2022","Healing","Arif"));
        rekapApprovalList.add(new RekapApprovals(1,"Form Izin Sakit","Ali Mustofa",2,"IT Support","Dept.IT","31-08-2022","31-08-2022","Demam","Arif"));
        rekapApprovalList.add(new RekapApprovals(2,"Form Izin Cuti","Muhamad Fikri Lazuardian",3,"Android Programmer","Dept.IT","24-08-2022","30-08-2022","Healing","Budiman"));

        setDataInRecycler();
    }

    private void setDataInRecycler(){
        adapter = new RekapApprovalAdapter(rekapApprovalList,getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        daftarDraftApproval.setHasFixedSize(true);
        daftarDraftApproval.setLayoutManager(layoutManager);
        daftarDraftApproval.setAdapter(adapter);
    }
}