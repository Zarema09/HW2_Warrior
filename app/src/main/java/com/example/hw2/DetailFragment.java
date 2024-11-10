package com.example.hw2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView warriorDetails = view.findViewById(R.id.warriorDetails);

        Bundle args = getArguments();
        if (args != null) {
            String name = args.getString("name");
            String superAbility = args.getString("superAbility");
            int health = args.getInt("health");
            int damage = args.getInt("damage");

            warriorDetails.setText("Warrior Name: " + name +
                    "\nHealth: " + health +
                    "\nDamage: " + damage +
                    "\nSuperAbility: " + superAbility);
        }
        return view;
    }
}