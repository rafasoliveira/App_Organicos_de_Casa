package com.odc.organicosdecasa.Activity;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.odc.organicosdecasa.R;

public class FormCadastroActivity extends AppCompatActivity {

    EditText editTextEmail, editTextSenha, editTextNome, editTextSobrenome, editTextDtAniversario, editTextCelular, editTextCEP,editTextEndereco, editTextNumEndereco,
            editTextComplemento, editTextCidade, editTextUF, editTextBairro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);
    }
}