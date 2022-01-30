package com.prathmeshadsod.thehindustanprime.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.prathmeshadsod.thehindustanprime.Adapters.RecyclerAdapter;
import com.prathmeshadsod.thehindustanprime.Models.Model;
import com.prathmeshadsod.thehindustanprime.Models.ModelMain;
import com.prathmeshadsod.thehindustanprime.R;
import com.prathmeshadsod.thehindustanprime.Retrofit.ApiInterface;
import com.prathmeshadsod.thehindustanprime.Retrofit.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;


public class Home extends Fragment {

    String apikey = "pub_3503268ea12d810dc32be4713fc58108af98";
    String country = "in";
    String language = "en";


    ArrayList<Model> modelArrayList;
    private  RecyclerAdapter recyclerAdapter; // RecyclerAdapter is our custom adapter

    RecyclerView home;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Showing data with the help of Recycler view inside fragment
        home = view.findViewById(R.id.home);
        modelArrayList = new ArrayList<>();
        home.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerAdapter = new RecyclerAdapter(getContext() , modelArrayList);
        home.setAdapter(recyclerAdapter);

        fetchNews();

        return view;
    }

    /* IMPORTANT METHOD  (  Fetching Data from API )  */

    private void fetchNews() {

        RetrofitInstance.getRetrofit().
                create(ApiInterface.class)
                .getNews(apikey ,country,language ) // getNews is in ApiInterface that we have created
                .enqueue(new Callback<ModelMain>() {
                    @Override
                    public void onResponse(Call<ModelMain> call, Response<ModelMain> response) {
                          if(response.isSuccessful()) {

                              modelArrayList.addAll(response.body().getResults());
                              recyclerAdapter.notifyDataSetChanged();
                          }
                    }

                    @Override
                    public void onFailure(Call<ModelMain> call, Throwable t) {

                    }
                });

    }



}