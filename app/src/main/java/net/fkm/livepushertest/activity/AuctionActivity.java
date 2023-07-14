package net.fkm.livepushertest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import net.fkm.livepushertest.R;

import butterknife.OnClick;

public class AuctionActivity extends AppCompatActivity {
    private WebView webView;


    private Button bt_live;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auction);

//        视图绑定
        bt_live = findViewById(R.id.bt_live);

        webView = findViewById(R.id.wv_webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // 支持JS
        webSettings.setAllowFileAccess(true); // 可以访问文件
        webSettings.setAllowContentAccess(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); // 支持JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); // 支持自动加载图片
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true); // 将图片调整到适合webView的大小
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        // 修改配置，支持http路径的内容，如内嵌的视频
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        webView.loadUrl("http://172.21.240.37:7771/");
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return false;
    }


    @OnClick({R.id.bt_live})
    public void live(View v) {
        switch (v.getId()) {
            case R.id.bt_live:
                startActivity(new Intent(this, HomeActivity.class));
                break;
            default:
                break;
        }
    }

}