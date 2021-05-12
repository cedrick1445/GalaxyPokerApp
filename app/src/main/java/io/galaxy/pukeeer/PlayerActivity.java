package io.galaxy.pukeeer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PlayerActivity extends AppCompatActivity {
TextView name,earn,desc;
ImageView pimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    name = findViewById(R.id.pname);
    earn = findViewById(R.id.earn);
    desc = findViewById(R.id.pdesc);
    pimg = findViewById(R.id.pimg);

    name.setText(Player.playername);
    earn.setText(Player.earnings);
    desc.setText(Player.playerdesc);
    Picasso.get().load(Player.playerimage).into(pimg);


    }
    public void backClick(View view) {
        onBackPressed();
    }
}