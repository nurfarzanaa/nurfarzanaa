package com.farzana.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnGo, btnSubmit;

    EditText etURL, etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo =  findViewById(R.id.btnGo);
        etURL = findViewById(R.id.etURL);
        btnSubmit = findViewById(R.id.btnSubmit);
        etName = findViewById(R.id.etName);


        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = etURL.getText().toString().trim();

                if (!url.isEmpty()){
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(i);
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();

                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(i);

                i.putExtra("key_name", name);

                startActivity(i);

            }
        });

    }
}