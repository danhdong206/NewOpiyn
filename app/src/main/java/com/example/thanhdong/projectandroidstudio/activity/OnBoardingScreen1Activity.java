package com.example.thanhdong.projectandroidstudio.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.thanhdong.projectandroidstudio.fragment.OnBoardingScreen1Fragment;
import com.example.thanhdong.projectandroidstudio.R;

public class OnBoardingScreen1Activity extends AppCompatActivity implements OnBoardingScreen1Fragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen1);

        OnBoardingScreen1Fragment onBoardingScreen1Fragment = new OnBoardingScreen1Fragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.on_boarding_screen1_fragment, onBoardingScreen1Fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
