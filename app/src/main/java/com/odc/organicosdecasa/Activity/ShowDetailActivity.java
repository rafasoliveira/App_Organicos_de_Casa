package com.odc.organicosdecasa.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.odc.organicosdecasa.Domain.ItemDomain;
import com.odc.organicosdecasa.Helper.ManagementCart;
import com.odc.organicosdecasa.R;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCarBtn;
    private TextView tituloTxt, taxaTxt, descricaoTxt, numOrdemTxt, precoTotalTxt, estrelaTxt, favoritoTxt, listaCompraTxt;
    private ImageView plusBtn, minusBtn, picItem;
    private ItemDomain object;
    private int numOrdem = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        managementCart = new ManagementCart(this);

        initView();
        getBundle();
    }

    private void getBundle() {
        object = (ItemDomain)getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picItem);

        tituloTxt.setText(object.getNome());
        taxaTxt.setText("R$ " + object.getTaxa());
        descricaoTxt.setText(object.getDescricao());
        numOrdemTxt.setText(String.valueOf(numOrdem));
        estrelaTxt.setText(object.getEstrela());
        listaCompraTxt.setText(object.getListaCompra()+" Lista de compra");
        favoritoTxt.setText(object.getFavorito()+" Favorito");
        precoTotalTxt.setText("R$ " + Math.round(numOrdem * object.getTaxa()));


     plusBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             numOrdem = numOrdem + 1;
             numOrdemTxt.setText(String.valueOf(numOrdem));
             precoTotalTxt.setText("R$ " + Math.round(numOrdem * object.getTaxa()));
         }
     });

     minusBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if (numOrdem>1){
                 numOrdem = numOrdem - 1;
             }
             numOrdemTxt.setText(String.valueOf(numOrdem));
             precoTotalTxt.setText("R$ " + Math.round(numOrdem * object.getTaxa()));
         }
     });

     addToCarBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             object.setNumeroNoCarrinho(numOrdem);
             managementCart.insertItem(object);
         }
     });
    }

    private void initView() {
        addToCarBtn = findViewById(R.id.addToCarBtn);
        tituloTxt = findViewById(R.id.tituloTxt);
        taxaTxt = findViewById(R.id.precoTxt);
        descricaoTxt = findViewById(R.id.descricaoTxt);
        numOrdemTxt = findViewById(R.id.numeroItemTxt);
        plusBtn = findViewById(R.id.plusCardBtn);
        minusBtn = findViewById(R.id.minusCardBtn);
        picItem = findViewById(R.id.produtoPic);
        precoTotalTxt = findViewById(R.id.precoTotalTxt);
        estrelaTxt = findViewById(R.id.estrelaTxt);
        favoritoTxt = findViewById(R.id.favoritoTxt);
        listaCompraTxt = findViewById(R.id.listaCompraTxt);
    }
}