package com.example.surasaklaocharoen.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    //Explicit
    private TextView titleTextView, detailTextView;
    private ImageView iconImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Bind Widget ผูกตัวแปรกับ Layout
        titleTextView = (TextView) findViewById(R.id.textView4);
        detailTextView = (TextView) findViewById(R.id.textView5);
        iconImageView = (ImageView) findViewById(R.id.imageView2);

        //Receive from Intend / รับค่าจากการทำ Intend
        String strTitle = getIntent().getStringExtra("Title"); //รับค่า
        String strDetail = getIntent().getStringExtra("Detail");
        int intIcon = getIntent().getIntExtra("Icon",R.drawable.traffic_01); //ถ้ารับค่าint แล้วว่างต้องใส่ default ให้มันด้วย

        //Show view
        titleTextView.setText(strTitle);
        detailTextView.setText(strDetail);
        iconImageView.setImageResource(intIcon);

    } //Main Method

    public void clickBack(View view) {
        //finish(); //ปิดการทำงาน ให้หน้าสองหายไป เพราะมันซ้อนกันอยู่
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
    }

} //Main Class
