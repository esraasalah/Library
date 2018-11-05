package com.library;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;

public class AdminHomeActivity extends AppCompatActivity {
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        VideoView videoView = (VideoView) findViewById(R.id.myVideo2);
        String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.listviews ;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.start();
       // videoView.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.profile:
                i = new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
                return true;

            case R.id.orders:
                i = new Intent(getApplicationContext(), AdminOrders.class);
                startActivity(i);
                return true;
            case R.id.logout:
                i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }


    }
