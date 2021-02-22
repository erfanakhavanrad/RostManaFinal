package com.example.rostmanafinal.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rostmanafinal.Interfaces.ChangingFragmentsInterface;
import com.example.rostmanafinal.Pojo.ModelChoosePlant.SeasonalModel;
import com.example.rostmanafinal.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class FlowersAdapter extends RecyclerView.Adapter<FlowersAdapter.TViewHolder> {


    ChangingFragmentsInterface changingFragmentsInterface;
    List<SeasonalModel> mylist = new ArrayList<>() ;
    FragmentActivity activity;
    CallBack callBack;

//    , ChangingFragmentsInterface changingFragmentsInterface
    public FlowersAdapter(CallBack callBack1) {
        this.callBack = callBack1;
    }

    public void setList(List<SeasonalModel> list){
                this.mylist = list;
                notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_item, parent, false);
        TViewHolder holder = new TViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TViewHolder holder, int position) {
        SeasonalModel flower = mylist.get(position);
        holder.flowerName.setText(flower.getName());
//        holder.iamgeEach.setImageResource(flower.getPhoto());
//        holder.iamgeEach.setImageResource(Integer.parseInt("http://192.168.88.134:8000/" + flower.getPhoto()));
        Log.i(TAG, "onBindViewHolder: " + flower.getPhoto());
//        Picasso.with(getContext()).load("http://192.168.88.134:8000/" + model.getPoster_path()).into(movieViewHolder.MoviePhoto);
        Picasso.get().
                load("http://192.168.88.134:8000" + flower.getPhoto())
                .placeholder(R.drawable.logo).into(holder.iamgeEach);

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class TViewHolder extends RecyclerView.ViewHolder {
        TextView flowerName;
        ImageView iamgeEach;


        public TViewHolder(@NonNull final View itemView) {
            super(itemView);
            flowerName = itemView.findViewById(R.id.flowerText);
            iamgeEach = itemView.findViewById(R.id.iamgeEach);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SeasonalModel flowerClass = mylist.get(getAdapterPosition());

                    callBack.callBack(flowerClass);

//                    Navigation.findNavController(activity, R.id.nav_graph).navigate(R.id.action_fragmentCactus_to_fragment_Plant_Details);
//                    Navigation.findNavController(v).navigate(R.id.fragment_Plant_Details);

//                    Navigation.findNavController(v).navigate(R.id.action_fragmentCactus_to_fragment_Plant_Details);

                    // getAdapterPosition()
//                    Intent intent = new Intent(itemView.getContext(), MainActivity.class);
//                    intent.putExtra("id", flowerClass.getName());
//                    itemView.getContext().startActivity(intent);


//                    activity.getSupportFragmentManager();
//                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    Fragment_Plant_Details fn = new Fragment_Plant_Details();
//                    fragmentTransaction.replace(R.id.nav_host_fragment, fn);
//                    fragmentTransaction.commit();
//                    Toast.makeText(itemView.getContext(), "id is " + flowerClass.getName(), Toast.LENGTH_SHORT).show();

//


                }
            });
        }
    }

    public interface CallBack {
        public void callBack (SeasonalModel seasonalModel);
    }

}
