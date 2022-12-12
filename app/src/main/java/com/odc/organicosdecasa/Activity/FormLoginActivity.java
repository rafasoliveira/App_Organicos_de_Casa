package com.odc.organicosdecasa.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.odc.organicosdecasa.R;

public class FormLoginActivity extends AppCompatActivity {
    private TextView text_telaCadastro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_form_login );

        IniciarComponentes();

        text_telaCadastro.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormLoginActivity.this, FormCadastroActivity.class));
            }
        } );
}

    private void IniciarComponentes(){
        text_telaCadastro = findViewById(R.id.text_telaCadastro2);
    }
}