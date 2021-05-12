package io.galaxy.pukeeer.tips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.galaxy.pukeeer.R;

public class TipsActivity extends AppCompatActivity {
    public static RecyclerView recyclerView;
    private TipsViewModel tipsViewModel;
    TipsAdapter tipsAdapter;

    String[] tnames={"Hit fewer hands and play actively","Don't be the first person in limp line","Semi-bluff and Draw","Fast-Play Your Strong Hands to create the Pot and Make extra money","Defend Your Big Blind (with the Right Hands)","Fold When You’re Unsure",
            "Attack When Your Opponent Shows Weakness","Play Solid Poker Early in Tournaments and Don’t Worry About Survival","Only Play If You Feel Like It","Only Play In Good Games"};
    String[] tdescription={"In No Limit Texas Hold'em, even for the best players in the world, there is a limit on how many starting hands you can play before the flop. If you try to play too many hands, your stack will be wasted (unless lucky it is by your side).",
            "As the first player to enter the pot, a line (just calling the big blind before the flop) is absolutely impossible. There are two main reasons to avoid this situation.You cannot win the pot like a raise before the flop.You provide players with very attractive pot odds, which makes you more likely to face multiple players and therefore less likely to win the pot.",
            "If you want to really crush poker, you need to bluff effectively. But bluffing ineffectively is one of the fastest ways to lose money on the table. So, how do you control the frequency of bluffing? The most effective bluff is the card that allows you to decide whether to bluff. This means using bluffs for bluffing to improve to the best hand on the street later, such as straight draws, flush draws, and even only one or two cards left on the card.",
            "Regrettably, the player checked the nut flush after the flop three times, and then had to awkwardly fiddle with the monster of the poker hand when the opponent retreated to the river. For players who are afraid to drive their opponents out of the pot with a strong poker hand, playing too slowly is a common mistake.In most cases, it is best to bet on your strength to build the pot and protect your assets. This is not to say that you should bet/raise your strong hand after the flop. You can check your strength in the following situations:\n" +
                    "\n" +
                    "-You are unlikely to be eliminated.\n" +
                    "-There are not too many scare cards, which can prevent you from getting paid on the streets in the future.\n" +
                    "-Your opponent's range is more important than a hand with no showdown value.\n" +
                    "However, when you are not sure, please place a bet (if you are not the preflop attacker, please raise). Yes, it is disappointing when your opponent folds, but it is not as disappointing as being eliminated or missing potential value.",
            "Defend Your Big Blind (with the Right Hands)\n" +
                    "\tThe big blind is a special position because you have already invested a big blind in the pot. Therefore, whenever you face a raise while sitting in the big blind, you have a higher pot odds compared to other positions-treat it as a discount.\n" +
                    "Because of your discount and therefore the incontrovertible fact that you're the last person to act preflop, you'll profitably call with more hands than if you were sitting in another position. That’s not to say you should call raises with trash hands like 9♠ 5♦, but the more borderline hands like K♣ 9♦ and Q♥ 6♥ become playable in most situations.\n" +
                    "Exactly how wide you ought to defend depends on a mess of things – here are the four primary ones:\n" +
                    "\n" +
                    "1.Position of the raiser (play tighter against the first positions and looser against the late positions).\n" +
                    "2.Number of players within the hand (when 1 or more players has already called the raise, play tighter and only call with hands that had best in multiway pots).\n" +
                    "3.The size of the raise (the larger the bet sizing, the tighter you ought to play and vice versa).\n" +
                    "4.Stack sizes (when short stacked, play fewer speculative hands and prioritize high card strength).",
            "A good player can let go of a good player like a top pair when he thinks he is defeated.\n" +
                    "This sounds simple, but it is difficult to do in practice, partly because of the way our brains are structured. We are naturally curious, we are born to want to win. When we fold, we give up the chance to win the pot and cannot satisfy our curiosity by discovering what our opponent has.\n" +
                    "\n" +
                    "Calling too frequently under wrong circumstances is the second fastest way to lose poker (after invalid swindling). Whenever you are not sure whether to call, fold, fold or raise, you have to serve yourself and fold.\n" +
                    "\n" +
                    "Expert Tip: When you fold in one of the following situations, make sure to write down the details of your hand so that you can try to determine the correct way to fold. Learning and/or discussing these types of hands is a great way to continuously improve your skills and fill gaps in poker knowledge.",
            "Players will not check with a hand that can often bet multiple times. This means that when they bet, they usually have a relatively weak hand, and if they face multiple bets, they usually fold. This is the \"bluff\" situation I mentioned earlier.",
            "There is a certain time and place to save the stack, not the beginning of the poker game. This is one among the foremost misunderstood aspects of tournament poker strategy.Considering that to make money, you need to at least double or triple your starting stack (usually more). Instead of defensively, you should play solid and aggressive poker as soon as possible to accumulate more chips.",
            "Whether you are a hobby or a professional player, poker should be an interesting experience. When you feel happy, you will perform best. Therefore, you should play this mentally intensive game only when you feel this way.\n" +
                    "\n" +
                    "If you feel frustrated, tired or angry, you should leave the meeting immediately. This is likely to save yourself a lot of money. Poker will still be there tomorrow.\n" +
                    "\n" +
                    "Expert tip: Before the conversation, I imagine going all-in and losing all the chips in the first hand. If the thought of this possibility does not bother me, I know I am ready to play my A game for a long time. However, if all-in and losing one of my buys in the first hand sounds unbearable, I will reconsider the game.",
            "If you can't find a suction cup in the first half an hour on the table, you are a suction cup. As Mike McDermott (played by Mike Damon) said in \"Rounders\" (1998), this is the case now. If you want to play poker and win, you need to fight against players who are weaker than yourself.\n" +
                    "\n" +
                    "Think of it this way: if you are the 9th largest poker player in the world, then you will be the best poker player at almost any table. However, if you enter the table with those 8 players who are better than you, you will become a fool.\n" +
                    "\n" +
                    "You should always put yourself in the position with the greatest chance of winning. This is why it is important to put yourself on the door when playing poker.\n" +
                    "\n" +
                    "Most importantly, if you want to get a positive win rate, it usually needs to be better than half of the table. And, if you want to make a lot of money, you want to play against the worst players.\n" +
                    "\n" +
                    "This is a list of good poker games:\n" +
                    "\n" +
                    "✔️At least one player plays regularly.\n" +
                    "✔️There are many multi-way pots.\n" +
                    "✔️Re-raising is very rare or very frequent.\n" +
                    "\n" +
                    "If you check more than 2 of the check boxes in the game, then you are in a good position to make money. If these boxes are not checked, get up and find a more profitable table (unless you want to test your poker strategy).\n" +
                    "\n" +
                    "If you play online poker, make sure to use the statistical information provided by most poker sites. Choose an online poker table with a high average pot size and a high percentage of players who see the flop. This is a key online poker strategy that new players usually miss."};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        initializeT();   
        
    }

    private void initializeT() {

        List<TipsViewModel> tip = new ArrayList<>();
        for(int i = 0; i < tnames.length; i ++ ){
            tip.add(new TipsViewModel(tnames[i],tdescription[i]));
        }

        recyclerView =findViewById(R.id.trecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(TipsActivity.this));
        tipsAdapter = new TipsAdapter(TipsActivity.this,tip);
        recyclerView.setAdapter(tipsAdapter);


    }
    public void backClick(View view) {
        onBackPressed();
    }


}