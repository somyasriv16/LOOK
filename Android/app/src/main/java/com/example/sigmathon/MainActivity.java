package com.example.sigmathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

//import com.example.wikipill.NotificationsFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar bottomNav;
    FragmentManager fragmentManager;
    FrameLayout frameLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);

        frameLayout = findViewById(R.id.fragment_container);

        if (savedInstanceState==null){
            bottomNav.setItemSelected(R.id.input,true);
            fragmentManager = getSupportFragmentManager();
            CustomerFragment abc = new CustomerFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container,abc).commit();


        }

        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){

                    case R.id.dashboard:
                        fragment = new NotificationsFragment();

                        break;
                    case R.id.profile:
                        fragment = new ProfileFragment();

                        break;
                    case R.id.input:
                        fragment = new CustomerFragment();



                }

                if (fragment!=null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit();
                }
            }
        });

    }
}
