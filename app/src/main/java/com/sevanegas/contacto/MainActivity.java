package com.sevanegas.contacto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayDate = (EditText) findViewById(R.id.tvFecha);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int año = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                  MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        año,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int año, int mes, int dia) {
                mes = mes + 1;
                Log.d(TAG,"onDateSet:mm/dd/yyyy: " + mes + "/" + dia + "/" + año);
                String date = mes + "/" + dia + "/" + año;
                mDisplayDate.setText(date);
            }
        };


        Button button = (Button)findViewById(R.id.button);
        final EditText editText = (EditText)findViewById(R.id.tvNombre);
        final EditText editText1 = (EditText)findViewById(R.id.tvFecha);
        final EditText editText2 = (EditText)findViewById(R.id.tvTelefono);
        final EditText editText3 = (EditText)findViewById(R.id.tvEmail);
        final EditText editText4 = (EditText)findViewById(R.id.tvDescripcion);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EditarContacto.class);
                intent.putExtra("nombre",editText.getText().toString());
                intent.putExtra("fecha",editText1.getText().toString());
                intent.putExtra("tel",editText2.getText().toString());
                intent.putExtra("email",editText3.getText().toString());
                intent.putExtra("descrip",editText4.getText().toString());

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}