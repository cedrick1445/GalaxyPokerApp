package io.galaxy.pukeeer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import io.galaxy.pukeeer.guides.GuidesActivity;
import io.galaxy.pukeeer.moves.MovesActivity;
import io.galaxy.pukeeer.tips.TipsActivity;

public class MainActivity extends AppCompatActivity {
    public static RecyclerView recyclerView,liveCycle;
    Main_Adapter main_adapter;
    Main_Player_Adapter main_player_adapter;
    private Context context;
    int counter;


    String[] name={"High Card","One Pair","Two Pair","Three of a kind","Straight","Flush","FullHouse","Four of a kind","Straight Flush","Royal Flush"};
    String[] desc={"In the event that a combination can't be made, the player's hand will be viewed as the most worthy single card. In the event that two players have a similar high card, the second most high card will break the tie.",
            "At the point when you have two identical cards, a pair is formed.",
            "At the point when more than one player has two sets, the highest player wins.",
            "At the point when you have three identical cards. Three of a sort is formed.",
            "Straight refers to five cards, consisting of several consecutive cards, and has nothing to do with suits. If two players have straights, the higher hand straight wins.",
            "When you have three identical cards. a Three of a kind is formed.",
            "When a player has three different types and a pair in the same hand, it is called Full House.",
            "When you have a four identical cards at the same time. Four of a kind is formed.",
            "It is rarer than four cards of the same type. A straight flush card consists of five consecutive cards, all from the same deck.",
            "The best of all of these is this famous combination, which is formed by straight flushes that pass through A, so it is unparalleled. The odds for this hand may be as high as 1 in 650,000 trades."};
    Integer[] image={R.drawable.high,R.drawable.onepair,R.drawable.two,R.drawable.trio,R.drawable.straight,R.drawable.flush,R.drawable.fullhouse,R.drawable.four,R.drawable.straightflush,R.drawable.royalflush};

    String[] playername={"Dan Bilzerian","Phil Ivey","Sam Farha","Chris Ferguson","Doyle Brunson","Bryn Kenney","Daniel Negreanu","Justin Bonomo","Tony G","Antonio Esfandiari"};
    String[] earnings={"$200 Million","$100+ Million","$100 Million","$80 Million","$75 Million","$56 Million","$50 Million","$49 Million","$36 Million","$27 Million"};
    String[] playerdesc={"Many are dubious of this claim though, as he received an unknown sum of money from a trust fund, plus has many business ventures, as well as a highly lucrative social media presence.Bilzerian has made some big claims about his poker playing abilities, including that he made $50 million from poker in 2014 alone.He has never won a major tournament, instead claiming that his money comes from cash games only. The social media sensation has also been arrested on various occasions.Regardless of how he got his money though, hes still the richest poker player in the world by far.If you are interested in playing poker, check out our online poker guide.",
            "Many consider Phil Ivey to be one of the greatest players of all time. The American has managed to win 10 WSOP bracelets – only Phil Hellmuth has more.He has also appeared at the final table of the Main Event, finishing 7th in 2009. He has won one WPT title, plus has reached nine final tables.Ivey has won numerous large prizes at tournaments, including AU$4 million for coming first at the 2014 Aussie Millions LK Boutique AU$250,000 Challenge.Ivey is also a successful online player, plus he’s a superb high-stakes cash game player, once winning $16 million in three days playing against Texan billionaire Andy Beal.",
            "Most players will recognize Sam Farha as the man who lost to Chris Moneymaker in the 2003 Main Event. The Lebanese poker player has bagged three WSOP bracelets over the years and although he does play tournaments, he’s better known as a high-stakes Omaha cash game player.Farha’s biggest tournament win, aside from his prize for finishing second at the WSOP Main Event, is $488,241, which he won when finishing first at the 2010 WSOP $10,000 Omaha Hi-Low Split-8 or Better Championship.His wealth also comes from several business interests, TV and movie appearances, and writing books.",
            "It would be fair to say that Chris Ferguson is not the most popular man in poker.He was accused of being one of the people behind a massive Ponzi scheme at Full Tilt Poker, which stole around $444 million from players.Even though he later came out with an apology, it was considered too little, too late by many.Despite his shady behaviour he is still a great player, having won the WSOP Main Event in 2000 in which he scooped a $1.5 million prize.Overall, he has earned nearly $7 million throughout his career in live tournament winnings, with a large percentage of this figure coming from his 90 money finishes at the WSOP.",
            "Doyle Brunson is known as one of the greatest names in poker history.Throughout his career, he won 10 WSOP bracelets and won the Main Event twice, in 1976 and 1977.The retiree also regularly played cash games at Bobby’s Room at the Bellagio, including a limit mixed poker game with $4,000/$8,000 blinds.Overall, Brunson has earned over $6.1 million from live tournament winnings. How much he earned while playing high stakes cash games is unknown.He's also earned money from various other sources, including his book Super System, which is regarded as one of the best poker strategy books ever written.",
            "Bryn Kenney is an American player and perhaps one of the lesser known names on this list.He has only won one WSOP bracelet, however he has finished in the money 32 times. He is number one on the list of the players with the highest tournament earnings ever, with winnings of over $55 million.Kenney is perhaps best-known for winning the highest prize ever awarded at a poker tournament. He won over $20.5 million at the 2019 Triton Million charity event in London.He actually came second, however he made a deal with eventual winner Aaron Zang when he was the chip leader, allowing him to win the larger prize.",
            "Daniel Negreanu is the most famous poker player of all time. His personality has made him a huge hit with fans, and his skill has ensured he’s one of the richest poker players around.\"Kid Poker” has six WSOP bracelets and is the only player to be named WSOP Player of the Year twice. He’s also a member of the Poker Hall of Fame.Overall, Negreanu has won nearly $42 million in tournament prize money and has earned a considerable sum from sponsorship deals, with the biggest seeing him become the face of PokerStars.Negreanu and PokerStars parted ways in 2019 though and he’s now an ambassador for GGPoker, which leaves many wondering which is the best poker room of the two. Check out our PS v GGPoker review to find out!",
            "Next up, we come to Justin Bonomo, who has found huge success in both live and online tournaments.He’s a three-time WSOP bracelet winner and has cashed 55 times at the event. He has also won many large online events, including the Super High Roller Bowl Online in 2020.Bonomo’s biggest ever win came when he won the “Big One for One Drop” tournament in 2018, which added $10 million to his bank account and made him the number one all-time live tournament money winner, until his total was surpassed by Bryn Kenney.",
            "Tony G – real name Antanas Guoga – is one of the loudest, most outspoken poker players around.He’s also a politician in the European Parliament, as well as a successful businessman. He’s never won a WSOP bracelet, however he has finished in the money 15 times.During his poker career, Tony G has won several six-figure prizes. Most of his wealth comes from his business activities though.He is the chief executive officer of Cypherpunk Holdings, an investment company listed on the Canadian Securities Exchange.",
            "At number 10 on this list of the richest poker players is Antonio Esfandiari, one of the best-known players on the poker circuit.The former magician managed to win three World Series of Poker bracelets throughout his career, plus he’s won three WPT titles, with the first coming in 2004 at the L.A. Poker Classic.Esfandiari’s biggest ever win came in 2012, when he won the “Big One for One Drop” tournament at the WSOP. This saw him win a massive $18,346,673 – at the time, the largest ever live poker prize. At one point, he had earned more via tournament winnings than anyone else, until his title was taken by Daniel Negreanu."};
    Integer[] playerimage={R.drawable.danbilzerian,R.drawable.philivey,R.drawable.samfarha,R.drawable.chrisferguson,R.drawable.doylebrunson,R.drawable.brynkenney,R.drawable.danielnegreanu,R.drawable.justinebonomo,R.drawable.tonyg,R.drawable.antonioesfandiari};
    Integer[] playercirle={R.drawable.dan_bilzerian,R.drawable.phili_vey,R.drawable.sam_farha,R.drawable.chris_ferguson,R.drawable.doyle_brunson,R.drawable.bryn_kenney,R.drawable.daniel_negreanu,R.drawable.justine_bonomo,R.drawable.tony_g,R.drawable.antonioes_fandiari};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMain();
        initializePlayer();

        LinearLayout linearLayout1 = findViewById(R.id.clickk1);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getApplicationContext(), MovesActivity.class);
                startActivity(mIntent);
            }
        });
        LinearLayout linearLayout2 = findViewById(R.id.clickk2);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tIntent = new Intent(getApplicationContext(), TipsActivity.class);
                startActivity(tIntent);
            }
        });
        LinearLayout linearLayout3 = findViewById(R.id.clickk3);
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gIntent = new Intent(getApplicationContext(), GuidesActivity.class);
                startActivity(gIntent);
            }
        });
//        context = this.getApplicationContext();
    }
    private void initializeMain() {
        List<MainViewModel.Datum> awit = new ArrayList<>();
        for(int i = 0; i < name.length; i ++ ){
            awit.add(new MainViewModel.Datum(name[i],desc[i],image[i]));
        }

        recyclerView =findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
   
        main_adapter = new Main_Adapter(MainActivity.this,awit);
        recyclerView.setAdapter(main_adapter);
    }
    private void initializePlayer() {
        List<MainPlayerViewModel.Datum> bilog = new ArrayList<>();
        for(int i = 0; i < playercirle.length; i ++){
            bilog.add(new MainPlayerViewModel.Datum(playername[i],earnings[i],playerdesc[i],playerimage[i],playercirle[i]));
        }

        liveCycle =findViewById(R.id.liveRecycleView);
        liveCycle.setHasFixedSize(true);
        liveCycle.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(liveCycle);
        main_player_adapter = new Main_Player_Adapter(MainActivity.this,bilog);
        liveCycle.setAdapter(main_player_adapter);
    }
}