package com.example.thanhdong.projectandroidstudio.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.thanhdong.projectandroidstudio.R;
import com.example.thanhdong.projectandroidstudio.fragment.SearchScreenFragment;

public class SearchScreenActivity extends AppCompatActivity implements SearchScreenFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actitvity_search_screen);

        SearchScreenFragment searchScreenFragment = new SearchScreenFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.search_screen_fragment, searchScreenFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
