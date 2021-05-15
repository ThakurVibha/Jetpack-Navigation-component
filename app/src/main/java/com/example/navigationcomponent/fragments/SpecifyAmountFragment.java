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


public class SpecifyAmountFragment extends Fragment {
    View view;
    Button next, cancel;
    EditText amount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_specify_amount, container, false);
        next = view.findViewById(R.id.send);
        cancel = view.findViewById(R.id.cancel);
        amount=view.findViewById(R.id.editText);

        //getting the data from Recipientfragment
        SpecifyAmountFragmentArgs.fromBundle(getArguments()).getName();

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
                NavDirections navDirections=SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(
                        SpecifyAmountFragmentArgs.fromBundle(getArguments()).getName(),
                        Integer.parseInt(amount.getText().toString())
);
                Navigation.findNavController(view).navigate(navDirections);
            }
        });
        return view;
    }
}