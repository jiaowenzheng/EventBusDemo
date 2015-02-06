package com.android.eventbus.model;

/**
 *
 * @author jiaowenzheng
 * Created by Administrator on 2015/2/5.
 */
public class WallpaperEvent {

    private int wallpaper;

    public WallpaperEvent(int wallpaper){
        this.wallpaper = wallpaper;
    }

    public int getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(int wallpaper) {
        this.wallpaper = wallpaper;
    }
}
