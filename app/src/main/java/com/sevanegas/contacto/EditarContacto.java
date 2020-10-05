package com.sevanegas.contacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditarContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contacto);

        TextView textView = (TextView)findViewById(R.id.textNombre);
        TextView textView1 = (TextView)findViewById(R.id.textFecha);
        TextView textView2 = (TextView)findViewById(R.id.textTel);
        TextView textView3 = (TextView)findViewById(R.id.textEmail);
        TextView textView4 = (TextView)findViewById(R.id.textDescrip);

        Intent intent = getIntent();

        textView.setText(intent.getStringExtra("nombre"));
        textView1.setText(intent.getStringExtra("fecha"));
        textView2.setText(intent.getStringExtra("tel"));
        textView3.setText(intent.getStringExtra("email"));
        textView4.setText(intent.getStringExtra("descrip"));


        Button button1 = (Button)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
    }
}