package com.example.navigationcomponent.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.navigationcomponent.R;


public class ConfirmationFragment extends Fragment {

    View view;
    TextView amount, name;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_confirmation, container, false);
        amount = view.findViewById(R.id.amount);
        name = view.findViewById(R.id.name);
        name.setText(ConfirmationFragmentArgs.fromBundle(getArguments()).getName());
        amount.setText(""+ConfirmationFragmentArgs.fromBundle(getArguments()).getAmount());
        return view;

    }
}