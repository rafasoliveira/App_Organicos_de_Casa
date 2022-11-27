package com.odc.organicosdecasa.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.odc.organicosdecasa.Domain.CategoriaDomain;
import com.odc.organicosdecasa.R;

import java.util.ArrayList;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewHolder> {
    ArrayList<CategoriaDomain> categoriaDomains;

    public CategoriaAdapter(ArrayList<CategoriaDomain> categoryDomains) {
        this.categoriaDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_categoria, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoriaDomains.get(position).getTitle());
        String picUrl="";
        switch (position){
            case 0:{
                picUrl = "cat_frutas";
                break;
            }
            case 1:{
                picUrl = "cat_graos2";
                break;
            }
            case 2:{
                picUrl = "cat_legumes";
                break;
            }
            case 3:{
                picUrl = "cat_verduras";
                break;
            }
        }

        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(picUrl,"drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.categoryPic);
    }

    @Override
    public int getItemCount() { return categoriaDomains.size() ; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
