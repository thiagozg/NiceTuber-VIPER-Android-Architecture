package br.com.nicetuber.model.adapter;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by thiagozg on 22/10/2017.
 */

public class ImageBinding {

    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView imageView, String url){
        Glide.with(imageView.getContext())
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
    }

}
