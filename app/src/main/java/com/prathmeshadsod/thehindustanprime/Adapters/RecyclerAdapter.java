package com.prathmeshadsod.thehindustanprime.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.prathmeshadsod.thehindustanprime.Models.Model;
import com.prathmeshadsod.thehindustanprime.R;
import com.prathmeshadsod.thehindustanprime.Web.WebView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context ;
    ArrayList<Model> modelArrayList;

    public RecyclerAdapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout , parent , false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       Model model = modelArrayList.get(position);

        holder.main_title.setText(model.getTitle());
        holder.main_description.setText(model.getDescription());
        holder.main_source_id.setText(model.getSource_id());
        holder.main_putDate.setText(model.getPubDate().substring(0 , 10));




        /*
        Below code i created if Api have null image then it will render no image on recycle view so for handling it
        But it's not working
        */

        if(model.getImage_url() == null) {
            Glide.with(context).load(R.drawable.newspaper_def).override(100 , 100)
                    .into(holder.main_image_url);
        }else {
            // We have to use Glide Library for showing image
            Glide.with(context).load(model.getImage_url()).into(holder.main_image_url);
        }

        /*
        When user click on cardView we have to simply call intent and send data on next activity
         */

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context , WebView.class);
                intent.putExtra("link" , modelArrayList.get(position).getLink());
                context.startActivity(intent);
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String shareText = holder.main_title.getText().toString();
               // String shareDesc = holder.main_description.getText().toString();

               String shareMe ="News Source "+holder.main_source_id.getText().toString() +
                                "\n"+ "Date : "+holder.main_putDate.getText().toString().substring(0,10)+"\n"
                               +"Headline : \n"+ holder.main_title.getText().toString() +"\n"
                                +"Description : \n" + holder.main_description.getText().toString();

                Intent implicit_intent = new Intent();

                implicit_intent.setAction(Intent.ACTION_SEND);
                implicit_intent.setType("text/plain");
                implicit_intent.putExtra(Intent.EXTRA_SUBJECT, "link");
                implicit_intent.putExtra(Intent.EXTRA_TEXT , shareMe);

                context.startActivity(implicit_intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView main_title , main_description , main_putDate , main_source_id;
        CardView cardView;
        ImageView main_image_url;
        ImageView share;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        main_title = itemView.findViewById(R.id.main_title);
        main_description = itemView.findViewById(R.id.main_description);
        main_putDate = itemView.findViewById(R.id.main_pubDate);
        main_source_id = itemView.findViewById(R.id.main_source_id);

        cardView = itemView.findViewById(R.id.cardView);

        main_image_url = itemView.findViewById(R.id.main_image_url);

        share = itemView.findViewById(R.id.share);

    }
}


}
