package io.galaxy.pukeeer;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Main_Player_Adapter extends RecyclerView.Adapter<Main_Player_Adapter.ViewHolder> {

    private List<MainPlayerViewModel.Datum> lm;
    View listItem;
    public Main_Player_Adapter(MainActivity mainActivity, List<MainPlayerViewModel.Datum> lm) {
        this.lm = lm;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listItem= layoutInflater.inflate(R.layout.main_player_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Picasso.get().load(lm.get(position).getPlayercirler()).into(holder.liveImage, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                holder.liveImage.setImageResource(R.drawable.ic_launcher_background);
            }
        });



        holder.btnCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItem.getContext().startActivity(new Intent(listItem.getContext(), PlayerActivity.class));
                Player.playername = lm.get(position).getName();
                Player.earnings = lm.get(position).getEarnigs();
                Player.playerdesc = lm.get(position).getDescription();
                Player.playerimage = lm.get(position).getImage();
            }
        });


    }





    @Override
    public int getItemCount() {
        return lm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView liveImage;
        public CardView btnCardView;
        public ViewHolder(View itemView) {
            super(itemView);
            liveImage = itemView.findViewById(R.id.liveImage);
            btnCardView = itemView.findViewById(R.id.btnCardView);
        }
    }
}
