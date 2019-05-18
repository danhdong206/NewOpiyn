package com.example.thanhdong.projectandroidstudio.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.thanhdong.projectandroidstudio.R;
import com.example.thanhdong.projectandroidstudio.RecyclerViewHorizontalAdapter;
import com.example.thanhdong.projectandroidstudio.StaggeredRecyclerViewAdapter;
import com.example.thanhdong.projectandroidstudio.activity.SearchScreenActivity;
import com.example.thanhdong.projectandroidstudio.retrofitmain.Categories;
import com.example.thanhdong.projectandroidstudio.retrofitmain.Highlights;
import com.example.thanhdong.projectandroidstudio.retrofitmain.JsonPlaceHolderApiMain;
import com.example.thanhdong.projectandroidstudio.retrofitmain.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements RecyclerViewHorizontalAdapter.ItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    private OnFragmentInteractionListener mListener;

    private RecyclerViewHorizontalAdapter mAdapter;

    private static final int NUM_COLUMNS = 2;

    StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter;


    private RecyclerView recyclerView;
    ProgressBar progressBar;

    LinearLayoutManager linearLayoutManager;
    private JsonPlaceHolderApiMain jsonPlaceHolderApiMain;
    private Boolean mIsLoading = false;
    private Boolean mIsLastPage = false;
    private int mCurrentPage = 1;

    ProgressDialog progressDialog;


    private ActionBar mToolBar;

    private EditText mEditText;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment mainFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        mainFragment.setArguments(args);
        return mainFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
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

        mEditText = getActivity().findViewById(R.id.edittxt_reviews);
        mEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(getContext(), SearchScreenActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;
            }
        });

        recyclerViewHorizontal();
        staggeredRecyclerView();
//        bottomNavigationView();
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

    public void recyclerViewHorizontal() {
        JsonPlaceHolderApiMain service = RetrofitClientInstance.getRetrofitInstance().create(JsonPlaceHolderApiMain.class);
        Call<Categories> call = service.getCategories();
        call.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                generateDataListHorizontal(response.body());
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemClick(View view, int position) {

    }

    public void generateDataListHorizontal(Categories categories) {
        // set up the RecyclerView
        RecyclerView recyclerView = getActivity().findViewById(R.id.recyclerview_horizontal);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        mAdapter = new RecyclerViewHorizontalAdapter(getContext(), categories.getCategories());
        mAdapter.setClickListener(this);
        recyclerView.setAdapter(mAdapter);
    }

//    private void bottomNavigationView(){
//        mToolBar = ((MainActivity)getActivity()).getSupportActionBar();
//
//        BottomNavigationView navigation = getActivity().findViewById(R.id.bottom_navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//    }
//
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment fragment;
//            switch (item.getItemId()) {
//                case R.id.navigation_library:
//                    return true;
//                case R.id.navigation_shape_square_plus:
//                    return true;
//                case R.id.navigation_bell_outline:
//                    return true;
//            }
//            return false;
//        }
//    };

    private void loadMorePage(final boolean isFirstPage) {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        mIsLoading = true;
        mCurrentPage = mCurrentPage + 1;

        /*Create handle for the RetrofitInstance interface*/
        jsonPlaceHolderApiMain = RetrofitClientInstance.getRetrofitInstance().create(JsonPlaceHolderApiMain.class);
        Call<Highlights> call = jsonPlaceHolderApiMain.getHighlights();
        call.enqueue(new Callback<Highlights>() {
            @Override
            public void onResponse(Call<Highlights> call, Response<Highlights> response) {
                progressDialog.dismiss();
                Highlights result = generateDataListStaggered(response.body());
                if (result == null) {
                    return;
                } else if (!isFirstPage) {
                    staggeredRecyclerViewAdapter.addAll(result.getHighlights());
                } else {
                    staggeredRecyclerViewAdapter.setmDataList(result.getHighlights());
                }

                mIsLoading = false;
                mIsLastPage = mCurrentPage == result.getTotalPages();
            }

            @Override
            public void onFailure(Call<Highlights> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void staggeredRecyclerView() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        jsonPlaceHolderApiMain = RetrofitClientInstance.getRetrofitInstance().create(JsonPlaceHolderApiMain.class);
        mIsLoading = false;
        mIsLastPage = false;
        final int pageSize = 3;

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // number of visible items
                int visibleItemCount = linearLayoutManager.getChildCount();
                // number of items in layout
                int totalItemCount = linearLayoutManager.getItemCount();
                // the position of first visible item
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

                boolean isNotLoadingAndNotLastPage = !mIsLoading && !mIsLastPage;
                // flag if number of visible items is at the last
                boolean isAtLastItem = firstVisibleItemPosition + visibleItemCount >= totalItemCount;
                // validate non negative values
                boolean isValidFirstItem = firstVisibleItemPosition >= 0;
                // validate total items are more than possible visible items
                boolean totalIsMoreThanVisible = totalItemCount >= pageSize;
                // flag to know whether to load more
                boolean shouldLoadMore = isValidFirstItem && isAtLastItem && totalIsMoreThanVisible && isNotLoadingAndNotLastPage;

                if (shouldLoadMore) loadMorePage(false);
            }
        });
    }

    private Highlights generateDataListStaggered(Highlights highlights) {
        RecyclerView recyclerView = getActivity().findViewById(R.id.recyclerview_vertical);
        staggeredRecyclerViewAdapter = new StaggeredRecyclerViewAdapter(getContext(), highlights.getHighlights());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);
        return highlights;
    }

}