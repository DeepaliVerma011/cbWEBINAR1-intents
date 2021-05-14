package com.example.searchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et;
ImageButton ib;

private static final String TAG="could not open";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et= findViewById(R.id.editText);
        ib = findViewById(R.id.imageButton);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= et.getText().toString();
                Uri uri=Uri.parse(url);
                Intent i = new Intent(Intent.ACTION_VIEW,uri);
                try {
                    startActivity(i);
                }
                catch (ActivityNotFoundException anfe){
                    Log.e(TAG,"could not open",anfe);

                    Toast.makeText(MainActivity.this,"could not open",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}