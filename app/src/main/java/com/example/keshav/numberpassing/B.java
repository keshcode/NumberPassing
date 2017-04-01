package com.example.keshav.numberpassing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class B extends AppCompatActivity {
    static final int bId = 2;
    EditText etB;
    String sB;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        etB = (EditText) findViewById(R.id.etB);
        findViewById(R.id.btnB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run();
            }
        });

    }
    protected void run(){
        sB = etB.getText().toString();
        Intent intentPrev = getIntent();
        sB = intentPrev.getStringExtra("a") + sB;
        intent = new Intent(B.this,C.class);
        intent.putExtra("b",sB);
        startActivityForResult(intent,bId);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            Log.d("debug","2");
            setResult(1,data);
            finish();
        }

    }
}
