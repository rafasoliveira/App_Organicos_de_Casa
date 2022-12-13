package com.odc.organicosdecasa.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.odc.organicosdecasa.DAO.DAO;
import com.odc.organicosdecasa.Domain.Cliente;
import com.odc.organicosdecasa.R;

public class FormCadastroActivity extends AppCompatActivity {

    EditText editTextEmail, editTextSenha, editTextNome, editTextSobrenome, editTextAniversario, editTextCelular, editTextCEP,editTextEndereco, editTextNumEndereco,
            editTextComplemento, editTextCidade, editTextUF, editTextBairro;
    Button buttonPF, buttonPJ, buttonCadastrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);
        editTextNome = findViewById(R.id.editTextNome);
        editTextSobrenome= findViewById(R.id.editTextSobrenome);
        editTextAniversario = findViewById(R.id.editTextAniversario);
        editTextCelular = findViewById(R.id.editTextCelular);
        editTextCEP = findViewById(R.id.editTextCEP);
        editTextEndereco = findViewById(R.id.editTextEndereco);
        editTextNumEndereco = findViewById(R.id.editTextNumEndereco);
        editTextComplemento = findViewById(R.id.editTextComplemento);
        editTextCidade = findViewById(R.id.editTextCidade);
        editTextUF = findViewById(R.id.editTextUF);
        editTextBairro = findViewById(R.id.editTextBairro);
        buttonPF = findViewById(R.id.buttonPF);
        buttonPJ = findViewById(R.id.buttonPJ);
        buttonCadastrar = findViewById(R.id.buttonCadastrar);


        buttonCadastrar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 if(!(editTextEmail.getText().toString().equals("") || editTextSenha.getText().toString().equals(""))){

                     DAO dao = new DAO( getApplicationContext());
                     Cliente cliente = new Cliente();
                     cliente.setEmail(editTextEmail.getText().toString());
                     cliente.setSenha(editTextSenha.getText().toString());
                     cliente.setNome(editTextNome.getText().toString());
                     cliente.setSobrenome(editTextSobrenome.getText().toString());
                     cliente.setAniversario(editTextAniversario.getText().toString());
                     cliente.setCelular(editTextCelular.getText().toString());
                     cliente.setCep(editTextCEP.getText().toString());
                     cliente.setEndereco(editTextEndereco.getText().toString());
                     cliente.setNumEndereco( editTextNumEndereco.getText().toString());
                     cliente.setComplemento(editTextComplemento.getText().toString());
                     cliente.setCidade(editTextCidade.getText().toString());
                     cliente.setUf(editTextUF.getText().toString());
                     cliente.setBairro(editTextBairro.getText().toString());
                     dao.inserirCliente(cliente);
                     dao.close();
                     limparFormulario();

                     Toast.makeText(getApplicationContext(),"Usuário cadastrado.",Toast.LENGTH_SHORT).show();



                 } else {
                     Toast.makeText(getApplicationContext(),"Preencher os campos de email e senha.",Toast.LENGTH_SHORT).show();
                 }
            }
        });

    }

    private void limparFormulario() {
        editTextEmail.setText("");
        editTextEmail.requestFocus();
        editTextSenha.setText("");
        editTextNome.setText("");
        editTextSobrenome.setText("");
        editTextAniversario.setText("");
        editTextCelular.setText("");
        editTextCEP.setText("");
        editTextEndereco.setText("");
        editTextNumEndereco.setText("");
        editTextComplemento.setText("");
        editTextCidade.setText("");
        editTextUF.setText("");
        editTextBairro.setText("");
    }
}


