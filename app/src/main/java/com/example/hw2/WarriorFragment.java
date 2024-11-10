package com.example.hw2;

import static android.view.View.inflate;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class WarriorFragment extends Fragment {

    private EditText warriorName;
    private EditText warriorDamage;
    private EditText warriorHealth;
    private EditText warriorSuperAbility;
    private Button warriorDetailButton;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_warrior, container, false);

        warriorName = view.findViewById(R.id.et_name);
        warriorDamage = view.findViewById(R.id.etDamage);
        warriorHealth = view.findViewById(R.id.etHealth);
        warriorSuperAbility = view.findViewById(R.id.et_superAbility);
        warriorDetailButton = view.findViewById(R.id.btn_detail);

        warriorDetailButton.setOnClickListener(v -> {
            String name = warriorName.getText().toString();
            int health = Integer.parseInt(warriorHealth.getText().toString());
            int damage = Integer.parseInt(warriorDamage.getText().toString());
            String superAbility = warriorSuperAbility.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("superAbility", superAbility);
            bundle.putInt("damage", damage);
            bundle.putInt("health", health);

            NavHostFragment.findNavController(WarriorFragment.this)
                    .navigate(R.id.action_warriorFragment_to_detailFragment, bundle);
        });
        return view;
    }
}