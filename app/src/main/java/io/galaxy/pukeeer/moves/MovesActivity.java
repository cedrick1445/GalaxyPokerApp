package io.galaxy.pukeeer.moves;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.galaxy.pukeeer.MainActivity;
import io.galaxy.pukeeer.MainViewModel;
import io.galaxy.pukeeer.Main_Adapter;
import io.galaxy.pukeeer.R;

import static io.galaxy.pukeeer.MainActivity.recyclerView;



public class MovesActivity extends AppCompatActivity {

    private MovesViewModel movesViewModel;
    MoveAdapter moveAdapter;
    int counter;
    public static RecyclerView recyclerView;


    String[] rules={"RAISE","FOLD","CALL","CHECK","OPENING"};
    String[] desc={"If they want to pass the action to the next player, but want to keep their cards, they need to check. In the betting round, you can choose to raise, call, fold or check again by checking. When a person checks, they don't have to put anything in the pot unless they are playing in a game of big blind and/or small blind. If a bet is placed on a player in the blinds, they can choose to bet or raise.",
            "Calling is a mechanism for placing bets. This basically matches the amount invested by another player in the form of a bet or raise. If no one calls, the hand ends and the player who did not call wins the hand. If this hand enters the last round of betting, that is, the river, and player A's bet and player B's bet, then the card enters a showdown and the best hand wins.",
            "A raise is an action that people take when they want to increase their opening bet. After the raise, one will have to deal with the call, fold or raise from another hand. Raising money is related to strong hands or trying to win the pot on the spot through timely bluffing.",
            "Folding is the act of terminating participation. After the fold, no one else needs to bet. When it's their turn to act, players can fold, and they don't want to continue. Most poker players do a lot of folding operations before the flop. The action of folding the card itself involves throwing the card face down at the dealer, who puts it in waste paper ((a stack of folded cards).",
            "When they basically start the next round of betting with their poker hands, they will do it. When a person opens it, it has either been checked with them or it is their first action. In this case, many new players will mistakenly say \"raise\". In this case, the standard should be \"bet\" or \"open\". The opening player will then face other players at the table to call, raise or fold."};
    Integer[] image={R.drawable.raise,R.drawable.fold,R.drawable.call,R.drawable.check,R.drawable.open};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moves);

        initializeMoves();
    }

    private void initializeMoves() {
        List<MovesViewModel> awit = new ArrayList<>();
        for(int i = 0; i < rules.length; i ++ ){
            awit.add(new MovesViewModel(rules[i],desc[i],image[i]));
        }

        recyclerView =findViewById(R.id.mrecycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1,RecyclerView.VERTICAL,false));
        SnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
        moveAdapter = new MoveAdapter(MovesActivity.this,awit);
        recyclerView.setAdapter(moveAdapter);

    }
    public void backClick(View view) {
        onBackPressed();
    }

}