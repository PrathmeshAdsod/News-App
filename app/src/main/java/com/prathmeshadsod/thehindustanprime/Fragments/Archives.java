package com.prathmeshadsod.thehindustanprime.Fragments;

import android.os.Bundle;

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


/*
    NewsData.io API is not giving access to us for there archives
       They wan't primium subscription for this that's why we created it but can't use it
     */


public class Archives extends Fragment {
    String apikey = "pub_3503268ea12d810dc32be4713fc58108af98";
    String country = "in";
    String language = "en";


    ArrayList<Model> modelArrayList;
    private  RecyclerAdapter recyclerAdapter; // RecyclerAdapter is our custom adapter

    RecyclerView archives;


    public Archives() {
        // Required empty public constructor
    }

    /*
    NewsData.io API is not giving access to us for there archives
       They wan't primium subscription for this that's why we created it but can't use it
     */


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_archives, container, false);

        // Showing data with the help of Recycler view inside fragment
        archives = view.findViewById(R.id.archives);
        modelArrayList = new ArrayList<>();
        archives.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerAdapter = new RecyclerAdapter(getContext() , modelArrayList);
        archives.setAdapter(recyclerAdapter);

        fetchArchiveNews();

        return view;
    }

    private void fetchArchiveNews() {
        RetrofitInstance.getRetrofit().
                create(ApiInterface.class)
                .getArchives(apikey ,country,language ) // getArchives is in ApiInterface that we have created
                .enqueue(new Callback<ModelMain>() {
                    @Override
                    public void onResponse(Call<ModelMain> call, Response<ModelMain> response) {
                        if(response.isSuccessful()) {

                            Toast.makeText(getContext(), "Items : "+response.body().getResults().size(), Toast.LENGTH_LONG).show();
                            modelArrayList.addAll(response.body().getResults());
                            recyclerAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<ModelMain> call, Throwable t) {
                        Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}