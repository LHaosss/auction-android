package net.fkm.livepushertest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import net.fkm.livepushertest.R;

public class LoaderActivity extends Activity {
    private final int SPLASH_DISPLAY_LENGHT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoaderActivity.this, AuctionActivity.class);
                LoaderActivity.this.startActivity(intent);
                LoaderActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}

