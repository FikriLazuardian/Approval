package id.sambu.approval;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import id.sambu.approval.adapter.ApprovalDraftAdapter;
import id.sambu.approval.models.ApprovalDraft;

public class MenuApprovalDraft extends AppCompatActivity {
    RecyclerView recyclerApproval;
    ApprovalDraftAdapter adapter;
    ArrayList<ApprovalDraft>approvalList;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_approval_draft);
        recyclerApproval = findViewById(R.id.recylerApproval);
        toolbar = findViewById(R.id.toolbarApprovalDraft);
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
        approvalList = new ArrayList<ApprovalDraft>();
        approvalList.add(new ApprovalDraft(1,"Form Izin Sakit","Muhamad Fikri Lazuardian","Android Programmer","Dept.IT","19-08-2022","19-08-2022","Tes","Budiman"));
        approvalList.add(new ApprovalDraft(2,"Form izin Cuti","Muhamad Fikri Lazuardian","Android Programmer","Dept.IT","23-08-2022","25-08-2022","Perpanjang SIM Kendaraan","Budiman"));
        approvalList.add(new ApprovalDraft(1,"Form Izin Sakit","Ali Mustofa","IT Support","Dept.IT","22-08-2022","23-08-2022","Tes","Arif"));
        approvalList.add(new ApprovalDraft(2,"Form Izin Cuti","Ali Mustofa","IT Support","Dept.IT","25-08-2022","31-08-2022","Orang Tua Sakit Keras","Arif"));
        setDataInRecycler();
    }
    private void setDataInRecycler(){
        adapter = new ApprovalDraftAdapter(this,approvalList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MenuApprovalDraft.this);
        recyclerApproval.setHasFixedSize(true);
        recyclerApproval.setLayoutManager(layoutManager);
        recyclerApproval.setAdapter(adapter);
    }
}