package com.example.surasaklaocharoen.hello;

import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);

        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.dog);
                mediaPlayer.start();

                //Go to Web View
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://youtu.be/wUZBoDQn3b8"));
                startActivity(intent);

            } //onclick
        });

        //ListView Controller
        //Setup Array Type Easy
        final int[] iconInts = new int[20];
        iconInts[0] = R.drawable.traffic_01;
        iconInts[1] = R.drawable.traffic_02;
        iconInts[2] = R.drawable.traffic_03;
        iconInts[3] = R.drawable.traffic_04;
        iconInts[4] = R.drawable.traffic_05;
        iconInts[5] = R.drawable.traffic_06;
        iconInts[6] = R.drawable.traffic_07;
        iconInts[7] = R.drawable.traffic_08;
        iconInts[8] = R.drawable.traffic_09;
        iconInts[9] = R.drawable.traffic_10;
        iconInts[10] = R.drawable.traffic_11;
        iconInts[11] = R.drawable.traffic_12;
        iconInts[12] = R.drawable.traffic_13;
        iconInts[13] = R.drawable.traffic_14;
        iconInts[14] = R.drawable.traffic_15;
        iconInts[15] = R.drawable.traffic_16;
        iconInts[16] = R.drawable.traffic_17;
        iconInts[17] = R.drawable.traffic_18;
        iconInts[18] = R.drawable.traffic_19;
        iconInts[19] = R.drawable.traffic_20;

        //Setup Array from XML (value -> my_data.xml)
        final String[] titleStrings = getResources().getStringArray(R.array.title);
        final String[] detailLongStrings = getResources().getStringArray(R.array.detailM);


        //การตัดคำให้มันโชว์หน้าแรกแค่ 30 ตัวอักษร
        String[] detailShortStrings = new String[detailLongStrings.length]; //20อัน
        for (int i=0;i<detailLongStrings.length;i+=1) {

            detailShortStrings[i] = detailLongStrings[i].substring(0, 30) + "...";

        } // for


        //Create ListView
        TrafficAdapter trafficAdapter = new TrafficAdapter(this,iconInts,titleStrings,detailShortStrings);
        listView.setAdapter(trafficAdapter);

        //Active When Click ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Title", titleStrings[i]); //ส่งค่า
                intent.putExtra("Icon", iconInts[i]);
                intent.putExtra("Detail", detailLongStrings[i]);
                startActivity(intent);
            }
        });



    } //Main Method

} //Main Class
