package com.odc.organicosdecasa.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.odc.organicosdecasa.Activity.ShowDetailActivity;
import com.odc.organicosdecasa.Domain.ItemDomain;
import com.odc.organicosdecasa.R;


import java.util.ArrayList;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {
    ArrayList<ItemDomain> ProdutoDomains;

    public ProdutoAdapter(ArrayList<ItemDomain> ProdutoDomains) {
        this.ProdutoDomains = ProdutoDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_produto, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(ProdutoDomains.get(position).getNome());
        holder.taxa.setText(String.valueOf(ProdutoDomains.get(position).getTaxa()));


        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(ProdutoDomains.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener( v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
            intent.putExtra("object",ProdutoDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });

        holder.pic.setOnClickListener( v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
            intent.putExtra("object", ProdutoDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        } );

    }


    @Override
    public int getItemCount() { return ProdutoDomains.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, taxa;
        ImageView pic;
        ImageView addBtn;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pic = itemView.findViewById(R.id.pic);
            taxa = itemView.findViewById(R.id.taxa);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
