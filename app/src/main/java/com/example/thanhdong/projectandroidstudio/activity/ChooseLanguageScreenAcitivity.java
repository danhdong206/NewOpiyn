package com.example.thanhdong.projectandroidstudio.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.thanhdong.projectandroidstudio.fragment.ChooseLanguageScreenFragment;
import com.example.thanhdong.projectandroidstudio.R;

public class ChooseLanguageScreenAcitivity extends AppCompatActivity implements ChooseLanguageScreenFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language_screen);

        ChooseLanguageScreenFragment chooseLanguageScreenFragment = new ChooseLanguageScreenFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.choose_language_screen_fragment, chooseLanguageScreenFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
