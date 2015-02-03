package com.viacom.vengal.newsfeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vengal on 2/2/2015.
 */
public class MyAdapter extends BaseAdapter {
    private List<Item> items = new ArrayList<Item>();
    private LayoutInflater inflater;

    public MyAdapter(Context context,String[] names,int[] images) {
        inflater = LayoutInflater.from(context);
        for (int i=0;i<images.length;i++)
        {
            items.add(new Item(names[i],   images[i]));
        }
        /**items.add(new Item("Top news",       R.drawable.image1));
        items.add(new Item("Sports",   R.drawable.image2));
        items.add(new Item("Technology", R.drawable.image3));
        items.add(new Item("Top picks",      R.drawable.image4));
        items.add(new Item("Local news",     R.drawable.image5));
        items.add(new Item("International",      R.drawable.image6));*/
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if(v == null) {
            v = inflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView)v.getTag(R.id.picture);
        name = (TextView)v.getTag(R.id.text);

        Item item = (Item)getItem(i);

        picture.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;
    }

    private class Item {
        final String name;
        final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}
