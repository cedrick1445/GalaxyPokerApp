package io.galaxy.pukeeer.guides;

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

public class GuidesAdapter extends RecyclerView.Adapter<GuidesAdapter.ViewHolder>{


    List<GuidesViewModel> data;
    Context context;
    TextView gui,dui;

    public GuidesAdapter(Context context, List<GuidesViewModel> data){
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.guideitem, parent, false);
        GuidesAdapter.ViewHolder viewHolder = new GuidesAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.gname.setText(data.get(position).getGuidename());
        holder.gdesc.setText(data.get(position).getDescription());

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_guide_detail);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        gui = myDialog.findViewById(R.id.gtitle12);
        dui = myDialog.findViewById(R.id.gdesc);

        for (int i = 0; i<data.size(); i++) {
            if(holder.gname.getText()==data.get(position).getGuidename()){
                gui.setText(data.get(position).getGuidename());
                dui.setText(data.get(position).getDescription());
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

        public TextView gname;
        public TextView gdesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gname = itemView.findViewById(R.id.guidename);
            gdesc = itemView.findViewById(R.id.guidedesc);
        }
    }
}
