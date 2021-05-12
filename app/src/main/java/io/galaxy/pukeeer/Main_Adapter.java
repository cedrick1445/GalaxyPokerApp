package io.galaxy.pukeeer;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Main_Adapter extends RecyclerView.Adapter<Main_Adapter.ViewHolder> {
    private List<MainViewModel.Datum> lm;
    Context context;
    Dialog myDialog;
    View listItem;
    TextView name,desc;
    ImageView imahe;

    public Main_Adapter(Context context, List<MainViewModel.Datum> MainViewModel) {
        this.context = context;
        this.lm = MainViewModel;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        listItem= layoutInflater.inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.cname.setText(lm.get(position).getName());
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_card_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        name = myDialog.findViewById(R.id.title1);
        desc = myDialog.findViewById(R.id.desc1);
        imahe = myDialog.findViewById(R.id.cardimg);
        for (int i = 0; i<lm.size(); i++) {
            if(holder.cname.getText()==lm.get(position).getName()){

                name.setText(lm.get(position).getName());
                desc.setText(lm.get(position).getDescription());
                Picasso.get().load(lm.get(position).getImage()).into(imahe);
            }
        }
        Picasso.get().load(lm.get(position).getImage()).into(holder.eventThumbnail, new Callback() {
            @Override
            public void onSuccess() {

            }



            @Override
            public void onError(Exception e) {
                holder.eventThumbnail.setImageResource(R.drawable.ic_launcher_background);
            }

        });



        holder.eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lm.size();
    }










    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cname;
        public ImageView eventThumbnail;
        public Button eventBtn;
        public ViewHolder(View itemView) {
            super(itemView);
            cname = itemView.findViewById(R.id.name);
            eventThumbnail = itemView.findViewById(R.id.eventThumbnail);
            eventBtn = itemView.findViewById(R.id.eventBtn);


        }
    }
}
