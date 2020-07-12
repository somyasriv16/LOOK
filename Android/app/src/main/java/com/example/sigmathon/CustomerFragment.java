package com.example.sigmathon;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import it.ngallazzi.fancyswitch.FancySwitch;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerFragment extends Fragment {


    com.github.abdularis.civ.CircleImageView img1;
    it.ngallazzi.fancyswitch.FancySwitch switchB;


    public CustomerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer, container, false);

        img1 = view.findViewById(R.id.img1);
        final LinearLayout linearLayout = view.findViewById(R.id.history);
        final FancySwitch fancySwitch = view.findViewById(R.id.fancySwitch);
        fancySwitch.setSwitchStateChangedListener(new FancySwitch.SwitchStateChangedListener() {
            @Override
            public void onChanged(@NotNull FancySwitch.State newState) {
                Toast.makeText(getContext(),
                        "New switch state: " + newState.name(), Toast.LENGTH_SHORT).show();
                if (newState == FancySwitch.State.ON){
                    fancySwitch.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);
                }
            }
        });



        img1.setImageDrawable(getResources().getDrawable(R.drawable.exmple));


        return view;
    }

}
