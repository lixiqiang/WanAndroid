package com.qiang.wanandroid.utils;


import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class GlideUtils {


    public static void loadImage(Context context, String url, ImageView imageView) {

        RequestOptions requestOptions = new RequestOptions()
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.DATA);

        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }
}
