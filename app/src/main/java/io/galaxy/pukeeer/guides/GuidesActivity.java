package io.galaxy.pukeeer.guides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.galaxy.pukeeer.R;

public class GuidesActivity extends AppCompatActivity {
    private GuidesViewModel guidesViewModel;
    GuidesAdapter guidesAdapter;
    public static RecyclerView recyclerView;


    String[] guide={"How to play No Limit Texas Hold'em","How to play poker","How to play poker in Competition","How to play poker-tips for getting started","How to play poker skills for intermediate level","Advanced poker skills"};
    String[] desc={"No-limit Texas Hold'em, sometimes called \"Texas Hold'em\", is likely to be poker games you see on TV and poker games your friends play in their own family games.\n" +
            "\n" +
            "In short, this is how to play Texas Hold'em:\n" +
            "\n" +
            "\t-Two hole cards: Each player on the table is dealt two cards face down. That's it.\n" +
            "\t-Five community cards: Each player then uses these two cards (or one or none of them) in combination with five shared community cards to make their best five playing \tcards.\n" +
            "\t-Make the best card: The player with the best card (or the player who makes all other players fold) wins the pot! It's that simple.\n" +
            "\t-Betting as much as possible: Four betting rounds, any player can put all the chips in the middle at any time. That's the charm of no-limit poker. The stack doubled (or \ttripled!) is always only one hand away, and complete destruction is only one hand away.\n" +
            "\n" +
            "There are many other great poker games, but in terms of simplicity and absolute popularity, no-limit Texas Hold'em is paramount. The game uniquely combines strategy, psychology, random chance and number operations, which is unmatched by any other popular game.",
            "Before we start with some basic rules of how to play poker, you should first be familiar with the basic poker hand levels. Maybe 90% of beginner mistakes happen when someone thinks they have winning playing cards but not.\n" +
                    "\n" +
                    "You can refer to the hand ranking guide through the link above, but it is actually very simple:\n" +
                    "\n" +
                    "1.Royal flush (same clothes, order A-K-Q-J-T)\n" +
                    "2.Straight Flush (any order is the same, for example 9-8-7-6-5)\n" +
                    "3.Four (four cards of the same value, such as A-A-A-A)\n" +
                    "4.Full house (three kinds and one pair)\n" +
                    "5.Straight Flush (all the same)\n" +
                    "6.Straight line (basic sequence, for example 6-5-4-3-2)\n" +
                    "7.Three (three kinds of cards have the same value, such as 5-5-5)\n" +
                    "8.Two pairs (two pairs, such as 9-9 and 5-5)\n" +
                    "9.Pairing (any pairing, whether it is A-A or 2-2)\n" +
                    "10.High card (no matter what your highest card is)\n" +
                    "\n" +
                    "See? It's not that difficult. Make every effort to remember the ranking of the hands. Test yourself, repeat 100 times or write it out. No matter what the price is. Need a secret tip? Among amateur players, three types of hand ranking errors often occur.",
            "There are two different forms of No Limit Texas Hold'em:\n" +
                    "\n" +
                    "\t-Cash game\n" +
                    "\t-Tournaments\n" +
                    "\n" +
                    "A cash game is a poker game with minimum and maximum buy-in, and the blinds never change. E.g. $1/$2 blinds, minimum $20, maximum buy-in $200.\n" +
                    "\n" +
                    "All players can only play with the money in front of the table, but they can get up and leave at any time. If the player loses all the money, he or she can get more and sit on the table again.\n" +
                    "\n" +
                    "On the other hand, the buy-in amount of the poker tournament is fixed, all the money paid by the players is collected into the prize pool (minus a small part of the organizer's fee. Multiple players are used to accommodate all the players, each from the same Starting chips start\n" +
                    "\n" +
                    "The shutters are small, but gradually increase over time. This forces players to take action, otherwise they will run out of chips. When the player loses all his chips, the tables will merge until only one table remains.\n" +
                    "\n" +
                    "The player at that table collects all the chips from other players and is the winner of the game. The top 10-15% of finalists will receive an increasing share of the prize pool (predetermined by the tournament organizer), while the winners will receive approximately 25-30% of the prize money.",
            "This is the best poker technique you should pay close attention to: Don't play too many hands!\n" +
                    "\n" +
                    "In a standard nine-handed table, you should only play 18-20% of your hands. In the beginning, you usually want to perform well.\n" +
                    "\n" +
                    "But what is a good hand? You can start with 9-9, T-T, J-J, Q-Q, K-K, A-A and A-J, A-Q and A-K. If you are competing with fewer than eight other opponents, you can relax the range.\n" +
                    "\n" +
                    "Also: try to avoid making too many calls. Telephone is one of the favorite games of novices. The reason is easy to understand: new players are not sure what they actually have and whether it is beneficial.\n" +
                    "\n" +
                    "Novice poker players would rather call than bet because they don't want to risk a stronger hand than initially thought.\n" +
                    "\n" +
                    "But this is about poker: betting is more effective than betting. how did it get here? You can win the pot without betting. You cannot do the same thing by calling. It's that simple.\n" +
                    "\n" +
                    "In addition, experienced poker players will drive beginner poker players. Once experienced poker players find a good card, they will bet the right amount of bet on each street, because the rookie will pay it off on each street.\n" +
                    "\n" +
                    "For all these reasons, it is worth betting or reraising even if you are not entirely willing to do so.",
            "Without knowing the background of a hand, you cannot say which hand you want to win at will, but some hands are easier to win than others.\n" +
                    "\n" +
                    "Suppose you have five cents. The flop is A-8-5. This is almost an ideal flop because your hand is very hidden. It will be difficult for people to put you on that precise hand and may even lose a pair of big hands.\n" +
                    "\n" +
                    "You can make the same argument about straight houses and full houses. On the other hand, some hands are difficult to cover. If you travel one-fifth (you have one-fifth in your hand and two on the boat), many people will expect two-thirds.\n" +
                    "\n" +
                    "Straight flushes are equally applicable and easy to recognize even for beginners (although you may find people with lower straight flushes, which is great).\n" +
                    "\n" +
                    "Position is very important in poker!\n" +
                    "What position are you asking? This is the order in which players are forced to bet/bet. After the flop, the order always starts from the player to the left of the dealer.\n" +
                    "\n" +
                    "Usually, it’s always best to go to the end, because you can see what other people in front of you are going to do. These are the four biggest reasons that work:\n" +
                    "\n" +
                    "The four biggest reasons to work:\n" +
                    "\n" +
                    "When it's your turn to take action, you have more information than your opponent.\n" +
                    "The position gives you \"bluffing\", which means simple, cheap and effective bluffing.\n" +
                    "The final action allows you to place value bets more accurately.\n" +
                    "Taking the final action allows you to control the size of the final pot.",
            "Play the player. Once you master the fundamentals, you should start paying close attention to your opponents. You may be surprised to find that a lot of poker reading does not come from subtle physical poker \"talks\" (for example, scratching your nose or playing chips nervously), but from patterns.\n" +
                    "\n" +
                    "If players keep betting, then they are likely to be playing some bad hands. Likewise, if the player keeps folds, then you can assume that they are just playing fairly strong hands. This is very simplified, but it is a basis for reading other players, which is an important part of poker.\n" +
                    "\n" +
                    "Learn some basic poker odds-poker involves math. However, you don’t have to be a digital genius to improve your game.\n" +
                    "\n" +
                    "Just knowing the basic odds behind hitting certain hands can be very beneficial for people who are just starting out.\n" +
                    "\n" +
                    "This is a very simple one for you: 221-1. That is the possibility of getting Pocket A. Statistically speaking, this means that on average you will only get an A for every 221 lots. From the perspective of things, right?\n" +
                    "\n" +
                    "This is a guide to some of the most common odds you will encounter in online poker or live poker:\n" +
                    "\n" +
                    "1.To be paired-17-1 (5.9%)\n" +
                    "2.Ace was beaten — 221-1 (0.45%)\n" +
                    "3.Was named the ace king — 331-1 (0.3%)\n" +
                    "4.Put down a set with pocket pairs -8.5-1 (11.76%)\n" +
                    "5.Flip two pairs (no pocket pair) — 48-1 (2.02%)\n" +
                    "6.Flushing by the river (four times at a time) – 1.9-1 (35%)\n" +
                    "7.Open an open straight by the river — 2.2-1 (32%)\n" +
                    "8.A mansion by the river (failed)-2-1 (33%)"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guides);

        initializeG();
    }

    private void initializeG() {
        List<GuidesViewModel> gud = new ArrayList<>();
        for(int i = 0; i < guide.length; i ++ ){
            gud.add(new GuidesViewModel(guide[i],desc[i]));
        }

        recyclerView =findViewById(R.id.grecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(GuidesActivity.this));
        guidesAdapter = new GuidesAdapter(GuidesActivity.this,gud);
        recyclerView.setAdapter(guidesAdapter);

    }

    public void backClick(View view) {
        onBackPressed();
    }
}