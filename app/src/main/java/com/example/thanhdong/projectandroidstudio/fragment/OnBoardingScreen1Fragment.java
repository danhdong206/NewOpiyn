package com.example.thanhdong.projectandroidstudio.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.thanhdong.projectandroidstudio.activity.MainActivity;
import com.example.thanhdong.projectandroidstudio.R;
import com.example.thanhdong.projectandroidstudio.ViewPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnBoardingScreen1Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OnBoardingScreen1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnBoardingScreen1Fragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    TextView mTextViewPrivacy;
    TextView mTxtTitleOnBoarding;
    Button mBtnGetIn;

    private ViewPager mViewPager;
    private PagerAdapter mAdapter;
    private int[] mImg;
    private static int mCurrentPage = 0;
    private static int mNumPages = 0;

    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    public OnBoardingScreen1Fragment() {
        // Required empty public constructor
    }

    public static OnBoardingScreen1Fragment newInstance(int someInt, String someTitle) {
        OnBoardingScreen1Fragment onBoardingScreen1Fragment = new OnBoardingScreen1Fragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        args.putString("someTitle", someTitle);
        onBoardingScreen1Fragment.setArguments(args);
        return onBoardingScreen1Fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding_screen1, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Window window = getActivity().getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.color_status_bar));

        onBoardingScreen();
        textViewPrivacy();
        mTxtTitleOnBoarding = getActivity().findViewById(R.id.txt_title_on_boarding);

        mBtnGetIn = getActivity().findViewById(R.id.btn_get_in);
        mBtnGetIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBoardingScreen1Fragment.OnFragmentInteractionListener) {
            mListener = (OnBoardingScreen1Fragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void onBoardingScreen() {
        mImg = new int[]{R.drawable.screen_1, R.drawable.screen_2, R.drawable.screen_3, R.drawable.screen_4, R.drawable.screen_5};

        //viewpager code
        mViewPager = (ViewPager) getActivity().findViewById(R.id.view_pager);
        mAdapter = new ViewPagerAdapter(getContext(), mImg);
        mViewPager.setAdapter(mAdapter);

        //circleindicator code
        CircleIndicator indicator = (CircleIndicator) getActivity().findViewById(R.id.indicator);
        indicator.setViewPager(mViewPager);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mCurrentPage = i;
                switch (mCurrentPage) {
                    case 0:
                        mTxtTitleOnBoarding.setText(R.string.title_on_boarding_0);
                        break;
                    case 1:
                        mTxtTitleOnBoarding.setText(R.string.title_on_boarding_1);
                        break;
                    case 2:
                        mTxtTitleOnBoarding.setText(R.string.title_on_boarding_2);
                        break;
                    case 3:
                        mTxtTitleOnBoarding.setText(R.string.title_on_boarding_3);
                        break;
                    case 4:
                        mTxtTitleOnBoarding.setText(R.string.title_on_boarding_4);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void textViewPrivacy() {
        mTextViewPrivacy = getActivity().findViewById(R.id.text_terms_privacy_policy);

        String text = "By continuing, you agree to Opiyn's Terms and Privacy Policy";

        SpannableString spannableString = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                String url = "http://www.vnexpress.net";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#4A4A4A"));
                ds.setUnderlineText(false);
            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                String url = "http://www.vnexpress.net";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#4A4A4A"));
                ds.setUnderlineText(false);
            }
        };

        spannableString.setSpan(clickableSpan1, 36, 41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan2, 46, 60, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTextViewPrivacy.setText(spannableString);
        mTextViewPrivacy.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
