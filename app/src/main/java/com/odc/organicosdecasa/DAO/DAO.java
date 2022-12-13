package com.odc.organicosdecasa.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.odc.organicosdecasa.Domain.Cliente;

import java.util.ArrayList;
import java.util.List;

public class DAO extends SQLiteOpenHelper {
    public DAO(Context context){
        super(context,"dbODC", null,2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE cliente (id Integer, email String, senha String, nome String, sobrenome String, aniversario String, celular String,cep String, endereco String, numEndereco String, complemento String, cidade String, uf String, bairro String);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS cliente;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserirCliente (Cliente cliente) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();

        dados.put( "id", cliente.getId());
        dados.put( "email", cliente.getEmail());
        dados.put( "senha", cliente.getSenha());
        dados.put( "nome", cliente.getNome());
        dados.put( "sobrenome", cliente.getSobrenome());
        dados.put( "aniversario", cliente.getAniversario());
        dados.put( "celular", cliente.getCelular());
        dados.put( "cep", cliente.getCep());
        dados.put( "endereco", cliente.getEndereco());
        dados.put( "numEndereco", cliente.getNumEndereco());
        dados.put( "complemento", cliente.getComplemento());
        dados.put( "cidade", cliente.getCidade());
        dados.put( "uf", cliente.getUf());
        dados.put( "bairro", cliente.getBairro());

        db.insert("cliente", null, dados);
    }

    @SuppressLint("Range")
    public List<Cliente> buscarCliente(){

        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM cliente;";

        Cursor cursor = db.rawQuery(sql, null);

        List<Cliente> clientes = new ArrayList<Cliente>();

        while (cursor.moveToNext()) {

            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(cursor.getString(cursor.getColumnIndex("id"))));
            cliente.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            cliente.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
            cliente.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            cliente.setSobrenome(cursor.getString(cursor.getColumnIndex("sobrenome")));
            cliente.setAniversario(cursor.getString(cursor.getColumnIndex("aniversario")));
            cliente.setCelular(cursor.getString(cursor.getColumnIndex("celular")));
            cliente.setCep(cursor.getString(cursor.getColumnIndex("cep")));
            cliente.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            cliente.setNumEndereco(cursor.getString(cursor.getColumnIndex("numEndereco")));
            cliente.setComplemento(cursor.getString(cursor.getColumnIndex("complemento")));
            cliente.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
            cliente.setUf(cursor.getString(cursor.getColumnIndex("uf")));
            cliente.setBairro(cursor.getString(cursor.getColumnIndex("bairro")));
            clientes.add(cliente);
        }
        return clientes;
    }
}