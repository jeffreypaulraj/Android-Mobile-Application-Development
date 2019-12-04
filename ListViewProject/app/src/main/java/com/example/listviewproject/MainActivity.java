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
    ArrayList<Player> playerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamListView = findViewById(R.id.teamListView);
        playerList = new ArrayList<>();
        playerList.add(new Player("Kawhi Leonard", "SF/PF", 25.9, R.drawable.kawhi));
        playerList.add(new Player("Giannis Antetokounmpo", "PF", 30.8, R.drawable.giannis));
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.adapter_custom, playerList);
         teamListView.setAdapter(customAdapter);

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

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) parentContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.adapter_custom, null);

            ImageView image = view.findViewById(R.id.id_adapter_image);
            System.out.println("Value: " + image);
            image.setImageResource(playerList.get(position).getImage());
            Button nameButton = view.findViewById(R.id.id_adapter_nameButton);
            nameButton.setText("" + playerList.get(position).getName());
            return view;
        }

    }
}
