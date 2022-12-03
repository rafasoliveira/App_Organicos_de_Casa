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
                startActivity(new Intent(MainActivity.this, MainActivity.class));
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
                startActivity(new Intent(MainActivity.this, MainActivity.class));
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
        itemList.add(new ItemDomain("Abacate","abacate","Abacate Maduro",6.55,5,0,0));
        itemList.add(new ItemDomain("Abacaxi","abacaxi","",7.90,5,0,0));
        itemList.add(new ItemDomain("Laranja","laranja","",1.10,3,0,0));
        itemList.add(new ItemDomain("Limão","limao","",2.00,5,0,0));
        itemList.add(new ItemDomain("Maça","maca","",1.00,3,0,0));
        itemList.add(new ItemDomain("Morango","morango","",13.00,4,0,0));

        itemList.add(new ItemDomain("Cebola Roxa","cebola_roxa"," ",5.00,2,0,0));
        itemList.add(new ItemDomain("Cenoura","cenoura"," ",5.00,1,0,0));
        itemList.add(new ItemDomain("Mandioquinha","mandioquinha"," ",5.00,4,0,0));
        itemList.add(new ItemDomain("Milho Verde","milho_verde","",5.00,3,0,0));
        itemList.add(new ItemDomain("Moranga","moranga","",0.0,2,0,0));
        itemList.add(new ItemDomain("Pimentão Verde","pimentao_verde","",5.00,3,0,0));
        itemList.add(new ItemDomain("Rabanete","rabanete","",0.0,1,0,0));
        itemList.add(new ItemDomain("Tomate","tomate","Tomate vermelho fresco",5.00,3,0,0));

        itemList.add(new ItemDomain("Alface Crespa","alface_crespa","",4.00,4,0,0));
        itemList.add(new ItemDomain("Cebolinha","cebolinha","",3.00,5,0,0));
        itemList.add(new ItemDomain("Couve","couve","",5.00,4,0,0));
        itemList.add(new ItemDomain("Salsa","salsa","Salva Maço",3.00,5,0,0));

        itemList.add(new ItemDomain("Café Torrado","cafe_torrado","",3.00,5,0,0));
        itemList.add(new ItemDomain("Ervilha","ervilha","",3.00,4,0,0));
        itemList.add(new ItemDomain("Feijao Carioca","feijao_carioca","",8.00,5,0,0));
        itemList.add(new ItemDomain("Feijao Preto","feijao_preto","",7.00,4,0,0));
        itemList.add(new ItemDomain("Grao de Bico","grao_bico","",3.00,2,0,0));
        itemList.add(new ItemDomain("Lentilha","lentilha","",2.00,3,0,0));

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