package com.example.month3lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
private Button openBtn;
private EditText editText;
private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openBtn = findViewById(R.id.open_btn);
        editText= findViewById(R.id.text_edit);
        imageView = findViewById(R.id.image1);
        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("text", editText.getText().toString());


                startActivity(intent);
            }
        });
//        не явный интент
Intent intent = new Intent(Intent.ACTION_PICK);
intent.setType("image/*");
startActivityForResult(intent,2);

//Intent intent1 = new Intent(Intent.ACTION_CALL);
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        if (resultCode == RESULT_OK){data.getData();}
        imageView.setImageURI(data.getData());
    }
}