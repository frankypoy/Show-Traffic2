package com.example.surasaklaocharoen.hello;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by surasaklaocharoen on 8/5/16.
 */
public class TrafficAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private int[] iconInts; // ชื่อตัวแปรอะไรก็ได้ ตามด้วยtypeของมันเอง
    private String[] titleStrings, detailStrings;

    //Create Constructor


    public TrafficAdapter(Context context,
                          int[] iconInts,
                          String[] titleStrings,
                          String[] detailStrings) {
        this.context = context;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return iconInts.length; //เพื่อบอกว่าให้มันนับว่าเราส่งมากี่อันเอง
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //Open Service
        //เปิดservice layout เสมือน
        //LayoutInflater layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); + Cast to (Alt+Enter)
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.traffic_listview,viewGroup,false);
        //ส่งlayoutที่ทำมาไปที่ไหน, viewgroupเอาไปทุกอันแบบเป็นกลุ่ม ,​ มี security มั้ยไม่มีก็ false

        //Bind Widget ผูกตัวแปร
        //ImageView iconImageView = view1.findViewById(R.id.imageView); + Cast to (Alt+Enter)
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView);
        TextView titleTextView = (TextView) view1.findViewById(R.id.textView2);
        TextView detailTextView = (TextView) view1.findViewById(R.id.textView3);

        //Show View
        iconImageView.setImageResource(iconInts[i]);  //กำหนดที่มาของภาพ
        titleTextView.setText(titleStrings[i]);
        detailTextView.setText(detailStrings[i]);

        return view1;
    }
} //Main Class
