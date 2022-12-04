package com.odc.organicosdecasa.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

import java.text.DecimalFormat;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView totalTaxaTxt, taxaTxt, entregaTxt, totalTxt, vazioTxt;
    private Double taxa;
    private ScrollView scrollView;
    DecimalFormat df = new DecimalFormat("#,##0.00");

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
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout seachBtn = findViewById(R.id.seachBtn);
        LinearLayout carBtn = findViewById(R.id.carBtn);
        LinearLayout scheduleBtn = findViewById(R.id.scheduleBtn);
        LinearLayout profileBtn = findViewById(R.id.profileBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, MainActivity.class));
            }
        });

        seachBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, MainActivity.class));
            }
        });

        carBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, CartActivity.class));
            }
        });

        scheduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, MainActivity.class));
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, FormLogin.class));
            }
        });
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
        double entrega = 0.00;        // se necessário alterar este item, preço da frete/entrega

        taxa = Math.round((managementCart.getTotalTaxa() * percentTaxa) * 100.0)/100.0;
        double total = Math.round((managementCart.getTotalTaxa() + taxa + entrega) * 100.0)/100.0;
        double itemTotal = Math.round((managementCart.getTotalTaxa()*100.0)/100.0);

        totalTaxaTxt.setText("R$ " + df.format(itemTotal));
        taxaTxt.setText("R$ " + df.format(taxa));
        entregaTxt.setText("R$ " + df.format(entrega));
        totalTxt.setText("R$ " + df.format(total));
    }

    private void initView() {
        totalTaxaTxt = findViewById(R.id.totalTaxaTxt);
        taxaTxt = findViewById(R.id.taxaTxt);
        entregaTxt = findViewById(R.id.entregaTxt);
        totalTxt = findViewById(R.id.totalTxt);
        recyclerViewList = findViewById(R.id.view);
        scrollView = findViewById(R.id.scrollView);
        vazioTxt = findViewById(R.id.vazioTxt);

    }
}