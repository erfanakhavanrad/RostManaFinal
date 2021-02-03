package com.example.rostmanafinal.Adapters.MainPage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Pojo.ModelLogedinUser;
import com.example.rostmanafinal.Pojo.ModelMainPage.Item;
import com.example.rostmanafinal.Pojo.ModelMainPage.ModelAddItem;
import com.example.rostmanafinal.Pojo.ModelMainPage.ModelFlowersMainPage;
import com.example.rostmanafinal.R;

import java.util.List;

import retrofit2.http.POST;

public class DifferentViewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> items;

    public DifferentViewsAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /** Here types are 0 = flowerList, and 1 = add */
        if (viewType == 0) {
            return new FlowersViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.main_page_recycler_item, parent, false));
        } else {
            return new AddViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.main_page_recycler_add_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0){
            ModelFlowersMainPage modelFlowersMainPage = (ModelFlowersMainPage) items.get(position).getObject();
           ((FlowersViewHolder) holder).setFlowerData(modelFlowersMainPage);
        } else {
            ModelAddItem modelAddItem = (ModelAddItem) items.get(position).getObject();
            ((AddViewHolder) holder).setAddData(modelAddItem);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getType();
    }

    /**
     * First Class (Flower list)
     */
    static class FlowersViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageFlowers;

        public FlowersViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFlowers = itemView.findViewById(R.id.itemImageFlowerMainPage);
//
        }

        void setFlowerData(ModelFlowersMainPage modelFlowersMainPage) {
            imageFlowers.setImageResource(modelFlowersMainPage.getPic());
//            imageAdd.setImageResource(R.drawable.ic_baseline_add_24);
        }
    }

    /**
     * Second Class (+)
     */
    static class AddViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageAdd;

        public AddViewHolder(@NonNull View itemView) {
            super(itemView);
            imageAdd = itemView.findViewById(R.id.itemImageAddMainPage);
        }

        void setAddData(ModelAddItem modelAddItem) {
            imageAdd.setImageResource(modelAddItem.getPic());

        }
    }

}
