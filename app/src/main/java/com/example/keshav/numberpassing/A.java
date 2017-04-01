package com.example.keshav.numberpassing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class A extends AppCompatActivity {
    static final int aId = 1;
    EditText etA;
    String sA;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        etA = (EditText) findViewById(R.id.etA);
        findViewById(R.id.btnA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run();
            }
        });

    }

    protected void run() {
        sA = etA.getText().toString();
        intent = new Intent(A.this, B.class);
        intent.putExtra("a", sA);
        startActivityForResult(intent, aId);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            TextView tvans = (TextView) findViewById(R.id.ans);
            tvans.setText(data.getStringExtra("c"));
            Log.d("debug","1");
        }

    }
}
