package com.example.listviewproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView teamListView;
    ArrayList<Player> playerList = new ArrayList<>();
    String playerName = "";
    String playerPosition = "";
    String playerPoints = "";
    String playerExtra = "";
    TextView playerPositionText;
    TextView playerPointsText;
    TextView nameText;
    TextView contentText;
    ArrayList<String> extraContentList;

    public static final String PPGKEY = "ppgkey";
    public static final String POSITIONKEY = "poskey";
    public static final String LISTKEY = "lstkey";
    public static final String NAMEKEY = "nmkey";
    public static final String EXTRAKEY = "extkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamListView = findViewById(R.id.teamListView);
        nameText = findViewById(R.id.id_nameText);
        playerPositionText = findViewById(R.id.id_playerPositionText);
        playerPointsText = findViewById(R.id.id_playerPointsText);

        extraContentList = new ArrayList<>();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            contentText = findViewById(R.id.contextTextView);
        }

        extraContentList.add("Kawhi Leonard is one of the best two-way players in the NBA. After leading the Toronto Raptors to winning the 2019 NBA Championship, he is now playing" +
                "for the Los Angeles Clippers, alongside the likes of Paul George, Patrick Beverly, and Lou Williams");
        extraContentList.add("Giannis Antetokounmpo, aka the Greek Freak, is the reigning MVP coming into the 2019-20 NBA Season. With Kawhi out of the Easter" +
                "Conference, he is set to lead the Milwaukee Bucks to the top of the Eastern Conference with both his offensive and defensive play");
        extraContentList.add("James Harden is arguably the greatest scorer of our era. His ability to make 3s and get foul calls consistently is uncanny." +
                "The fact that he is averaging about 40 points a game, almost 10 higher than the second-highest scoring player, is absolutely ridiculous");
        extraContentList.add("Luka Doncic is only 20 years old, and is already drawing comparisons to young Lebron James and Michael Jordan. He has averaged a thirty point" +
                "triple-double in November, and has led the Dallas Mavericks to the 5 seed in a hyper-competitive Western Conference");
        extraContentList.add("Lebron James is the King of Basketball looking to reclaim his throne. Following an injury-riddled season that led to him missing the playoffs," +
                "he now plays alongside Anthony Davis in the frontcourt and is putting up numbers unfathomable for a 17-year veteran");
        extraContentList.add("After Jimmy Butler executed a sign-and-trade with the Miami Heat this summer, he has looked like a true leader for this young team. His leadership" +
                "has led the Heat to a winning record, and may possibly even lead them to the playoffs");
        extraContentList.add("Anthony Davis is arguably the best big man in the NBA. Now playing alongside Lebron James, his play has not diminished in the least." +
                "Working on both sides of the floor, he is even in the conversation for Defensive Player of the Year");
        extraContentList.add("This summer, the Toronto Raptors lost Kawhi Leonard, the man who led them to the NBA Championship. Surprisingly, Pascal Siakam, the reigning MIP," +
                "has stepped up and put up Kawhi-like numbers across the board, telling the league that the Raptors are still a force to be reckoned with.");
        extraContentList.add("Damian Lillard is coming off of a strong 2019 campaign which ended in the Western Conference Finals. Notoriously, he quite literally " +
                "ended the OKC Thunder franchise as we once knew it with his 37-foot 3-point dagger. ");
        extraContentList.add("Paul George is now playing alongside Kawhi Leonard, creating one of the most fearsome defensive duos in the NBA. George has come" +
                "strong off of a shoulder injury, and has given consistent strong play when Leonard doesn't play due to 'load management'.");
        extraContentList.add("Karl-Anthony Towns is arguablt the best center in the NBA following the inconsistency of Joel Embiid and Nikola Jokic. He has led the Timberwolves" +
                "from a joke of a franchise to a 0.500 team");

        playerList.add(new Player("Kawhi Leonard", "SF", 25.9, R.drawable.kawhi, extraContentList.get(0)));
        playerList.add(new Player("Giannis Antetokounmpo", "PF", 30.8, R.drawable.giannis, extraContentList.get(1)));
        playerList.add(new Player("James Harden", "PF",39.5, R.drawable.harden, extraContentList.get(2)));
        playerList.add(new Player("Luka Doncic", "SF",33.8, R.drawable.luka, extraContentList.get(3)));
        playerList.add(new Player("Lebron James", "SF",25.6, R.drawable.lebron, extraContentList.get(4)));
        playerList.add(new Player("Jimmy Butler", "SF",19.0, R.drawable.jimmy, extraContentList.get(5)));
        playerList.add(new Player("Anthony Davis", "PF",26.1, R.drawable.anthony, extraContentList.get(6)));
        playerList.add(new Player("Pascal Siakam", "PF",25.1, R.drawable.pascal, extraContentList.get(7)));
        playerList.add(new Player("Damian Lillard", "PG",26.7, R.drawable.damian,extraContentList.get(8)));
        playerList.add(new Player("Paul George", "SF",23.5, R.drawable.paul, extraContentList.get(9)));
        playerList.add(new Player("Karl-Anthony Towns", "C",25.9, R.drawable.karl, extraContentList.get(10)));





        if (savedInstanceState != null) {
            playerPoints = savedInstanceState.getString(PPGKEY);
            playerPosition = savedInstanceState.getString(POSITIONKEY);
            playerName = savedInstanceState.getString(NAMEKEY);
            playerList = (ArrayList<Player>)savedInstanceState.getSerializable(LISTKEY);
            playerExtra = savedInstanceState.getString(EXTRAKEY);

            playerPointsText.setText(playerPoints);
            playerPositionText.setText(playerPosition);
            nameText.setText(playerName);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
               contentText.setText(playerExtra);
            }

        }

        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.adapter_custom, playerList);
        teamListView.setAdapter(customAdapter);

    }


    public class Player implements Serializable {

        String name;
        String position;
        Double points;
        int image;
        String extra;

        public Player(String name, String position, Double points, int image, String extra){
            this.name = name;
            this.position = position;
            this.points = points;
            this.image = image;
            this.extra = extra;
        }

        public String getName(){
            return name;
        }
        public String getPosition(){
            return position;
        }
        public Double getPoints(){
            return points;
        }
        public int getImage(){
            return image;
        }
        public String getExtra() {return extra;}
    }

    public class CustomAdapter extends ArrayAdapter<Player>{
        List<Player> arrayList;
        Context parentContext;
        int xmlResource;
        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Player> objects){
            super(context, resource, objects);
            arrayList = objects;
            parentContext = context;
            xmlResource = resource;
        }

        public void removeMethod() {
            this.notifyDataSetChanged();
        }
        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) parentContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.adapter_custom, null);

            ImageView image = view.findViewById(R.id.id_adapter_image);
            image.setImageResource(playerList.get(position).getImage());
            Button nameButton = view.findViewById(R.id.id_adapter_nameButton);
            nameButton.setText("" + playerList.get(position).getName());

            Button removeButton = view.findViewById(R.id.id_adapter_removeButton);

            nameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerPositionText.setText("Position: " + playerList.get(position).getPosition());
                    playerPointsText.setText("Points Per Game: " + playerList.get(position).getPoints());
                    nameText.setText(playerList.get(position).getName());

                    playerPosition = playerPositionText.getText().toString();
                    playerPoints = playerPointsText.getText().toString();
                    playerName = nameText.getText().toString();
                    playerExtra = playerList.get(position).getExtra();


                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                    contentText.setText(playerList.get(position).getExtra());
                    }
                    }
            });

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(arrayList.get(position).getName().equals(nameText.getText().toString())){
                        if(position == arrayList.size() - 1){
                            playerPositionText.setText("Position: " + playerList.get(0).getPosition());
                            playerPointsText.setText("Points Per Game: " + playerList.get(0).getPoints());
                            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                                contentText.setText(playerList.get(0).getExtra());
                            }
                            nameText.setText(playerList.get(0).getName());

                            playerPosition = playerPositionText.getText().toString();
                            playerPoints = playerPointsText.getText().toString();
                            playerName = nameText.getText().toString();
                            playerExtra = playerList.get(0).getExtra();
                        }
                        else{
                            playerPositionText.setText("Position: " + playerList.get(position+1).getPosition());
                            playerPointsText.setText("Points Per Game: " + playerList.get(position+1).getPoints());
                            nameText.setText(playerList.get(position+1).getName());
                            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                                contentText.setText(playerList.get(position+1).getExtra());
                            }

                            playerPosition = playerPositionText.getText().toString();
                            playerPoints = playerPointsText.getText().toString();
                            playerName = nameText.getText().toString();
                            playerExtra = playerList.get(position+1).getExtra();

                        }
                    }
                    if(arrayList.size()==1){
                        playerPositionText.setText("");
                        playerPointsText.setText("");
                        nameText.setText("");
                        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                            contentText.setText("No More MVP Candidates");
                        }

                        playerPosition = playerPositionText.getText().toString();
                        playerPoints = playerPointsText.getText().toString();
                        playerName = nameText.getText().toString();

                        Toast myToast = Toast.makeText(MainActivity.this, "There are no more players left in the 2019-20 NBA MVP Race!",Toast.LENGTH_LONG);
                        myToast.show();
                    }
                    arrayList.remove(position);
                    extraContentList.remove(position);
                    removeMethod();
                }
            });

            return view;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(PPGKEY, playerPoints);
        outState.putString(POSITIONKEY, playerPosition);
        outState.putString(NAMEKEY, playerName);
        outState.putSerializable(LISTKEY, playerList);
        outState.putString(EXTRAKEY, playerExtra);
    }
}
