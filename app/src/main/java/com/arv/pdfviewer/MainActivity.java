package com.arv.pdfviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView pdfListView;
    ArrayList<String> pdfName = new ArrayList<>();
    ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfListView = findViewById(R.id.pdfListView);
        pdfName.add("First");
        pdfName.add("Second");
        pdfName.add("Third");
        listViewAdapter = new ListViewAdapter(getApplicationContext(), pdfName);
        pdfListView.setAdapter(listViewAdapter);
        pdfListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                // String name = pdfListView.getItemAtPosition(position).toString();
                String name = pdfName.get(position);
                Intent intent = new Intent(getApplicationContext(), PdfOpener.class);
                intent.putExtra("pdf", name);
                startActivity(intent);//intent to pdf opener class 
            }
        });
    }
}
