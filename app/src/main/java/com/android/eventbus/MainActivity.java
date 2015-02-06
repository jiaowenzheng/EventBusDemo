package com.android.eventbus;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.eventbus.model.MessagesEvent;
import com.android.eventbus.model.WallpaperEvent;

import java.io.IOException;

import de.greenrobot.event.EventBus;


public class MainActivity extends ActionBarActivity {


    private Button mWallpaperButton;
    private Button mMessagesButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册
        EventBus.getDefault().register(this);

        mWallpaperButton = (Button) findViewById(R.id.setting_btn);
        mMessagesButton = (Button) findViewById(R.id.toast_btn);

        mWallpaperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //Wallpaper 事件发布者
                EventBus.getDefault().post(new WallpaperEvent(R.drawable.ic_launcher));
            }
        });

        mMessagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Message 事件发布者
                EventBus.getDefault().post(new MessagesEvent(mMessagesButton.getText().toString()));
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销
        EventBus.getDefault().unregister(this);
    }

    /**
     * Wallpaper事件订阅者。
     * @param wallpaperEvent  事件模型
     */

    public void onEvent(WallpaperEvent wallpaperEvent) {

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        try {
            wallpaperManager.setResource(wallpaperEvent.getWallpaper());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"壁纸设置完成！",Toast.LENGTH_LONG).show();
        Log.i("jiao", "onEvent set Wallpaper  ");
    }

    /**
     * Message 事件订阅者。
     * @param messages Messages事件模型
     */

    public void onEvent(MessagesEvent messages){
        Toast.makeText(this,messages.getMessage(),Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
