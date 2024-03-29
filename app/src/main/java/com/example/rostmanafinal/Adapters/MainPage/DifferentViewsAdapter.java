package com.example.rostmanafinal.Adapters.MainPage;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Pojo.ModelLogedinUser;
import com.example.rostmanafinal.Pojo.ModelMainPage.Car;
import com.example.rostmanafinal.Pojo.ModelMainPage.Item;
import com.example.rostmanafinal.Pojo.ModelMainPage.ModelAddItem;
import com.example.rostmanafinal.Pojo.ModelMainPage.ModelFlowersMainPage;
import com.example.rostmanafinal.Pojo.PojoEnterPost.Example;
import com.example.rostmanafinal.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import retrofit2.http.POST;

public class DifferentViewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> items;
    private List<Car> cars;

    public DifferentViewsAdapter(List<Item> items, List<Car> cars) {
        this.items = items;
        this.cars = cars;
    }

    public void addNewFlower(Item newItem) {
        items.add(newItem);
        notifyItemInserted(0);
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
        if (getItemViewType(position) == 0) {
//            Car car = new Car(position);
//            ModelFlowersMainPage modelFlowersMainPage = (ModelFlowersMainPage) items.get(position).getObject();
//            ((FlowersViewHolder) holder).setFlowerData(car);
            Car car = new Car(position);
            ModelFlowersMainPage modelFlowersMainPage = (ModelFlowersMainPage) items.get(position).getObject();
            Example example = new Example();
//            example.getUser().getProfile();
//            Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(car.setImage(););

//         car.setImage(Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(ImageView););
//            car.setImage(R.drawable.benjamin);
//            ((FlowersViewHolder) holder).setFlowerData(car);
//String coverURl = ((String) cars.get(position).getImage());
//String url = "192.168.88.134:8000";
//            Picasso.get().load(url + example.getProfile().getAvatar().toString()).into((Target) holder);


//      Car car = items.get(position);
//            Picasso.get().load("http://i.imgur.com/DvpvklR.png")
//                    .fit().into(setFlo);

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    ModelFlowersMainPage modelFlowersMainPage = items.get(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "Flower", Toast.LENGTH_SHORT).show();
//                    Navigation.findNavController(itemView).navigate(R.id.action_fragmentHome_to_firstFragment2);
                }
            });
//
        }

        void setFlowerData(Car car) {
            imageFlowers.setImageResource(car.getImage());
        }
//        void setFlowerData(ModelFlowersMainPage modelFlowersMainPage) {
//            imageFlowers.setImageResource(modelFlowersMainPage.getPic());
//            imageAdd.setImageResource(R.drawable.ic_baseline_add_24);
    }
}

/**
 * Second Class (+)
 */
class AddViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageAdd;

    public AddViewHolder(@NonNull View itemView) {
        super(itemView);
        imageAdd = itemView.findViewById(R.id.itemImageAddMainPage);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(itemView.getContext(), "Plus", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setAddData(ModelAddItem modelAddItem) {
        imageAdd.setImageResource(modelAddItem.getPic());

    }
}


