package com.payment.phonepe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.fragment.app.Fragment;

import com.payment.phonepe.R;

public class Search_Fragment extends Fragment {

    private AutoCompleteTextView autoCompleteTextView;

    public Search_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_, container, false);

        // Find the AutoCompleteTextView by ID
        autoCompleteTextView = view.findViewById(R.id.autocomplete_search);

        // List of suggestions (you can replace this with dynamic data)
        String[] suggestions = {"Android", "Java", "Kotlin", "Flutter", "Python", "Django", "Machine Learning"};

        // Set up ArrayAdapter to display suggestions in AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, suggestions);
        autoCompleteTextView.setAdapter(adapter);

        // Optional: Set the threshold number of characters before suggestions show up
        autoCompleteTextView.setThreshold(1);

        return view;
    }
}
