package com.example.barbershop.QuestionType;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barbershop.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Multiple_choice_CheckBox extends Fragment {


    public Multiple_choice_CheckBox(ArrayList<String> testArrayList) {
        TestArrayList = testArrayList;
    }

    MyRecyclerViewAdapter adapter;

    public ArrayList<String> TestArrayList;

    @BindView(R.id.multipleChoiceFragmentQuestionTextId)
    TextView multipleChoiceFragmentQuestionTextId;
    @BindView(R.id.multipleChoiceFragmentRecyclerViewId)
    RecyclerView multipleChoiceFragmentRecyclerViewId;
    @BindView(R.id.multipleChoiceFragmentLinearLayoutId)
    LinearLayout multipleChoiceFragmentLinearLayoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multiple_choice__check_box, container, false);
        ButterKnife.bind(this,view);

        adapter = new MyRecyclerViewAdapter();
        multipleChoiceFragmentRecyclerViewId.setAdapter(adapter);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        multipleChoiceFragmentRecyclerViewId.setLayoutManager(mLayoutManager);

        multipleChoiceFragmentRecyclerViewId.setItemAnimator(new DefaultItemAnimator());

        multipleChoiceFragmentQuestionTextId.setText("Test Question");
        adapter.notifyDataSetChanged();

        return view;
    }

    public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.check_box_item, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder,final int position) {
            holder.checkBox.setText(TestArrayList.get(position));
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(holder.checkBox.isChecked()){
                        Toast.makeText(getContext(), "item number "+ TestArrayList.get(position)+" is unchecked", Toast.LENGTH_SHORT).show();
                        holder.checkBox.setCheckMarkDrawable(null);
                        holder.checkBox.setChecked(false);
                    }else{
                        Toast.makeText(getContext(), "item number "+ TestArrayList.get(position)+" is checked", Toast.LENGTH_SHORT).show();
                        holder.checkBox.setCheckMarkDrawable(R.drawable.check_circle);
                        holder.checkBox.setChecked(true);
                    }


                }
            });
        }

        @Override
        public int getItemCount() {
            return TestArrayList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            CheckedTextView checkBox;
            ConstraintLayout checkedTextViewConstraint;


            public MyViewHolder(View view) {
                super(view);
                checkBox = view.findViewById(R.id.checkedTextViewId);
                checkedTextViewConstraint = view.findViewById(R.id.checkedTextViewConstraintId);
            }
        }
    }

}

