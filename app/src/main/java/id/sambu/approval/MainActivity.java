package id.sambu.approval;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout menuDraft,menuApprovalDraft,menuRekapApproval,menuApprovalDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuDraft = findViewById(R.id.menuDraft);
        menuApprovalDraft = findViewById(R.id.menuApprovalDraft);
        menuRekapApproval = findViewById(R.id.menuRekapApproval);
        menuApprovalDoc = findViewById(R.id.menuApprovalDoc);

        menuDraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent draft = new Intent(MainActivity.this,MenuDraft.class);
//                startActivity(draft);
            }
        });

        menuApprovalDraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent approv = new Intent(MainActivity.this, MenuApprovalDraft.class);
                startActivity(approv);
            }
        });

        menuRekapApproval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rekap = new Intent(MainActivity.this,RekapApproval.class);
                startActivity(rekap);
            }
        });

        menuApprovalDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent approvDoc = new Intent(MainActivity.this,MenuApprovalDoc.class);
                startActivity(approvDoc);
            }
        });
    }
}