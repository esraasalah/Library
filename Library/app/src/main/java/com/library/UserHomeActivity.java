package com.library;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;

public class UserHomeActivity extends AppCompatActivity {

    static int flag;

    private Intent i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        VideoView videoView = findViewById(R.id.myVideo);
        String uriPath = "android.resource://"+getPackageName()+"/"+R.raw.vid ;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);

        videoView.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.student_home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.profile:
                 i=new Intent(getApplicationContext(),Profile.class);
                 startActivity(i);
                return true;
            case R.id.print:
                flag = 1;
                i=new Intent(getApplicationContext(),UploadFile.class);
                startActivity(i);
                return true;
            case R.id.designpresentation:
                flag = 2;
                i=new Intent(getApplicationContext(),Presentation.class);
                startActivity(i);
                return true;
            case R.id.translation:
                flag = 3;
                i=new Intent(getApplicationContext(),Translation.class);
                startActivity(i);
                return true;
            case R.id.orders:
                i=new Intent(getApplicationContext(), StudentOrders.class);
                startActivity(i);
                return true;
            case R.id.logout:
                i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
    }


}

}
