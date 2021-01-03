package com.example.rostmanafinal.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rostmanafinal.Pojo.TableModel;
import com.example.rostmanafinal.R;

import java.util.ArrayList;

public class TableListViewAdapter extends BaseAdapter {

    public ArrayList<TableModel> dataList;
    Activity activity;

    public TableListViewAdapter(Activity activity, ArrayList<TableModel> dataList) {
        super();
        this.activity = activity;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView mSNo;
        TextView mProduct;
        TextView mCategory;
        TextView mPrice;
        TextView mfog;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_row, null);
            holder = new ViewHolder();
            holder.mSNo = (TextView) convertView.findViewById(R.id.sNo);
            holder.mProduct = (TextView) convertView.findViewById(R.id.product);
            holder.mCategory = (TextView) convertView
                    .findViewById(R.id.category);
            holder.mPrice = (TextView) convertView.findViewById(R.id.price);
            holder.mfog = (TextView) convertView.findViewById(R.id.fog);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TableModel item = dataList.get(position);
        holder.mSNo.setText(item.getWatering().toString());
        holder.mProduct.setText(item.getFan().toString());
        holder.mCategory.setText(item.getElement().toString());
        holder.mPrice.setText(item.getLighting().toString());
        holder.mfog.setText(item.getFogger().toString());

        return convertView;
    }

}
