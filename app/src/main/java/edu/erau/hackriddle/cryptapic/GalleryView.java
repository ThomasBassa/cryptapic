package edu.erau.hackriddle.cryptapic;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class GalleryView extends AppCompatActivity {

    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_gallery_view);

            GridView gridview = (GridView) findViewById(R.id.gridview);
            gridview.setAdapter(new ImageAdapter(this));

            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    Toast.makeText(GalleryView.this, "" + position,
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
