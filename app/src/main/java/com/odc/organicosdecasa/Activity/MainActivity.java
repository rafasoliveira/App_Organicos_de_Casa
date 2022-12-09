package com.odc.organicosdecasa.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.odc.organicosdecasa.Adapter.CategoriaAdapter;
import com.odc.organicosdecasa.Adapter.ProdutoAdapter;
import com.odc.organicosdecasa.Domain.CategoriaDomain;
import com.odc.organicosdecasa.Domain.ItemDomain;
import com.odc.organicosdecasa.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter, adapter2;
private RecyclerView recyclerViewCategoriaList, recyclerViewProdutoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategoria();
        recyclerViewProduto();
        bottomNavigation();
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
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        seachBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        carBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });

        scheduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormLogin.class));
            }
        });
    }

    private void recyclerViewProduto() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewProdutoList = findViewById(R.id.recycleView2);
        recyclerViewProdutoList.setLayoutManager(linearLayoutManager);

        ArrayList<ItemDomain> itemList = new ArrayList<>();

        itemList.add(new ItemDomain("Abacate Breda","abacate","Kg", 6.00,5.1));
        itemList.add(new ItemDomain("Abacaxi Pérola","abacaxi","Unid",12.00,5.5));
        itemList.add(new ItemDomain("Laranja","laranja","Pacote 3kg",18.90,3.1));
        itemList.add(new ItemDomain("Limão","limao","Kg",5.00,5.00));
        itemList.add(new ItemDomain("Maça","maca","Kg",23.00,3.40));
        itemList.add(new ItemDomain("Morango","morango","Bandeja",6.00,4.0));

        itemList.add(new ItemDomain("Cebola Roxa","cebola_roxa","400g",7.99,2.6));
        itemList.add(new ItemDomain("Cenoura","cenoura","600g",11.60,2.8));
        itemList.add(new ItemDomain("Mandioquinha","mandioquinha","500g",10.00,4.8));
        itemList.add(new ItemDomain("Milho Verde","milho_verde","Bandeja 700g",7.50,3.9));
        itemList.add(new ItemDomain("Moranga","moranga","Kg",10.0,2.7));
        itemList.add(new ItemDomain("Pimentão Verde","pimentao_verde","Kg",9.00,3.0));
        itemList.add(new ItemDomain("Rabanete","rabanete","Kg",5.0,1.9));
        itemList.add(new ItemDomain("Tomate Italiano","tomate","Kg",5.00,3.1));

        itemList.add(new ItemDomain("Alface Crespa","alface_crespa","Unid",5.50,4.4));
        itemList.add(new ItemDomain("Cebolinha","cebolinha","Maço",2.50,5.0));
        itemList.add(new ItemDomain("Couve","couve","Maço",2.50,4.2));
        itemList.add(new ItemDomain("Salsa","salsa","Maço",2.50,5.0));

        itemList.add(new ItemDomain("Café Torrado","cafe_torrado","250g",10.00,3.5));
        itemList.add(new ItemDomain("Ervilha","ervilha","500g",14.99,4.0));
        itemList.add(new ItemDomain("Feijão Carioca","feijao_carioca","Kg",12.50,5.0));
        itemList.add(new ItemDomain("Feijão Preto","feijao_preto","Kg",10.00,4.6));
        itemList.add(new ItemDomain("Grão de Bico","grao_bico","Kg",19.90,2.4));
        itemList.add(new ItemDomain("Lentilha","lentilha","500g",12.60,3.2));


        adapter2 = new ProdutoAdapter(itemList);
        recyclerViewProdutoList.setAdapter(adapter2);
    }

    private void recyclerViewCategoria() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoriaList = findViewById(R.id.recyclerView1);
        recyclerViewCategoriaList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoriaDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoriaDomain("Frutas","cat_frutas"));
        categoryList.add(new CategoriaDomain("Grãos","cat_graos"));
        categoryList.add(new CategoriaDomain("Legumes","cat_legumes"));
        categoryList.add(new CategoriaDomain("Verduras","cat_verduras"));

        adapter = new CategoriaAdapter(categoryList);
        recyclerViewCategoriaList.setAdapter(adapter);
    }
}