package com.example.listviewproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView teamListView;
    ArrayList<Player> playerList = new ArrayList<>();
    String playerName = "";
    String playerPosition = "";
    String playerPoints = "";
    TextView playerPositionText;
    TextView playerPointsText;
    TextView nameText;

    public static final String PPGKEY = "ppgkey";
    public static final String POSITIONKEY = "poskey";
    public static final String LISTKEY = "lstkey";
    public static final String NAMEKEY = "nmkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamListView = findViewById(R.id.teamListView);
        nameText = findViewById(R.id.id_nameText);
        playerPositionText = findViewById(R.id.id_playerPositionText);
        playerPointsText = findViewById(R.id.id_playerPointsText);

        playerList.add(new Player("Kawhi Leonard", "SF", 25.9, R.drawable.kawhi));
        playerList.add(new Player("Giannis Antetokounmpo", "PF", 30.8, R.drawable.giannis));
        playerList.add(new Player("James Harden", "PF",39.5, R.drawable.harden));
        playerList.add(new Player("Luka Doncic", "SF",33.8, R.drawable.luka));
        playerList.add(new Player("Lebron James", "SF",25.6, R.drawable.lebron));
        playerList.add(new Player("Jimmy Butler", "SF",19.0, R.drawable.jimmy));
        playerList.add(new Player("Anthony Davis", "PF",26.1, R.drawable.anthony));
        playerList.add(new Player("Pascal Siakam", "PF",25.1, R.drawable.pascal));
        playerList.add(new Player("Damian Lillard", "PG",26.7, R.drawable.damian));
        playerList.add(new Player("Paul George", "SF",23.5, R.drawable.paul));
        playerList.add(new Player("Karl-Anthony Towns", "C",25.9, R.drawable.karl));

        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.adapter_custom, playerList);
         teamListView.setAdapter(customAdapter);

        if (savedInstanceState != null) {
            playerPoints = savedInstanceState.getString(PPGKEY);
            playerPosition = savedInstanceState.getString(POSITIONKEY);
            playerName = savedInstanceState.getString(NAMEKEY);

            playerPointsText.setText(playerPoints);
            playerPositionText.setText(playerPosition);
            nameText.setText(playerName);
        }

    }


    public class Player{

        String name;
        String position;
        Double points;
        int image;

        public Player(String name, String position, Double points, int image){
            this.name = name;
            this.position = position;
            this.points = points;
            this.image = image;
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

                }
            });

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerList.remove(position);
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
       // outState.putParcelableArrayList(LISTKEY, playerList);
    }
}
