package com.example.navigationcomponent.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.navigationcomponent.R;
import com.google.android.material.navigation.NavigationView;


public class RecipientFragment extends Fragment {
    View view;
    Button next,cancel;
    EditText name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_recipient, container, false);
        next=view.findViewById(R.id.send);
        cancel=view.findViewById(R.id.cancel);
        name=view.findViewById(R.id.editText);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to get back to the previous fragment
                Navigation.findNavController(view).navigateUp();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to send data name to
                NavDirections directions=RecipientFragmentDirections.actionRecipientFragmentToSpecifyAmountFragment(name.getText().toString());
                Navigation.findNavController(view).navigate(directions);
            }
        });
        return view;
    }
}