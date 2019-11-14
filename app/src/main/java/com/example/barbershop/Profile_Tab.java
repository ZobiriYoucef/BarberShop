package com.example.barbershop;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_Tab extends Fragment implements AdapterView.OnItemClickListener {

    //varible declaration
    private ListView listView;
    private ArrayList<String> arrayList;
    private ArrayAdapter arrayAdapter;

    // Progress declaration
    private ProgressDialog progressDialog;

    public Profile_Tab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile__tab, container, false);
        listView=view.findViewById(R.id.lvUser);

        // Array list and Array adobter declaration
        arrayList=new ArrayList();
        arrayAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrayList);

        //insialise the item onclick lisner
        listView.setOnItemClickListener(this);

        //Declare the progress dialog and show it
        progressDialog =new ProgressDialog(getActivity());
        progressDialog.setMessage("Wait for the list");
        progressDialog.show();


        // Getting data from the Server
        ParseQuery<ParseUser> parseQuery= ParseUser.getQuery();

        // Elemenate the CurrentUser from show in up in the list
        parseQuery.whereNotEqualTo("username",ParseUser.getCurrentUser().getUsername());
        parseQuery.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if(objects!=null && e==null){
                    if(objects.size()>0){
                        for(ParseUser user:objects){
                         arrayList.add(user.getUsername());
                        }
                        listView.setAdapter(arrayAdapter);
                        progressDialog.dismiss();
                    }
                }
            }
        });



        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        switch (parent.getId()){
            case R.id.lvUser:
                Intent intent=new Intent(getContext(),UserInfo.class);
                intent.putExtra("username",arrayList.get(position));
                startActivity(intent);

        }
    }
}
