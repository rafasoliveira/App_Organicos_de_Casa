package com.odc.organicosdecasa.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.odc.organicosdecasa.Adapter.CarrinhoListAdapter;
import com.odc.organicosdecasa.Helper.ManagementCart;
import com.odc.organicosdecasa.Interface.ChangeNumberItemsListener;
import com.odc.organicosdecasa.R;

import java.text.NumberFormat;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView totalTaxaTxt, taxaTxt, entregaTxt, totalTxt, vazioTxt;
    private Double taxa;
    private ScrollView scrollView;
    private ImageView lixeira;

    Locale localeBR = new Locale("pt","BR");
    NumberFormat nf = NumberFormat.getCurrencyInstance( localeBR );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managementCart = new ManagementCart(this);

        initView();
        initList();
        bottomNavigation();
        calcularCarrinho();
    }

    private void bottomNavigation() {
        LinearLayout inicioBtn = findViewById(R.id.homeBtn);
        LinearLayout pesquisarBtn = findViewById(R.id.searchBtn);
        LinearLayout carrinhoBtn = findViewById(R.id.cartBtn);
        LinearLayout listarBtn = findViewById(R.id.checklistBtn);
        LinearLayout perfilBtn = findViewById(R.id.profileBtn);

        inicioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, MainActivity.class));
            }
        });

        pesquisarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(CartActivity.this, MainActivity.class));
            }
        });

        carrinhoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, CartActivity.class));
            }
        });

        listarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, ListasActivity.class));
            }
        });
        perfilBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, FormLoginActivity.class));
            }
        } );
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CarrinhoListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calcularCarrinho();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()){
            vazioTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            vazioTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calcularCarrinho() {
        double percentTaxa = 0.00;   //se necessário alterar este item para o preço do imposto/taxa
        double entrega = 0.00;        // se necessário alterar este item, preço do frete/entrega

        taxa = (managementCart.getTotalTaxa() * percentTaxa) * 100.0/100.0;
        double total = (managementCart.getTotalTaxa() + taxa + entrega) * 100.0/100.0;
        double itemTotal = (managementCart.getTotalTaxa() * 100.0/100.0);

        totalTaxaTxt.setText(nf.format(itemTotal));
        taxaTxt.setText( nf.format(taxa));
        entregaTxt.setText(nf.format(entrega));
        totalTxt.setText(nf.format(total));
    }

    private void initView() {
        totalTaxaTxt = findViewById(R.id.totalTaxaTxt);
        taxaTxt = findViewById(R.id.taxaTxt);
        entregaTxt = findViewById(R.id.entregaTxt);
        totalTxt = findViewById(R.id.totalTxt);
        recyclerViewList = findViewById(R.id.view);
        scrollView = findViewById(R.id.scrollView);
        vazioTxt = findViewById(R.id.vazioTxt);
        lixeira = findViewById(R.id.imageLixeira);

    }
}