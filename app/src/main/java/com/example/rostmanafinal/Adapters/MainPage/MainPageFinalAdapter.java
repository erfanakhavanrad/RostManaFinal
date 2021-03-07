package com.example.rostmanafinal.Adapters.MainPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Pojo.ModelChoosePlant.SecondSeasonalModel;
import com.example.rostmanafinal.Pojo.ModelFirstPage.AllUserInfoModel;
import com.example.rostmanafinal.Pojo.ModelFirstPage.Builder;
import com.example.rostmanafinal.Pojo.ModelFirstPage.Plant;
import com.example.rostmanafinal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainPageFinalAdapter extends RecyclerView.Adapter<MainPageFinalAdapter.MainPageFinalAdapterViewHolder> {
    View v;
    OnItemClickListener onItemClickListener;
    Context context;
    AllUserInfoModel allUserInfoModel;

    public MainPageFinalAdapter(Context context, AllUserInfoModel allUserInfoModel) {
        this.context = context;
        this.allUserInfoModel = allUserInfoModel;
    }

//    public void setList(ArrayList<AllUserInfoModel> list) {
//        this.allUserInfoModelArrayList = list;
//        notifyDataSetChanged();
//    }
//    public void setList(ArrayList<AllUserInfoModel> list) {
//        this.allUserInfoModelArrayList = list;
//        notifyDataSetChanged();
//    }


    @NonNull
    @Override
    public MainPageFinalAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.main_page_final_item, parent, false);
        MainPageFinalAdapterViewHolder mainPageFinalAdapterViewHolder = new MainPageFinalAdapterViewHolder(v);
        return mainPageFinalAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainPageFinalAdapterViewHolder holder, int position) {
//        SecondSeasonalModel plantdetailsClass = plantDetailsList2.get(position);
//        holder.txtTitle.setText(plantdetailsClass.getName());
//        holder.txtValue.setText(plantdetailsClass.getTimeFertilizer().toString());
//        holder.imageIcon.setImageResource(plantdetailsClass.getPhoto());
        //  AllUserInfoModel allUserInfoMode = allUserInfoModelArrayList.get(position);
        Builder builder = allUserInfoModel.getBuilder().get(position);
//        holder.firstFlower.setImageResource();
        Picasso.get().load("http://rostmana.com" + builder.getIcon())
                .placeholder(R.drawable.ic_logocirlce).into(holder.bigImage);

        Picasso.get().load("http://rostmana.com" + builder.getIcon())
                .placeholder(R.drawable.ic_logocirlce).into(holder.firstFlower);

        Picasso.get().load("http://rostmana.com" + builder.getIcon())
                .placeholder(R.drawable.ic_logocirlce).into(holder.secondFlower);

        Picasso.get().load("http://rostmana.com" + builder.getIcon())
                .placeholder(R.drawable.ic_logocirlce).into(holder.thirdFlower);

//        Post model = mpost.get(position);
//
//        movieViewHolder.MovieName.setText(model.getTitle());
//        Picasso.with(getContext()).load("http://image.tmdb.org/t/p/w154" + model.getPoster_path()).into(movieViewHolder.MoviePhoto)
    }

    @Override
    public int getItemCount() {
        return allUserInfoModel.getBuilder().size();
    }


    public class MainPageFinalAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView bigImage, firstFlower, secondFlower, thirdFlower;

        public MainPageFinalAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            bigImage = itemView.findViewById(R.id.bigImage);
            firstFlower = itemView.findViewById(R.id.firstFlower);
            secondFlower = itemView.findViewById(R.id.secondFlower);
            thirdFlower = itemView.findViewById(R.id.thirdFlower);
//            firstFlower
            bigImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(context, "big", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(v).navigate(R.id.action_fragmentHome_to_fragmentGreenHouse);
                }
            });
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
//                    onItemClickListener.onItemClick(getAdapterPosition()
//                            , allUserInfoModel.getBuilder().get(getAdapterPosition())
//                            , allUserInfoModel.getPlants().get(getAdapterPosition()));
//                }
//            });

        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, Builder builder, Plant plant);
    }

    public MainPageFinalAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        return this;
    }
}
