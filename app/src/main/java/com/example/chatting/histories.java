package com.example.chatting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class histories extends BaseAdapter {
    private Activity context;
    ArrayList<history1> customer;


    public histories(Activity context, ArrayList cust) {
        // super(context, R.layout.row_item, countries);
        this.context = context;
        this.customer=cust;

    }

    public static class ViewHolder
    {
        TextView txt1,txt2,txt3,txt4;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;

        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder vh;
        if(convertView==null) {
            vh=new ViewHolder();
            row = inflater.inflate(R.layout.activity_history2, null, true);
            vh.txt1 = (TextView) row.findViewById(R.id.text1);
            vh.txt2 = (TextView) row.findViewById(R.id.text2);
            vh.txt3 = (TextView) row.findViewById(R.id.text3);
            vh.txt4=(TextView) row.findViewById(R.id.text4);
            // store the holder with the view.
            row.setTag(vh);
        }
        else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.txt2.setText("Your Contact :"+customer.get(position).getName());
        vh.txt1.setText("Price :"+customer.get(position).getOrderNo());
        vh.txt3.setText("Pick Up Location :"+customer.get(position).getQuantity());
        vh.txt4.setText("Drop Off Location :"+customer.get(position).getPrice());
        return  row;
    }

    public long getItemId(int position) {
        return position;
    }

    public Object getItem(int position) {
        return position;
    }

    public int getCount() {

        if(customer.size()<=0)
            return 1;
        return customer.size();
    }
}
