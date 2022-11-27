package com.odc.organicosdecasa.Helper;

import android.content.Context;
import android.widget.Toast;

import com.odc.organicosdecasa.Domain.ItemDomain;
import com.odc.organicosdecasa.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertItem(ItemDomain item){
        ArrayList<ItemDomain> listItem=getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listItem.size(); i++) {
            if (listItem.get(i).getNome().equals(item.getNome())){
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready){
            listItem.get(n).setNumeroNoCarrinho(item.getNumeroNoCarrinho());
        }else {
            listItem.add(item);
        }

        tinyDB.putListObject("CardList", listItem);
        Toast.makeText(context, "Adicionado ao seu carrinho", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ItemDomain> getListCart() { return tinyDB.getListObject("CardList"); }

    public void minusNumberItem(ArrayList<ItemDomain> listitem, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listitem.get(position).getNumeroNoCarrinho() == 1){
            listitem.remove(position);
        }else {
            listitem.get(position).setNumeroNoCarrinho(listitem.get(position).getNumeroNoCarrinho() - 1);
        }
        tinyDB.putListObject("CardList", listitem);
        changeNumberItemsListener.changed();
    }

    public void plusNumberItem(ArrayList<ItemDomain> listitem, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listitem.get(position).setNumeroNoCarrinho(listitem.get(position).getNumeroNoCarrinho() + 1);
        tinyDB.putListObject("CardList", listitem);
        changeNumberItemsListener.changed();
    }

    public Double getTotalTaxa(){
        ArrayList<ItemDomain>listitem2=getListCart();
        double taxa = 0;
        for (int i = 0; i < listitem2.size(); i++) {
            taxa = taxa + (listitem2.get(i).getTaxa() * listitem2.get(i).getNumeroNoCarrinho());
        }
        return taxa;
    }
}
