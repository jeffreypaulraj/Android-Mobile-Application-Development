package com.example.listviewdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.id_listView);

        list = new ArrayList<>();

        list.add("Spongebob");
        list.add("Patrick");
        list.add("Squidward");
        list.add("Mr. Krabs");
        list.add("Gary");
        list.add("Larry the Lobster");
        list.add("Sandy");
        list.add("Plankton");
        list.add("Mrs. Puff");
        list.add("Pearl");
        list.add("Karen");
        list.add("Squilliam Fancyson");
        list.add("The Flying Dutchman");
        list.add("King Neptune");


        CustomAdapter customAdapter = new CustomAdapter(this,R.layout.adapter_custom ,list);
        listView.setAdapter(customAdapter);


    }

    public class CustomAdapter extends ArrayAdapter<String>{

        List<String> arrayList;
        Context parentContext;
        int xmlResource;
        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
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

            TextView textView = view.findViewById(R.id.id_adapter_text);
            Button button = view.findViewById(R.id.id_adapter_button);

            textView.setText("Name: " + list.get(position));
            button.setText("Position " + position);
            return view;
        }
    }
}

