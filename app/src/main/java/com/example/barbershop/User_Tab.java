package com.example.barbershop;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;


/**
 * A simple {@link Fragment} subclass.
 */
public class User_Tab extends Fragment implements View.OnClickListener {


    public User_Tab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user__tab, container,
                false);

        textView4 = view.findViewById( R.id.textView4 );
        editText = view.findViewById( R.id.editText );
        button = view.findViewById( R.id.button );

        button.setOnClickListener( this );

        //final ParseUser parseUser =new ParseUser();

        return view;
    }

    private TextView textView4;
    private EditText editText;
    private Button button;


    @Override
    public void onClick(View v) {
        if ( v == button ) {
            // Handle clicks for button
            textView4.setText(ParseUser.getCurrentUser().getObjectId());

            ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery(ParseUser.getQuery().getClassName());
            parseQuery.getInBackground(ParseUser.getCurrentUser().getObjectId(), new GetCallback<ParseObject>() {
                @Override
                public void done(ParseObject object, ParseException e) {
                    if (object!=null && e==null){
                        FancyToast.makeText(getContext(),object.get("password").toString(),FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                    }
                }
            });

        }
    }

}
