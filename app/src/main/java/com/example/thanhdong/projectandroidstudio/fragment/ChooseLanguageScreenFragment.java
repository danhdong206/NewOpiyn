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

import com.example.thanhdong.projectandroidstudio.activity.OnBoardingScreen1Activity;
import com.example.thanhdong.projectandroidstudio.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChooseLanguageScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChooseLanguageScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseLanguageScreenFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;
    private int mPositionSelected = -1;
    TextView mTxtEnglish, mTxtHindi, mTxtTiengViet;

    Button mBtnChecked;

    public ChooseLanguageScreenFragment() {
        // Required empty public constructor
    }

    public static ChooseLanguageScreenFragment newInstance(int someInt, String someTitle) {
        ChooseLanguageScreenFragment chooseLanguageScreenFragment = new ChooseLanguageScreenFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        args.putString("someTitle", someTitle);
        chooseLanguageScreenFragment.setArguments(args);
        return chooseLanguageScreenFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_language_screen, container, false);
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

        textViewSettings();
        initView();
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    private void textViewSettings() {
        TextView textView = getActivity().findViewById(R.id.text_change_language);

        String text = "You can change Language anytime from settings";

        SpannableString spannableString = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
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

        spannableString.setSpan(clickableSpan, 37, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void initView() {
        mTxtEnglish = getActivity().findViewById(R.id.text_english);
        mTxtEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPositionSelected = 0;
                updateUILanguage(mPositionSelected);
            }
        });

        mTxtHindi = getActivity().findViewById(R.id.text_hindi);
        mTxtHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPositionSelected = 1;
                updateUILanguage(mPositionSelected);
            }
        });

        mTxtTiengViet = getActivity().findViewById(R.id.text_tiengviet);
        mTxtTiengViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPositionSelected = 2;
                updateUILanguage(mPositionSelected);
            }
        });

        mBtnChecked = getActivity().findViewById(R.id.btn_checked);
    }

    private void updateUILanguage(final int positionSelected) {
        if (positionSelected == 0) {
            mTxtEnglish.setTextColor(ContextCompat.getColor(getContext(), R.color.color_text_selected));
            mTxtHindi.setTextColor(ContextCompat.getColor(getContext(), R.color.color_text_default));
            mTxtTiengViet.setTextColor(ContextCompat.getColor(getContext(), R.color.color_text_default));
        } else if (positionSelected == 1) {
            mTxtEnglish.setTextColor(ContextCompat.getColor(getContext(), R.color.color_text_default));
            mTxtHindi.setTextColor(ContextCompat.getColor(getContext(), R.color.color_text_selected));
            mTxtTiengViet.setTextColor(ContextCompat.getColor(getContext(), R.color.color_text_default));
        } else {
            mTxtEnglish.setTextColor(ContextCompat.getColor(getContext(), R.color.color_text_default));
            mTxtHindi.setTextColor(ContextCompat.getColor(getContext(), R.color.color_text_default));
            mTxtTiengViet.setTextColor(ContextCompat.getColor(getContext(), R.color.color_text_selected));
        }

        if (positionSelected >= 0) {
            mBtnChecked.setBackgroundResource(R.drawable.btn_checked);
            mBtnChecked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), OnBoardingScreen1Activity.class);
                    startActivity(intent);
                }
            });
        } else {
            mBtnChecked.setBackgroundResource(R.drawable.btn_check);
        }

    }
}