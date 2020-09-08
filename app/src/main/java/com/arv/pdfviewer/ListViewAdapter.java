package com.arv.pdfviewer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> title;
    ArrayList<String> content;
    LayoutInflater inflter;

    public ListViewAdapter(Context applicationContext, ArrayList<String> title) {
        this.context = context;
        this.title = title;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return title.size();
    }

    @Override
    public Object getItem(int i) {
        return "PDF";
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.single_pdf, null);
        TextView Title = (TextView) view.findViewById(R.id.title);
//        TextView Content = (TextView) view.findViewById(R.id.content);
//        if (title.size() > 0 && content.size() > 0) {
           Title.setText(title.get(i));
//            Content.setText(content.get(i));
//        }
        //show pdf thumbnail, text
        return view;
    }
}
