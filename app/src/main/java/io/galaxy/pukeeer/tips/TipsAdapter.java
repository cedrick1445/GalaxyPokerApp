package io.galaxy.pukeeer.tips;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.galaxy.pukeeer.R;

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.ViewHolder>{

    List<TipsViewModel> data;
    Context context;
    TextView awd,aa;

    public TipsAdapter(Context context,List<TipsViewModel> data){
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.tipsstratitem, parent, false);
        TipsAdapter.ViewHolder viewHolder = new TipsAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tn.setText(data.get(position).getName());
        holder.td.setText(data.get(position).getDescription());

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_tips_strat_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        awd = myDialog.findViewById(R.id.title);
        aa = myDialog.findViewById(R.id.tdesc);
        for (int i = 0; i<data.size(); i++) {
            if(holder.tn.getText()==data.get(position).getName()){
                awd.setText(data.get(position).getName());
                aa.setText(data.get(position).getDescription());
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

        public TextView tn;
        public TextView td;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tn = itemView.findViewById(R.id.tname);
            td = itemView.findViewById(R.id.tdesc);
        }
    }
}
