package com.lxqljc.bindingadapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

/**
 * Author: luoxiaoquan
 * Date: 2020/11/15
 * description: 描述
 */
public class ImageViewBindingAdapter {

    @BindingAdapter("image")
    public static void setImage(ImageView image, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(image);
        } else {
            image.setBackgroundColor(Color.DKGRAY);
        }
    }
}
