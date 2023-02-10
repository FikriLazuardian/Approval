package id.sambu.approval;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import id.sambu.approval.adapter.ApprovalDocAdapter;
import id.sambu.approval.models.ApprovalDoc;

public class MenuApprovalDoc extends AppCompatActivity {
    RecyclerView recyclerApprovalDoc;
    ApprovalDocAdapter adapter;
    ArrayList<ApprovalDoc> approvalDocList;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_approval_doc);
        recyclerApprovalDoc = findViewById(R.id.recylerApprovalDoc);
        toolbar = findViewById(R.id.toolbarApprovalDoc);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        addData();
    }
    private void addData() {
        approvalDocList = new ArrayList<ApprovalDoc>();
        approvalDocList.add(new ApprovalDoc(1,"Form Izin Sakit","Muhamad Fikri Lazuardian","Android Programmer","Dept.IT","19-08-2022","19-08-2022","Tes","Budiman",1));
        approvalDocList.add(new ApprovalDoc(2,"Form izin Cuti","Muhamad Fikri Lazuardian","Android Programmer","Dept.IT","23-08-2022","25-08-2022","Perpanjang SIM Kendaraan","Budiman",2));
        approvalDocList.add(new ApprovalDoc(1,"Form Izin Sakit","Ali Mustofa","IT Support","Dept.IT","22-08-2022","23-08-2022","Tes","Arif",3));
        approvalDocList.add(new ApprovalDoc(2,"Form Izin Cuti","Ali Mustofa","IT Support","Dept.IT","25-08-2022","31-08-2022","Orang Tua Sakit Keras","Arif",2));
        setDataInRecycler();
    }

    private void setDataInRecycler(){
        adapter = new ApprovalDocAdapter(approvalDocList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MenuApprovalDoc.this);
        recyclerApprovalDoc.setHasFixedSize(true);
        recyclerApprovalDoc.setLayoutManager(layoutManager);
        recyclerApprovalDoc.setAdapter(adapter);
    }
}