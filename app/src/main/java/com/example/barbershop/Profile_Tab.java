package com.example.barbershop;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import libs.mjn.prettydialog.PrettyDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_Tab extends Fragment implements AdapterView.OnItemClickListener , AdapterView.OnItemLongClickListener {

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
        listView.setOnItemLongClickListener(this);

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

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()){
            case R.id.lvUser:
                ParseQuery<ParseUser> parseUserParseQuery = ParseUser.getQuery();
                parseUserParseQuery.whereEqualTo("username",arrayList.get(i));
                parseUserParseQuery.getFirstInBackground(new GetCallback<ParseUser>() {
                    @Override
                    public void done(ParseUser object, ParseException e) {
                        if(object!=null && e==null){
                           // Toast.makeText(getContext(), object.get("PictureInfo")+"", Toast.LENGTH_SHORT).show();
                             PrettyDialog prettyDialog=new PrettyDialog(getContext())
                                    .setTitle(object.getUsername()+"")
                                    .setMessage(object.getUsername()+"\n"+object.get("PictureInfo"))
                                    .setIcon(R.drawable.ic_account_circle_black_24dp);
                                    }
                                }
                });

                         break;
                }
        return true;
    }
}
