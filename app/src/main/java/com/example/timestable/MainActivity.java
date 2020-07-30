package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvNumbers;
    private SeekBar sb;

    ArrayList<Integer> list;

    private int max = 20;
    private int min = 1;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvNumbers = findViewById(R.id.lvNumbers);
        sb = findViewById(R.id.seekBar);
        sb.setMax(max);


        list = new ArrayList<>();

        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        lvNumbers.setAdapter(arrayAdapter);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                list.clear();
                if (i<min){
                    seekBar.setProgress(min);
                    list.clear();
                }
                for (int j = min; j<=max; j++){
                    list.add(sb.getProgress()*j);
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb.setProgress(10);

    }
}