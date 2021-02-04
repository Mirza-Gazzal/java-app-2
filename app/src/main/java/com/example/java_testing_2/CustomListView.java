package com.example.java_testing_2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomListView extends BaseAdapter {

    Context context;
    String[][] data;
    private static LayoutInflater inflater = null;

    public CustomListView(Context context, String[][] data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.custom_list_row, null);

        TextView header = (TextView) vi.findViewById(R.id.header);
        TextView text = (TextView) vi.findViewById(R.id.text);
        ImageView image = (ImageView) vi.findViewById(R.id.icon);


        header.setText(data[position][0]);
        text.setText(data[position][1]);
       image.setImageDrawable(Drawable.createFromPath(data[position][2]));
        return vi;
    }
}