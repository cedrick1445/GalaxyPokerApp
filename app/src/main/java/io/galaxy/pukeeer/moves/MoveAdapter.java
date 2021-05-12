package io.galaxy.pukeeer.moves;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.galaxy.pukeeer.R;

public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.ViewHolder>{
    List<MovesViewModel> data;
    Context context;
    TextView rn,rd;
    ImageView img;

    public MoveAdapter(Context context,List<MovesViewModel> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.homeitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rules.setText(data.get(position).getRulename());
        holder.desc.setText(data.get(position).getDescription());
        holder.img.setImageResource(data.get(position).getImage());
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_home_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        rn = myDialog.findViewById(R.id.rname);
        rd = myDialog.findViewById(R.id.rdesc);
        img = myDialog.findViewById(R.id.img);
        for (int i = 0; i<data.size(); i++) {
            if(holder.rules.getText()==data.get(position).getRulename()){
                rn.setText(data.get(position).getRulename());
                rd.setText(data.get(position).getDescription());
                Picasso.get().load(data.get(position).getImage()).into(img);
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView rules;
        public TextView desc;
        public ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            desc = itemView.findViewById(R.id.desc);
            rules = itemView.findViewById(R.id.rule);
        }
    }
}
