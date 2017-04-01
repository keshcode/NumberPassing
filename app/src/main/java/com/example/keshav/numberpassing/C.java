package com.example.keshav.numberpassing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class C extends AppCompatActivity {
    static final int cId = 3;
    EditText etC;
    String sC;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        etC = (EditText) findViewById(R.id.etC);
        findViewById(R.id.btnC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run();
            }
        });

    }
    protected void run(){
        sC = etC.getText().toString();
        Intent intentPrev = getIntent();
        sC = intentPrev.getStringExtra("b") + sC;
        intent = new Intent(C.this,D.class);
        intent.putExtra("c",sC);
        startActivityForResult(intent,cId);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("debug", String.valueOf(requestCode));
        if(resultCode == 1){
            Log.d("debug","3");
            setResult(1,data);
            finish();
        }

    }
}
