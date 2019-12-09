package com.example.barbershop.QuestionType;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.barbershop.R;

import java.util.ArrayList;

public class CustomAdapterForListWithImage extends BaseAdapter {

    ArrayList<SubjectData> subjectDataArrayList;
    Context context;

    public CustomAdapterForListWithImage(ArrayList<SubjectData> subjectDataArrayList, Context context) {
        this.subjectDataArrayList = subjectDataArrayList;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    // i made change here False to True
    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    // i made change here 0 to size
    @Override
    public int getCount() {
        return subjectDataArrayList.size();
    }

    // i made change here position

    @Override
    public Object getItem(int position) {
        return position;
    }

    // i made change here position

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //the big change is here
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SubjectData subjectData=subjectDataArrayList.get(position);
        if(convertView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.list_row,null,true);

            TextView TheTextList=convertView.findViewById(R.id.TheListText);
            ImageView TheImageList = convertView.findViewById(R.id.TheListImage);

            TheTextList.setText(subjectData.SubjectName);
            TheImageList.setImageResource(subjectData.ImageResources);
        }
        return convertView;
    }

    //i made change here

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    //i made change here
    @Override
    public int getViewTypeCount() {
        return subjectDataArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
