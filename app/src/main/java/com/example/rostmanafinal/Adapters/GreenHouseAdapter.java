package com.example.rostmanafinal.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Pojo.FogFunctionByUser;
import com.example.rostmanafinal.Pojo.GreenHouseItems;
import com.example.rostmanafinal.Pojo.StringStatusGreenHouse;
import com.example.rostmanafinal.Pojo.SwitchStatusGreenHouse;
import com.example.rostmanafinal.R;

import java.util.List;

public class GreenHouseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<GreenHouseItems> items;

    public GreenHouseAdapter(List<GreenHouseItems> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//Here types are: 0= trip, 1 = Ads, 2 = News
        if (viewType == 0) {
            return new TripViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_trip, parent, false)

            );
        } else if (viewType == 1) {
            return new AdsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_ads, parent, false));
        } else {
            return new NewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_news, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 0) {
            FogFunctionByUser fogFunctionsByUser = (FogFunctionByUser) items.get(position).getObject();
            ((TripViewHolder) holder).setTripData(fogFunctionsByUser);
        } else if (getItemViewType(position) == 1) {
            SwitchStatusGreenHouse switchStatusGreenHouse = (SwitchStatusGreenHouse) items.get(position).getObject();
            ((AdsViewHolder) holder).setAdsData(switchStatusGreenHouse);
        } else {
            StringStatusGreenHouse stringStatusGreenHouse = (StringStatusGreenHouse) items.get(position).getObject();
            ((NewsViewHolder) holder).setNewsData(stringStatusGreenHouse);
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

//    End


    static class TripViewHolder extends RecyclerView.ViewHolder {
        private SwitchCompat switch1;
        private ImageView imageTrip;
        private TextView textTripTitle, textTrip;

        TripViewHolder(@NonNull View itemView) {
            super(itemView);
            imageTrip = itemView.findViewById(R.id.imageTrip);
//            textTripTitle = itemView.findViewById(R.id.textTripTitle);
            switch1 = itemView.findViewById(R.id.switch1);
            textTrip = itemView.findViewById(R.id.textTrip);
        }

        void setTripData(FogFunctionByUser fogFunctionByUser) {
            imageTrip.setImageResource(fogFunctionByUser.getFogImage());
//            textTripTitle.setText(trip.getTripTitle());
            textTrip.setText(fogFunctionByUser.getFogFunctions());

        }

    }

    static class AdsViewHolder extends RecyclerView.ViewHolder {

        private TextView textAdsTitle, textAds;
        private ImageView  imageAds;
        private SwitchCompat onOrOff;
        public AdsViewHolder(@NonNull View itemView) {
            super(itemView);
//            textAdsTitle = itemView.findViewById(R.id.textAdsTitle);
            textAds = itemView.findViewById(R.id.textAds);
            onOrOff = itemView.findViewById(R.id.onOrOff);
            imageAds = itemView.findViewById(R.id.imageAds);

        }

        void setAdsData(SwitchStatusGreenHouse switchStatusGreenHouse) {
//            textAdsTitle.setText(ads.getAdsTitle());
            textAds.setText(switchStatusGreenHouse.getSwitchStatus());
            imageAds.setImageResource(switchStatusGreenHouse.getSwitchStatusImage());
            onOrOff.setChecked(switchStatusGreenHouse.isSwitchStatusOn());
        }
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {

        private TextView txtValues, textNews;
        private ImageView imageNews;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
//            textNewsTitle = itemView.findViewById(R.id.textNewsTitle);
            textNews = itemView.findViewById(R.id.textNews);
            txtValues = itemView.findViewById(R.id.txtValues);
            imageNews = itemView.findViewById(R.id.imageNews);
        }

        void setNewsData(StringStatusGreenHouse stringStatusGreenHouse) {
//            textNewsTitle.setText(news.getNewsTitle());
            textNews.setText(stringStatusGreenHouse.getStringStatus());
            txtValues.setText(stringStatusGreenHouse.getStringStatusTitle());
            imageNews.setImageResource(stringStatusGreenHouse.getStringStatusImage());
        }

    }

}
