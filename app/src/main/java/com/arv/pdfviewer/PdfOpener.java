package com.arv.pdfviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

public class PdfOpener extends AppCompatActivity {

    String name;
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_opener);
        pdfView = findViewById(R.id.pdfOpener);
        name = getIntent().getExtras().getString("pdf");
       // name = "first";
        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
        if(name.equals("First")){
            pdfView.fromAsset("first.pdf").load();
        }else  if(name.equals("Second")){
            pdfView.fromAsset("second.pdf").onLoad(new OnLoadCompleteListener() {
                @Override
                public void loadComplete(int nbPages) {
                    Toast.makeText(getApplicationContext(), "LOADED", Toast.LENGTH_SHORT).show();
                }
            }).load();
        }else  if(name.equals("Third")){
            pdfView.fromAsset("third.pdf").load();
        }
    }
}