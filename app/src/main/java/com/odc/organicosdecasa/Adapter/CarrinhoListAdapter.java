package com.odc.organicosdecasa.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.odc.organicosdecasa.Domain.ItemDomain;
import com.odc.organicosdecasa.Helper.ManagementCart;
import com.odc.organicosdecasa.Interface.ChangeNumberItemsListener;
import com.odc.organicosdecasa.R;

import java.util.ArrayList;

public class CarrinhoListAdapter extends RecyclerView.Adapter<CarrinhoListAdapter.ViewHolder> {
    ArrayList<ItemDomain> listItemSelecionado;
    private ManagementCart managementCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CarrinhoListAdapter(ArrayList<ItemDomain> listItemSelecionado, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listItemSelecionado = listItemSelecionado;
        managementCart = new ManagementCart(context);
        this.changeNumberItemsListener=changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_carrinho, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(listItemSelecionado.get(position).getNome());
        holder.taxaCadaItem.setText("R$ " + listItemSelecionado.get(position).getTaxa());
        holder.totalCadaItem.setText("R$ " + Math.round((listItemSelecionado.get(position).getNumeroNoCarrinho() * listItemSelecionado.get(position).getTaxa())));
        holder.num.setText(String.valueOf(listItemSelecionado.get(position).getNumeroNoCarrinho()));


        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(listItemSelecionado.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableReourceId).into(holder.pic);

        holder.plusItem.setOnClickListener(v -> managementCart.plusNumberItem(listItemSelecionado, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));

        holder.minusItem.setOnClickListener(v -> managementCart.minusNumberItem(listItemSelecionado, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));
    }

    @Override
    public int getItemCount() { return listItemSelecionado.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, taxaCadaItem;
        ImageView pic, plusItem, minusItem;
        TextView totalCadaItem, num;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.ttituloxt);
            pic = itemView.findViewById(R.id.pic);
            taxaCadaItem = itemView.findViewById(R.id.taxaCadaitem);
            totalCadaItem = itemView.findViewById(R.id.totalCadaitem);
            plusItem = itemView.findViewById(R.id.plusCardBtn);
            minusItem = itemView.findViewById(R.id.minusCardBtn);
            num = itemView.findViewById(R.id.numeroItemTxt);

        }
    }
}
