package com.odc.organicosdecasa.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.odc.organicosdecasa.R;

public class FormLogin extends AppCompatActivity {


    private TextView text_TelaCadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        IniciarComponentes();

        text_TelaCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormLogin.this, FormCadastro.class);
                startActivity(intent);

            }
        });
    }

    private void IniciarComponentes(){
        text_TelaCadastro = findViewById(R.id.text_telaCadastro);
    }


}